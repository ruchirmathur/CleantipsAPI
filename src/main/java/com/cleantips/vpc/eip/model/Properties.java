package com.cleantips.vpc.eip.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String AllocationId;
private String EIP;
private Ref InstanceId;
private String NetworkInterfaceId;
private String PrivateIpAddress;
public String getAllocationId() {
	return AllocationId;
}
public void setAllocationId(String allocationId) {
	AllocationId = allocationId;
}
public String getEIP() {
	return EIP;
}
public void setEIP(String eIP) {
	EIP = eIP;
}
public String getNetworkInterfaceId() {
	return NetworkInterfaceId;
}
public Ref getInstanceId() {
	return InstanceId;
}
public void setInstanceId(Ref instanceId) {
	InstanceId = instanceId;
}
public void setNetworkInterfaceId(String networkInterfaceId) {
	NetworkInterfaceId = networkInterfaceId;
}
public String getPrivateIpAddress() {
	return PrivateIpAddress;
}
public void setPrivateIpAddress(String privateIpAddress) {
	PrivateIpAddress = privateIpAddress;
}

}
