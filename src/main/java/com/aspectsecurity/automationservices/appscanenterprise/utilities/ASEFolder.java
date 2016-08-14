package com.aspectsecurity.automationservices.appscanenterprise.utilities;

public class ASEFolder {

	private String name, fullPath;
	private int id;
	
	public ASEFolder(String name, int id, String fullPath){
		this.name = name;
		this.id = id;
		this.fullPath = fullPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
}
