package com.cleantips.vpc.securitygroupegress.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class SecurityGroupEgress {
	private String CidrIp;
	private String CidrIpv6;
	private String Description;
	private String DestinationPrefixListId;
	private String DestinationSecurityGroupId;
	private int FromPort;
	public String getDestinationSecurityGroupId() {
		return DestinationSecurityGroupId;
	}
	public void setDestinationSecurityGroupId(String destinationSecurityGroupId) {
		DestinationSecurityGroupId = destinationSecurityGroupId;
	}
	public Integer getFromPort() {
		return FromPort;
	}
	public void setFromPort(Integer fromPort) {
		FromPort = fromPort;
	}
	public Integer getToPort() {
		return ToPort;
	}
	public void setToPort(Integer toPort) {
		ToPort = toPort;
	}
	public String getIpProtocol() {
		return IpProtocol;
	}
	public void setIpProtocol(String ipProtocol) {
		IpProtocol = ipProtocol;
	}
	private int ToPort;
	private String IpProtocol;
	public String getCidrIp() {
		return CidrIp;
	}
	public void setCidrIp(String cidrIp) {
		CidrIp = cidrIp;
	}
	public String getCidrIpv6() {
		return CidrIpv6;
	}
	public void setCidrIpv6(String cidrIpv6) {
		CidrIpv6 = cidrIpv6;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDestinationPrefixListId() {
		return DestinationPrefixListId;
	}
	public void setDestinationPrefixListId(String destinationPrefixListId) {
		DestinationPrefixListId = destinationPrefixListId;
	}
}
