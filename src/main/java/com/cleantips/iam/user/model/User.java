package com.cleantips.iam.user.model;

import com.cleantips.iam.user.model.Properties;

public class User {
	private String Type="AWS::IAM::User";
	private Properties Properties;
	public Properties getProperties() {
		return Properties;
	}
	public void setProperties(Properties properties) {
		Properties = properties;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
}
