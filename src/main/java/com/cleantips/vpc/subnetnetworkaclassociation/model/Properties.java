package com.cleantips.vpc.subnetnetworkaclassociation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String SubnetId;
public String getSubnetId() {
	return SubnetId;
}
public void setSubnetId(String subnetId) {
	SubnetId = subnetId;
}
public String getNetworkAclId() {
	return NetworkAclId;
}
public void setNetworkAclId(String networkAclId) {
	NetworkAclId = networkAclId;
}
private String NetworkAclId;
}
