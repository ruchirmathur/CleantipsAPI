package com.cleantips.route53.hostedzone.model;

public class HostedZone {
private String Type = "AWS::Route53::HostedZone";
private Properties Properties;
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public Properties getProperties() {
	return Properties;
}
public void setProperties(Properties properties) {
	Properties = properties;
}
}
