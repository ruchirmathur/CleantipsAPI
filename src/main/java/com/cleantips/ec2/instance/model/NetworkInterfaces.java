package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class NetworkInterfaces {
private boolean AssociatePublicIpAddress;
private boolean DeleteOnTermination;
public Ref getGroupSet() {
	return GroupSet;
}
public void setGroupSet(Ref groupSet) {
	GroupSet = groupSet;
}
public Ref getSubnetId() {
	return SubnetId;
}
public void setSubnetId(Ref subnetId) {
	SubnetId = subnetId;
}
private String Description;
private String DeviceIndex;
public boolean isAssociatePublicIpAddress() {
	return AssociatePublicIpAddress;
}
public void setAssociatePublicIpAddress(boolean associatePublicIpAddress) {
	AssociatePublicIpAddress = associatePublicIpAddress;
}
public boolean isDeleteOnTermination() {
	return DeleteOnTermination;
}
public void setDeleteOnTermination(boolean deleteOnTermination) {
	DeleteOnTermination = deleteOnTermination;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getDeviceIndex() {
	return DeviceIndex;
}
public void setDeviceIndex(String deviceIndex) {
	DeviceIndex = deviceIndex;
}
public String getNetworkInterfaceId() {
	return NetworkInterfaceId;
}
public void setNetworkInterfaceId(String networkInterfaceId) {
	NetworkInterfaceId = networkInterfaceId;
}
public Integer getIpv6AddressCount() {
	return Ipv6AddressCount;
}
public void setIpv6AddressCount(Integer ipv6AddressCount) {
	Ipv6AddressCount = ipv6AddressCount;
}
public Integer getSecondaryPrivateIpAddressCount() {
	return SecondaryPrivateIpAddressCount;
}
public void setSecondaryPrivateIpAddressCount(Integer secondaryPrivateIpAddressCount) {
	SecondaryPrivateIpAddressCount = secondaryPrivateIpAddressCount;
}

public ArrayList<PrivateIpAddressSpecification> getPrivateIpAddresses() {
	return PrivateIpAddresses;
}
public void setPrivateIpAddresses(ArrayList<PrivateIpAddressSpecification> privateIpAddresses) {
	PrivateIpAddresses = privateIpAddresses;
}
private Ref GroupSet;
private String NetworkInterfaceId;
private Integer Ipv6AddressCount;
private Integer SecondaryPrivateIpAddressCount;
private Ref SubnetId;
private ArrayList<PrivateIpAddressSpecification> PrivateIpAddresses;
}
