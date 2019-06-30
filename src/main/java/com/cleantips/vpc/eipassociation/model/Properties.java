package com.cleantips.vpc.eipassociation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String Domain;
private String InstanceId;
private String PublicIpv4Pool;
public String getDomain() {
	return Domain;
}
public void setDomain(String domain) {
	Domain = domain;
}
public String getInstanceId() {
	return InstanceId;
}
public void setInstanceId(String instanceId) {
	InstanceId = instanceId;
}
public String getPublicIpv4Pool() {
	return PublicIpv4Pool;
}
public void setPublicIpv4Pool(String publicIpv4Pool) {
	PublicIpv4Pool = publicIpv4Pool;
}

}
