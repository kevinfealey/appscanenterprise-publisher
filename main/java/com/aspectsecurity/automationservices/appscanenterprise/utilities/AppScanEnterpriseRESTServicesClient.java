package com.aspectsecurity.automationservices.appscanenterprise.utilities;


import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated.Folder;
import com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated.Folders;

public class AppScanEnterpriseRESTServicesClient {

	//private static final String baseUrl = "https://localhost/ase";
	private static final String ASESchemePath = "/services/schema";
	private static final String libertyLoginPath = "/services/login";
	private static final String folderListPath = "/services/folders";
	private static final String libertyLogoutPath = "/services/logout";
	private static final String folderOfFolderPath = "/folders";
	
	private static final String aspSessionIdName = "ASP.NET_SessionId";
	private static final String ascSessionIdName = "asc_session_id";
	
	private static Cookie aspSession;
	private static Cookie ascSession;
	private static Client client;
	
	private static final boolean allowInvalidSSL = true;
	
	private String username;
	private String password;
	private String base_url;
	
	/*public static void main(String args[]) {
		//AppScanEnterpriseRESTServicesClient client = new AppScanEnterpriseRESTServicesClient("vagrant-2012\\vagrant", "vagrant", "https://vagrant-2012/ase");
		//client.getFolderListing();
	}*/

	public AppScanEnterpriseRESTServicesClient(String username, String password, String base_url){
		this.username = username;
		this.password = password;
		this.base_url = base_url;
	}
	
	private WebTarget setupRESTClient(){
		System.out.println("Creating new client");
        if(allowInvalidSSL){
        	client = ClientBuilder.newBuilder().sslContext(allowSelfSignedCertificates()).hostnameVerifier(new HostnameVerifier(){
            @Override
            public boolean verify(String paramString, SSLSession paramSSLSession) {
            	return true;
            }
        	}).build();
        } else {
        	client = ClientBuilder.newClient();
        }
		System.out.println("Returning client..");
		return client.target(base_url);
	}
	
	public int testConnection(){
		int responseCode = login(username, password);
		logout();
		return responseCode;
	}
	
	private int login(String username, String password){
		System.out.println("Logging in");
		WebTarget target = setupRESTClient().path(libertyLoginPath);
		
		System.out.println("Creating form params");
		Form form = new Form();
		form.param("userid", username);
		form.param("password", password);
		
		System.out.println("Sending request...");
		Response response = target.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		if(response.getStatus() == 200){
			System.out.println("Logged in as user: " + username);
			setSessionIdsFromResponse(response.getCookies());
		}
		return response.getStatus();
	}
	
	private static void setSessionIdsFromResponse(Map<String, NewCookie> cookies){
		System.out.println("Saving session IDs:");
		aspSession = new Cookie (aspSessionIdName, cookies.get(aspSessionIdName).getValue());
		ascSession = new Cookie (ascSessionIdName, cookies.get(ascSessionIdName).getValue());
	}
	
	private void login(){
		try{
			ascSession.getValue();
			System.out.println("Already logged in.");
		}catch(NullPointerException e){
			login(username, password);
		}
	}
	
	private void logout(){
		System.out.println("Logging out...");
		WebTarget target = setupRESTClient().path(libertyLogoutPath);
		System.out.println("Sending request...");		
		Response response = target.request().cookie(ascSession).cookie(aspSession).get();
		if (response.getStatus() == 200){
			System.out.println("Logged out");
		}
	}
	
	private void getASESchema(){
		login();
		WebTarget target = setupRESTClient().path(ASESchemePath);
		
		System.out.println("Sending request...");		
		Response response = target.request().cookie(ascSession).cookie(aspSession).get();
		printResponseBody(response);
	}
	
	private ArrayList<ASEFolder> getFoldersofFolder(int folderId){
		String path = folderListPath + "/" + folderId + folderOfFolderPath;
		login();
		WebTarget target = setupRESTClient().path(path);
		Response response = target.request().cookie(ascSession).cookie(aspSession).get();

		return getFoldersFromResponse(response);
	}
	
	private static JAXBElement<Folder> getTopFolderFromResponse(Response response){
		if(response.getStatus() == 200){
			InputStream xml = response.readEntity(InputStream.class);
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Folder.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				JAXBElement<Folder> aseFolder = (JAXBElement<Folder>) jaxbUnmarshaller.unmarshal(xml);
				return aseFolder;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				System.out.println("Unmarshal failed.");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private static ArrayList<ASEFolder> getFoldersFromResponse(Response response){
		InputStream xml = response.readEntity(InputStream.class);
		JAXBContext jaxbContext;
		ArrayList<ASEFolder> ret = new ArrayList<ASEFolder>();
		if(response.getStatus() == 200){
			try {
				jaxbContext = JAXBContext.newInstance(Folder.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				JAXBElement<Folders> aseFolders = (JAXBElement<Folders>) jaxbUnmarshaller.unmarshal(xml);
				ArrayList<Folder> allFolders = (ArrayList<Folder>) aseFolders.getValue().getFolder();
				for (Folder f : allFolders){
					ret.add(new ASEFolder(f.getName().toString(), f.getId(), ""));
				}
				return ret;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				System.out.println("Unmarshal failed.");
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	public ArrayList<ASEFolder> getFolderListing(){
		login();
		ArrayList<ASEFolder> folderListing = new ArrayList<ASEFolder>();
		WebTarget target = setupRESTClient().path(folderListPath);
		
		//Get Top Level folder name
		System.out.println("Sending request...");		
		Response response = target.request().cookie(ascSession).cookie(aspSession).get();

		JAXBElement<Folder> topFolder = getTopFolderFromResponse(response);
		
		folderListing = findAllFolders(new ArrayList<ASEFolder>(), new ASEFolder (topFolder.getValue().getName(), 1, "/"+topFolder.getValue().getName()), "");
	
		for (ASEFolder f : folderListing){
			System.out.println("Folder: " + f.getFullPath().toString() + " | ID: " + f.getId());
			
		}
		return folderListing;
	}
	
	private ArrayList<ASEFolder> findAllFolders(ArrayList<ASEFolder> retVal, ASEFolder currentFolder, String parentName){
		currentFolder.setFullPath(parentName + "/" + currentFolder.getName());
		retVal.add(currentFolder);
		ArrayList<ASEFolder> childFolders = getFoldersofFolder(currentFolder.getId());
		if(childFolders.isEmpty()) return retVal;
		else {
			for (int x = 0; x < childFolders.size(); x++){
				findAllFolders(retVal, childFolders.get(x), currentFolder.getFullPath());
			}	
		}
		return retVal;
		
	}
	
	private static void printResponseBody(Response response){
		System.out.println("Full response: ");
		System.out.println(response.readEntity(String.class));
	}
	
	private static void printHeaders(Response response){
		MultivaluedMap<String, Object> headers = response.getHeaders();
		Set<String> headerKeys = headers.keySet();
		System.out.println("Headers:");
		for(String headerName : headerKeys){
			System.out.println("Name: " + headerName + " | " + headers.get(headerName));
		}
	}
	
	private static SSLContext allowSelfSignedCertificates(){
        SSLContext ctx = null;
        TrustManager[] trustAllCerts = new X509TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
 
            try {
            	ctx = SSLContext.getInstance("SSL");
				ctx.init(null, trustAllCerts, null);
			} catch (KeyManagementException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch ( NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            return ctx;
	}	
}
