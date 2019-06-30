package com.cleantips.vpc.base.model;

import com.cleantips.vpc.model.Parameter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters<T> {
@JsonProperty("PrivateSubnetCidr")
private Parameter PrivateSubnetCidr;
@JsonProperty("VpcCidr")
private Parameter VpcCidr;
@JsonProperty("PublicSubnetCidr")
public Parameter getPublicSubnetCidr() {
	return PublicSubnetCidr;
}
public void setPublicSubnetCidr(Parameter publicSubnetCidr) {
	PublicSubnetCidr = publicSubnetCidr;
}
@JsonProperty("PublicSubnetCidr")
private Parameter PublicSubnetCidr;
@JsonProperty("PrivateSubnetCidr")
public Parameter getPrivateSubnetCidr() {
	return PrivateSubnetCidr;
}
public void setPrivateSubnetCidr(Parameter privateSubnetCidr) {
	PrivateSubnetCidr = privateSubnetCidr;
}
@JsonProperty("VpcCidr")
public Parameter getVpcCidr() {
	return VpcCidr;
}
public void setVpcCidr(Parameter vpcCidr) {
	VpcCidr = vpcCidr;
}

}
