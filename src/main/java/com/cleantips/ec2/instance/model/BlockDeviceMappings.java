package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class BlockDeviceMappings {
	private String DeviceName;
	private Ebs Ebs;
	private String NoDevice;
	private String VirtualName;
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	public Ebs getEbs() {
		return Ebs;
	}
	public void setEbs(Ebs ebs) {
		Ebs = ebs;
	}
	public String getNoDevice() {
		return NoDevice;
	}
	public void setNoDevice(String noDevice) {
		NoDevice = noDevice;
	}
	public String getVirtualName() {
		return VirtualName;
	}
	public void setVirtualName(String virtualName) {
		VirtualName = virtualName;
	}
}
