package com.aspectsecurity.automationservices.plugins.jenkins.appscanenterprise;

import hudson.AbortException;
import hudson.EnvVars;
import hudson.Launcher;
import hudson.Extension;
import hudson.FilePath;
import hudson.Util;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;
import hudson.model.AbstractProject;
import hudson.model.Computer;
import hudson.model.Node;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.Notifier;
import hudson.tasks.Publisher;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import jenkins.model.Jenkins;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;


import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

import com.aspectsecurity.automationservices.appscanenterprise.utilities.ASEFolder;
import com.aspectsecurity.automationservices.appscanenterprise.utilities.AppScanEnterpriseRESTServicesClient;
import com.aspectsecurity.automationservices.appscanenterprise.utilities.AppScanSourceExecutor;
import org.kohsuke.stapler.QueryParameter;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class AppScanEnterprisePublisher extends Notifier implements SimpleBuildStep {

    Jenkins j = Jenkins.getInstance();
    
    private PrintStream logger;
    
    private String publishTo;
    
    private static String selected;
    private String installation;
    private boolean disableScan;
    private boolean acceptSSL;

    /**
     * We'll use this from the <tt>config.jelly</tt>.
     */
   
	@DataBoundConstructor
    public AppScanEnterprisePublisher(String selected, String installation, boolean disableScan, boolean acceptSSL){
    	this.selected = selected;
    	this.installation = installation;
    	this.disableScan = disableScan;
    	this.acceptSSL = acceptSSL;
    	initAvailableFolders();
    }
	    
    @Override
    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher, TaskListener listener) throws InterruptedException, IOException{
    	Computer computer = Computer.currentComputer();
        if (computer == null) {
            throw new AbortException("The AppScan Enterprise publisher is requires to be launched on a node");
        }
        perform(build, computer.getNode(), workspace, launcher, listener, build.getEnvironment(listener));
    }
    
    public void perform(@Nonnull Run<?, ?> run, @Nonnull Node node, @Nonnull FilePath ws, @Nonnull Launcher launcher, @Nonnull TaskListener listener, EnvVars envVars)
            throws InterruptedException, IOException {

    	logger = listener.getLogger();
    	
    	if(!this.disableScan){
    		
    	
    		//Implementation happens here
    		//Determine if we need to use acceptssl flag
    		String acceptSSLValue="";
    		if(acceptSSL){
    			acceptSSLValue="-acceptssl";
    		}
				
    		//String asmtFilePath = "C:/AppScan_Assessments/" ;
    		String asmtFilePath = "C:/Program Files (x86)/Jenkins/jobs/Webgoat_mvn/builds";
		
    		//Search directory for assessment file
    		logger.println("Searching " + asmtFilePath + " for .ozasmt file");
    		File directory = new File(asmtFilePath);
    		File[] extMatches = directory.listFiles(new FilenameFilter()
				{
					@Override
					public boolean accept(File dir, String name) {
						// TODO Auto-generated method stub
					
					return name.endsWith(".ozasmt");
					//return false;
					}
				});
		
    		String assessmentFile;
		
    		if (extMatches.length == 1){
    			assessmentFile = extMatches[0].getAbsolutePath();
		
    			//Build the script file we'll pass into the AppScan Source CLI
					String cliScriptContent = "login_file " + getDescriptor().getASE_URL() + " " + getDescriptor().getLoginTokenFilePath() + " " + acceptSSLValue + System.lineSeparator();
					cliScriptContent += "pase " + "\"" + assessmentFile + "\"" + " -folder " + selected + System.lineSeparator();
					logger.println("Executing the following command:" + '\n' + cliScriptContent);
					AppScanSourceExecutor.execute(run, ws, launcher, installation, node, listener, envVars, cliScriptContent);
    		}
    		else if (extMatches.length > 1)
    			logger.println("There is more than one .ozasmt file in " + asmtFilePath);
    		else 
    			logger.println("An .ozasmt file could not be found in " + asmtFilePath);	
		
    	} else {
		logger.println("Publish disabled in configuration. Not publishing assessment.");
    	}
    }
    
    /**
     * We'll use this from the <tt>config.jelly</tt>.
     */
	public String getAvailableFolders(){
		return initAvailableFolders();
	}
	
	public String getPublishTo(){
		return publishTo;
	}

	public String getSelected(){
		return selected;
	}
	
    public void setSelected(String selected) {
        this.selected = selected;
    }
	
	public String getInstallation() {
        return installation;
    }
	
	@DataBoundSetter
    public void setInstallation(String installation) {
        this.installation = installation;
    }
	
	 public boolean getDisableScan() {
	        return disableScan;
	    }

	public boolean getAcceptSSL() {
        return acceptSSL;
    }
	
	@DataBoundSetter
    public void setAcceptSSL(boolean acceptSSL) {
        this.acceptSSL = acceptSSL;
    }
	
    public String initAvailableFolders(){
        	AppScanEnterpriseRESTServicesClient client = new AppScanEnterpriseRESTServicesClient(getDescriptor().getASE_Uname(), getDescriptor().getASE_Pword(), getDescriptor().getASEC_URL());
        	ArrayList<ASEFolder> folders = client.getFolderListing();
        	StringBuilder allFolders = new StringBuilder();
            for (ASEFolder folder : folders) {
                allFolders.append(Util.fixEmptyAndTrim(folder.getFullPath())+System.lineSeparator());
            }
            (getDescriptor()).setAvailableFolders(folders);
            return allFolders.toString();   
    }
    
    /*****************************************************************************
     * Descriptor Below
     * @return 
     * 
     ****************************************************************************/
    // Overridden for better type safety.
    @Override
    //public BuildStepDescriptor<Publisher> getDescriptor() {
    public DescriptorImpl getDescriptor() {
    	return (DescriptorImpl)super.getDescriptor();
    }

    //Field Validator Helpers
    public static boolean checkApplicationFileName(String filePath){
    	if ( filePath.endsWith(".paf") || filePath.endsWith(".sln") ){
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean checkApplicationFileNameExists(String filePath){
    	return new File(filePath).exists();
    }
    
    public boolean checkScanWorkspace(String jobScanWorkspace){
    	File path = new File(jobScanWorkspace);
    	if(!path.exists()){
			logger.println("Scan Workspace does not exist.");
			logger.println(path.getAbsolutePath());
			return false;
		}
    	return true;
    }
	
    @Override
	public BuildStepMonitor getRequiredMonitorService() {
		// TODO Auto-generated method stub
		//return null;
    	return BuildStepMonitor.NONE;
	}
    
    public static ListBoxModel completeSelectedModel(ListBoxModel model, ArrayList<ASEFolder> folders){
    	for (ASEFolder folder : folders) {
    		if((Util.fixEmptyAndTrim(folder.getFullPath().substring(1))).equals(selected)){
    			model.add(new ListBoxModel.Option(Util.fixEmptyAndTrim(folder.getFullPath()), Util.fixEmptyAndTrim(folder.getFullPath().substring(1)), true));
    		} else {
    			model.add(new ListBoxModel.Option(Util.fixEmptyAndTrim(folder.getFullPath()), Util.fixEmptyAndTrim(folder.getFullPath().substring(1)), false));
    		}
            
        }
    	
    	return model;
    }

    @Extension // This indicates to Jenkins that this is an implementation of an extension point.
    public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
        /**
         * To persist global configuration information,
         * simply store it in a field and call save().
         *
         * <p>
         * If you don't want fields to be persisted, use <tt>transient</tt>.
         */
    	String LoginTokenFilePath, ASE_Uname, ASE_Pword, ASE_URL, ASEC_URL;
    	ArrayList<ASEFolder> allFolders = new ArrayList<ASEFolder>();
        Jenkins j = Jenkins.getInstance();

        /**
         * In order to load the persisted global configuration, you have to 
         * call load() in the constructor.
         */
        public DescriptorImpl() {
            load();
        }
        
        public void setAvailableFolders(ArrayList<ASEFolder> folders){
        	allFolders = folders;
        }
        
        public String getLoginTokenFilePath() {
			return LoginTokenFilePath;
		}
		public String getASE_URL() {
			return ASE_URL;
		}

		public String getASE_Uname() {
			return ASE_Uname;
		}
		
		public String getASE_Pword() {
			return ASE_Pword;
		}
		
		public String getASEC_URL() {
			return ASEC_URL;
		}
        
		public ListBoxModel doFillInstallationItems() {
            ListBoxModel model = new ListBoxModel();
            for (AppScanSourceInstallation tool : AppScanSourceInstallation.allInstallations()) {
                model.add(Util.fixEmptyAndTrim(tool.getName()));
            }
            return model;
        }

		public ListBoxModel doFillSelectedItems() {
            ListBoxModel model = new ListBoxModel();
            if(!ASE_Uname.equals("") && !ASEC_URL.equals("")){
            	ArrayList<ASEFolder> folders = getFolderListing();
            	model = completeSelectedModel(model, folders);
	           // for (ASEFolder folder : folders) {
	           //     model.add(Util.fixEmptyAndTrim(folder.getFullPath()), folder.getId()+"");
	                
	           // }
            }
            return model;
        }
        
		public ListBoxModel doFillPublishToItems() {
            ListBoxModel model = new ListBoxModel();
            if(!ASE_Uname.equals("") && !ASEC_URL.equals("")){
            	ArrayList<ASEFolder> folders = getFolderListing();
	            for (ASEFolder folder : folders) {
	                model.add(Util.fixEmptyAndTrim(folder.getFullPath()), folder.getId()+"");
	            }
            }
            return model;
        }
		
		public ArrayList<ASEFolder> getFolderListing(){
			if(!ASE_Uname.equals("") && !ASEC_URL.equals("")){
            	AppScanEnterpriseRESTServicesClient client = new AppScanEnterpriseRESTServicesClient(ASE_Uname, ASE_Pword, ASEC_URL);
            	return client.getFolderListing();
			}
			return null;
		}
		
        public FormValidation doCheckASE_URL(@QueryParameter String value)
                throws IOException, ServletException {
            	if(!value.equals("".trim())){
            		return FormValidation.ok();
            	}
         
            return FormValidation.warning("AppScan Enterprise URL is required to publish AppScan Source Assessments.");
        }
        
        public FormValidation doCheckASEC_URL(@QueryParameter String value)
                throws IOException, ServletException {
            	if(!value.equals("".trim())){
            		return FormValidation.ok();
            	}
         
            return FormValidation.warning("AppScan Enterprise Console URL is required to load AppScan Enterprise folder structure.");
        }
        
        public FormValidation doCheckASE_Uname(@QueryParameter String value)
                throws IOException, ServletException {
            	if(!value.equals("".trim())){
            		return FormValidation.ok();
            	}
         
            return FormValidation.warning("AppScan Enterprise Username is required to publish AppScan Source Assessments.");
        }
        
        
        public FormValidation doCheckPublishTo(@QueryParameter String value)
                throws IOException, ServletException {
        	for(ASEFolder folder : allFolders){
        		if(folder.getFullPath().equals(value.trim())){
        			return FormValidation.ok();
        		}
        	}
            return FormValidation.errorWithMarkup("Please provide a folder that exists on the ASE server to publish assessments to. If no options are displayed above, ASE cannot be reached. Please configure the AppScan Enterprise credentials and URL in <a href=\""+ j.getRootUrl() +"configure\" target=\"_new\">the system configuration.</a>.");
        }
        
        public FormValidation doTestConnection(@QueryParameter("ASEC_URL") final String ASEC_URL,
        		@QueryParameter("ASE_Uname") final String ASE_Uname, @QueryParameter("ASE_Pword") final String ASE_Pword ) throws IOException, ServletException {
        	AppScanEnterpriseRESTServicesClient client = new AppScanEnterpriseRESTServicesClient(ASE_Uname, ASE_Pword, ASEC_URL);
        	int responseCode = client.testConnection();
        	if( responseCode == 200){
        		return FormValidation.ok("Success");	
        	}
        	else {
        		return FormValidation.error("Error - received status code: " + responseCode );
        	}
            
        }
        
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            // Indicates that this builder can be used with all kinds of project types 
            return true;
        }

        /**
         * This human readable name is used in the configuration screen.
         */
        public String getDisplayName() {
            return "Publish to AppScan Enterprise";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            // To persist global configuration information,
            // set that to properties and call save().
        	//installation = formData.getString("installation");
        	LoginTokenFilePath = formData.getString("LoginTokenFilePath");
        	ASE_URL = formData.getString("ASE_URL");
        	ASE_Uname = formData.getString("ASE_Uname");
        	ASE_Pword = formData.getString("ASE_Pword");
        	ASEC_URL = formData.getString("ASEC_URL");
            // ^Can also use req.bindJSON(this, formData);
            //  (easier when there are many fields; need set* methods for this, like setUseFrench)
            save();
            return super.configure(req,formData);
        }


		//Field Validators
        
    }

}

