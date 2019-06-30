package com.cleantips.vpc.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private Ref CidrBlock;
private boolean EnableDnsSupport;
private boolean EnableDnsHostnames;
private String InstanceTenancy;
public Ref getCidrBlock() {
	return CidrBlock;
}
public void setCidrBlock(Ref cidrBlock) {
	CidrBlock = cidrBlock;
}
public boolean isEnableDnsSupport() {
	return EnableDnsSupport;
}
public void setEnableDnsSupport(boolean enableDnsSupport) {
	EnableDnsSupport = enableDnsSupport;
}
public boolean isEnableDnsHostnames() {
	return EnableDnsHostnames;
}
public void setEnableDnsHostnames(boolean enableDnsHostnames) {
	EnableDnsHostnames = enableDnsHostnames;
}
public String getInstanceTenancy() {
	return InstanceTenancy;
}
public void setInstanceTenancy(String instanceTenancy) {
	InstanceTenancy = instanceTenancy;
}

}
