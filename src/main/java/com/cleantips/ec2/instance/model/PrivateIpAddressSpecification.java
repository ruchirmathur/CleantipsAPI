package com.cleantips.ec2.instance.model;

public class PrivateIpAddressSpecification {
private String PrivateIpAddress;
public boolean isPrimary() {
	return Primary;
}
public void setPrimary(boolean primary) {
	Primary = primary;
}
private boolean Primary;
}
