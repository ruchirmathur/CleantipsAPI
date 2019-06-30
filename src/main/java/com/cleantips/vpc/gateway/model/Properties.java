package com.cleantips.vpc.gateway.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private Ref InternetGatewayId;
private Ref VpcId;
public Ref getInternetGatewayId() {
	return InternetGatewayId;
}
public void setInternetGatewayId(Ref internetGatewayId) {
	InternetGatewayId = internetGatewayId;
}
public Ref getVpcId() {
	return VpcId;
}
public void setVpcId(Ref vpcId) {
	VpcId = vpcId;
}
}