package com.cleantips.vpc.route.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String DestinationCidrBlock;
private String DestinationIpv6CidrBlock;
public Ref getGatewayId() {
	return GatewayId;
}
public void setGatewayId(Ref gatewayId) {
	GatewayId = gatewayId;
}
public String getDestinationCidrBlock() {
	return DestinationCidrBlock;
}
public void setDestinationCidrBlock(String destinationCidrBlock) {
	DestinationCidrBlock = destinationCidrBlock;
}
private String EgressOnlyInternetGatewayId;
private Ref GatewayId;
private String InstanceId;
private String NatGatewayId;
public Ref getRouteTableId() {
	return RouteTableId;
}
public void setRouteTableId(Ref routeTableId) {
	RouteTableId = routeTableId;
}
private String NetworkInterfaceId;
private Ref RouteTableId;
private String VpcPeeringConnectionId;

public String getDestinationIpv6CidrBlock() {
	return DestinationIpv6CidrBlock;
}
public void setDestinationIpv6CidrBlock(String destinationIpv6CidrBlock) {
	DestinationIpv6CidrBlock = destinationIpv6CidrBlock;
}
public String getEgressOnlyInternetGatewayId() {
	return EgressOnlyInternetGatewayId;
}
public void setEgressOnlyInternetGatewayId(String egressOnlyInternetGatewayId) {
	EgressOnlyInternetGatewayId = egressOnlyInternetGatewayId;
}
public String getInstanceId() {
	return InstanceId;
}
public void setInstanceId(String instanceId) {
	InstanceId = instanceId;
}
public String getNatGatewayId() {
	return NatGatewayId;
}
public void setNatGatewayId(String natGatewayId) {
	NatGatewayId = natGatewayId;
}
public String getNetworkInterfaceId() {
	return NetworkInterfaceId;
}
public void setNetworkInterfaceId(String networkInterfaceId) {
	NetworkInterfaceId = networkInterfaceId;
}
public String getVpcPeeringConnectionId() {
	return VpcPeeringConnectionId;
}
public void setVpcPeeringConnectionId(String vpcPeeringConnectionId) {
	VpcPeeringConnectionId = vpcPeeringConnectionId;
}
}
