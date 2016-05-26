package com.aspectsecurity.automationservices.appscanenterprise.utilities;

public class SharedPluginConfig {

	private static String ASEURL, loginTokenPath;

	public static String getASEURL() {
		return ASEURL;
	}

	public static void setASEURL(String aSEURL) {
		ASEURL = aSEURL;
	}

	public static String getLoginTokenPath() {
		return loginTokenPath;
	}

	public static void setloginTokenPath(String loginTokenPath) {
		loginTokenPath = loginTokenPath;
	}
	
}
