package com.cleantips.iam.user.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
	private ArrayList<String> Groups;
	private LoginProfile loginProfile;
	private ArrayList<String> ManagedPolicyArns;
	private String Path;
	private String PermissionsBoundary;
	private ArrayList<Policy> Policy;
	private String UserName;

	public ArrayList<String> getGroups() {
		return Groups;
	}

	public void setGroups(ArrayList<String> groups) {
		Groups = groups;
	}

	public LoginProfile getLoginProfile() {
		return loginProfile;
	}

	public void setLoginProfile(LoginProfile loginProfile) {
		this.loginProfile = loginProfile;
	}

	public ArrayList<String> getManagedPolicyArns() {
		return ManagedPolicyArns;
	}

	public void setManagedPolicyArns(ArrayList<String> managedPolicyArns) {
		ManagedPolicyArns = managedPolicyArns;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getPermissionsBoundary() {
		return PermissionsBoundary;
	}

	public void setPermissionsBoundary(String permissionsBoundary) {
		PermissionsBoundary = permissionsBoundary;
	}

	public ArrayList<Policy> getPolicy() {
		return Policy;
	}

	public void setPolicy(ArrayList<Policy> policy) {
		Policy = policy;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

}