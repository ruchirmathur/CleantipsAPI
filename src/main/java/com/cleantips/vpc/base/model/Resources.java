package com.cleantips.vpc.base.model;

import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.cleantips.vpc.model.VPC;
import com.cleantips.vpc.route.model.Route;
import com.cleantips.vpc.routetable.model.RouteTable;
import com.cleantips.vpc.securitygroup.model.SecurityGroup;
import com.cleantips.vpc.securitygroupegress.model.SecurityGroupEgress;
import com.cleantips.vpc.securitygroupingress.model.SecurityGroupIngress;
import com.cleantips.vpc.subnet.model.Subnet;
import com.cleantips.vpc.subnetroutetableassociation.model.SubnetRouteTableAssociation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources<T> {

private Subnet PrivateSubnet;

private Subnet PublicSubnet;

private VpcGateway VpcGateway;

public VpcGateway getVpcGateway() {
	return VpcGateway;
}

public void setVpcGateway(VpcGateway vpcGateway) {
	VpcGateway = vpcGateway;
}

public Subnet getPrivateSubnet() {
	return PrivateSubnet;
}

public void setPrivateSubnet(Subnet privateSubnet) {
	PrivateSubnet = privateSubnet;
}

public Subnet getPublicSubnet() {
	return PublicSubnet;
}

public void setPublicSubnet(Subnet publicSubnet) {
	PublicSubnet = publicSubnet;
}

private VPC VPC;

public VPC getVPC() {
	return VPC;
}

public void setVPC(VPC vPC) {
	VPC = vPC;
}

public Route getRoute() {
	return Route;
}

public void setRoute(Route route) {
	Route = route;
}

public RouteTable getRouteTable() {
	return RouteTable;
}

public void setRouteTable(RouteTable routeTable) {
	RouteTable = routeTable;
}

public SecurityGroupEgress getSecurityGroupEgress() {
	return SecurityGroupEgress;
}

public void setSecurityGroupEgress(SecurityGroupEgress securityGroupEgress) {
	SecurityGroupEgress = securityGroupEgress;
}

public SecurityGroupIngress getSecurityGroupIngress() {
	return SecurityGroupIngress;
}

public void setSecurityGroupIngress(SecurityGroupIngress securityGroupIngress) {
	SecurityGroupIngress = securityGroupIngress;
}

public SubnetRouteTableAssociation getSubnetRouteTableAssociation() {
	return SubnetRouteTableAssociation;
}

public void setSubnetRouteTableAssociation(SubnetRouteTableAssociation subnetRouteTableAssociation) {
	SubnetRouteTableAssociation = subnetRouteTableAssociation;
}

private Route Route;

private RouteTable RouteTable;

public com.cleantips.vpc.eipassociation.model.EIPAssociation getEIP() {
	return EIP;
}

public void setEIP(com.cleantips.vpc.eipassociation.model.EIPAssociation eIP) {
	EIP = eIP;
}

public EIP getEIPAssociation() {
	return EIPAssociation;
}

public void setEIPAssociation(EIP eIPAssociation) {
	EIPAssociation = eIPAssociation;
}

public SecurityGroup getSecurityGroup() {
	return SecurityGroup;
}

public void setSecurityGroup(SecurityGroup securityGroup) {
	SecurityGroup = securityGroup;
}

private SecurityGroupEgress SecurityGroupEgress;

private SecurityGroupIngress SecurityGroupIngress;

private SubnetRouteTableAssociation SubnetRouteTableAssociation;

private com.cleantips.vpc.internetgateway.model.InternetGateway InternetGateway;

private com.cleantips.vpc.eipassociation.model.EIPAssociation EIP;

private EIP EIPAssociation;

private SecurityGroup SecurityGroup;

public com.cleantips.vpc.internetgateway.model.InternetGateway getInternetGateway() {
	return InternetGateway;
}

public void setInternetGateway(com.cleantips.vpc.internetgateway.model.InternetGateway internetGateway) {
	InternetGateway = internetGateway;
}




}
