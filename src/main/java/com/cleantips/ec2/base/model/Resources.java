package com.cleantips.ec2.base.model;

import com.cleantips.ec2.instance.model.BlockDeviceMappings;
import com.cleantips.ec2.instance.model.Instance;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.eipassociation.model.EIPAssociation;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources {

private Instance Instance;

private EIP EIP;

private EIPAssociation EIPAssociation;

private VpcGateway vpcGateway;

public VpcGateway getVpcGateway() {
	return vpcGateway;
}

public void setVpcGateway(VpcGateway vpcGateway) {
	this.vpcGateway = vpcGateway;
}

public Instance getInstance() {
	return Instance;
}

public EIP getEIP() {
	return EIP;
}

public void setEIP(EIP eIP) {
	EIP = eIP;
}

public EIPAssociation getEIPAssociation() {
	return EIPAssociation;
}

public void setEIPAssociation(EIPAssociation eIPAssociation) {
	EIPAssociation = eIPAssociation;
}

public void setInstance(Instance instance) {
	Instance = instance;
}

public BlockDeviceMappings getBlockDeviceMappings() {
	return BlockDeviceMappings;
}

public void setBlockDeviceMappings(BlockDeviceMappings blockDeviceMappings) {
	BlockDeviceMappings = blockDeviceMappings;
}

private BlockDeviceMappings BlockDeviceMappings;





}
