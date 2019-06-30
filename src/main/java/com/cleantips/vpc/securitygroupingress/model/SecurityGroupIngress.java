package com.cleantips.vpc.securitygroupingress.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class SecurityGroupIngress {
	private String CidrIp;
	private String CidrIpv6;
	private String Description;
	private int FromPort;
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
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getIpProtocol() {
		return IpProtocol;
	}
	public void setIpProtocol(String ipProtocol) {
		IpProtocol = ipProtocol;
	}
	public String getSourcePrefixListId() {
		return SourcePrefixListId;
	}
	public void setSourcePrefixListId(String sourcePrefixListId) {
		SourcePrefixListId = sourcePrefixListId;
	}
	private String GroupId;
	private String GroupName;
	private String IpProtocol;
	private String SourcePrefixListId;
	private String SourceSecurityGroupId;
	public String getSourceSecurityGroupId() {
		return SourceSecurityGroupId;
	}
	public void setSourceSecurityGroupId(String sourceSecurityGroupId) {
		SourceSecurityGroupId = sourceSecurityGroupId;
	}
	public String getSourceSecurityGroupName() {
		return SourceSecurityGroupName;
	}
	public void setSourceSecurityGroupName(String sourceSecurityGroupName) {
		SourceSecurityGroupName = sourceSecurityGroupName;
	}
	public String getSourceSecurityGroupOwnerId() {
		return SourceSecurityGroupOwnerId;
	}
	public void setSourceSecurityGroupOwnerId(String sourceSecurityGroupOwnerId) {
		SourceSecurityGroupOwnerId = sourceSecurityGroupOwnerId;
	}
	private String SourceSecurityGroupName;
	private String SourceSecurityGroupOwnerId;
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
	private int ToPort;
}
