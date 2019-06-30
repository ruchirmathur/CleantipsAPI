package com.cleantips.route53.hostedzone.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private HostedZoneConfig HostedZoneConfig;
private ArrayList<HostedZoneTag> HostedZoneTags;
private String Name;
private QueryLoggingConfig QueryLoggingConfig;
private VPC VPCs;
public HostedZoneConfig getHostedZoneConfig() {
	return HostedZoneConfig;
}
public void setHostedZoneConfig(HostedZoneConfig hostedZoneConfig) {
	HostedZoneConfig = hostedZoneConfig;
}
public ArrayList<HostedZoneTag> getHostedZoneTags() {
	return HostedZoneTags;
}
public void setHostedZoneTags(ArrayList<HostedZoneTag> hostedZoneTags) {
	HostedZoneTags = hostedZoneTags;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public QueryLoggingConfig getQueryLoggingConfig() {
	return QueryLoggingConfig;
}
public void setQueryLoggingConfig(QueryLoggingConfig queryLoggingConfig) {
	QueryLoggingConfig = queryLoggingConfig;
}
public VPC getVPCs() {
	return VPCs;
}
public void setVPCs(VPC vPCs) {
	VPCs = vPCs;
}

}