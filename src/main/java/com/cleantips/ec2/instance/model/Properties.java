package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
	private String Affinity;

	private AvailibilityZone AvailabilityZone;

	private ArrayList<BlockDeviceMappings> BlockDeviceMappings;

	private CreditSpecification CreditSpecification;

	private boolean DisableApiTermination;

	private boolean EbsOptimized;

	private ArrayList<ElasticGpuSpecifications> ElasticGpuSpecifications;

	private ArrayList<ElasticInferenceAccelerators> ElasticInferenceAccelerators;

	private String HostId;

	private String IamInstanceProfile;

	private Ref ImageId;

	private String InstanceInitiatedShutdownBehavior;

	private Ref InstanceType;

	private String Ipv6AddressCount;

	private Ipv6Addresses Ipv6Addresses;

	private String KernelId;

	private Ref KeyName;

	private LaunchTemplate LaunchTemplateSpecification;

	private ArrayList<LicenseSpecifications> LicenseSpecifications;
	private boolean Monitoring;
	private ArrayList<NetworkInterfaces> NetworkInterfaces;
	private String PlacementGroupName;
	private String PrivateIpAddress;
	private String RamdiskId;
	private SecurityGroupIds SecurityGroupIds;
	private SecurityGroups SecurityGroups;
	private boolean SourceDestCheck;
	private SsmAssociations SsmAssociations;
	private String SubnetId;
	private String Tenancy;
	private String UserData;
	private String AdditionalInfo;

	public boolean isMonitoring() {
		return Monitoring;
	}

	public void setMonitoring(boolean monitoring) {
		Monitoring = monitoring;
	}

	public ArrayList<NetworkInterfaces> getNetworkInterfaces() {
		return NetworkInterfaces;
	}

	public void setNetworkInterfaces(ArrayList<NetworkInterfaces> networkInterfaces) {
		NetworkInterfaces = networkInterfaces;
	}

	public String getPlacementGroupName() {
		return PlacementGroupName;
	}

	public void setPlacementGroupName(String placementGroupName) {
		PlacementGroupName = placementGroupName;
	}

	public String getPrivateIpAddress() {
		return PrivateIpAddress;
	}

	public void setPrivateIpAddress(String privateIpAddress) {
		PrivateIpAddress = privateIpAddress;
	}

	public String getRamdiskId() {
		return RamdiskId;
	}

	public void setRamdiskId(String ramdiskId) {
		RamdiskId = ramdiskId;
	}

	public SecurityGroupIds getSecurityGroupIds() {
		return SecurityGroupIds;
	}

	public void setSecurityGroupIds(SecurityGroupIds securityGroupIds) {
		SecurityGroupIds = securityGroupIds;
	}

	public SecurityGroups getSecurityGroups() {
		return SecurityGroups;
	}

	public void setSecurityGroups(SecurityGroups securityGroups) {
		SecurityGroups = securityGroups;
	}

	public boolean isSourceDestCheck() {
		return SourceDestCheck;
	}

	public void setSourceDestCheck(boolean sourceDestCheck) {
		SourceDestCheck = sourceDestCheck;
	}

	public SsmAssociations getSsmAssociations() {
		return SsmAssociations;
	}

	public void setSsmAssociations(SsmAssociations ssmAssociations) {
		SsmAssociations = ssmAssociations;
	}

	public String getSubnetId() {
		return SubnetId;
	}

	public void setSubnetId(String subnetId) {
		SubnetId = subnetId;
	}

	public String getTenancy() {
		return Tenancy;
	}

	public void setTenancy(String tenancy) {
		Tenancy = tenancy;
	}

	public String getUserData() {
		return UserData;
	}

	public void setUserData(String userData) {
		UserData = userData;
	}

	public String getAdditionalInfo() {
		return AdditionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		AdditionalInfo = additionalInfo;
	}

	public String getKernelId() {
		return KernelId;
	}

	public void setKernelId(String kernelId) {
		KernelId = kernelId;
	}

	public LaunchTemplate getLaunchTemplateSpecification() {
		return LaunchTemplateSpecification;
	}

	public void setLaunchTemplateSpecification(LaunchTemplate launchTemplateSpecification) {
		LaunchTemplateSpecification = launchTemplateSpecification;
	}

	public ArrayList<LicenseSpecifications> getLicenseSpecifications() {
		return LicenseSpecifications;
	}

	public void setLicenseSpecifications(ArrayList<LicenseSpecifications> licenseSpecifications) {
		LicenseSpecifications = licenseSpecifications;
	}

	public Ref getKeyName() {
		return KeyName;
	}

	public void setKeyName(Ref keyName) {
		KeyName = keyName;
	}

	public String getAffinity() {
		return Affinity;
	}

	public void setAffinity(String affinity) {
		Affinity = affinity;
	}
	public AvailibilityZone getAvailabilityZone() {
		return AvailabilityZone;
	}

	public void setAvailabilityZone(AvailibilityZone availabilityZone) {
		AvailabilityZone = availabilityZone;
	}

	public ArrayList<BlockDeviceMappings> getBlockDeviceMappings() {
		return BlockDeviceMappings;
	}

	public void setBlockDeviceMappings(ArrayList<BlockDeviceMappings> blockDeviceMappings) {
		BlockDeviceMappings = blockDeviceMappings;
	}

	public CreditSpecification getCreditSpecification() {
		return CreditSpecification;
	}

	public void setCreditSpecification(CreditSpecification creditSpecification) {
		CreditSpecification = creditSpecification;
	}

	public boolean isDisableApiTermination() {
		return DisableApiTermination;
	}

	public void setDisableApiTermination(boolean disableApiTermination) {
		DisableApiTermination = disableApiTermination;
	}

	public boolean isEbsOptimized() {
		return EbsOptimized;
	}

	public void setEbsOptimized(boolean ebsOptimized) {
		EbsOptimized = ebsOptimized;
	}

	public ArrayList<ElasticGpuSpecifications> getElasticGpuSpecifications() {
		return ElasticGpuSpecifications;
	}

	public void setElasticGpuSpecifications(ArrayList<ElasticGpuSpecifications> elasticGpuSpecifications) {
		ElasticGpuSpecifications = elasticGpuSpecifications;
	}

	public ArrayList<ElasticInferenceAccelerators> getElasticInferenceAccelerators() {
		return ElasticInferenceAccelerators;
	}

	public void setElasticInferenceAccelerators(ArrayList<ElasticInferenceAccelerators> elasticInferenceAccelerators) {
		ElasticInferenceAccelerators = elasticInferenceAccelerators;
	}

	public String getHostId() {
		return HostId;
	}

	public void setHostId(String hostId) {
		HostId = hostId;
	}

	public String getIamInstanceProfile() {
		return IamInstanceProfile;
	}

	public void setIamInstanceProfile(String iamInstanceProfile) {
		IamInstanceProfile = iamInstanceProfile;
	}

	public Ref getImageId() {
		return ImageId;
	}

	public void setImageId(Ref imageId) {
		ImageId = imageId;
	}

	public String getInstanceInitiatedShutdownBehavior() {
		return InstanceInitiatedShutdownBehavior;
	}

	public void setInstanceInitiatedShutdownBehavior(String instanceInitiatedShutdownBehavior) {
		InstanceInitiatedShutdownBehavior = instanceInitiatedShutdownBehavior;
	}

	public Ref getInstanceType() {
		return InstanceType;
	}

	public void setInstanceType(Ref instanceType) {
		InstanceType = instanceType;
	}

	public String getIpv6AddressCount() {
		return Ipv6AddressCount;
	}

	public void setIpv6AddressCount(String ipv6AddressCount) {
		Ipv6AddressCount = ipv6AddressCount;
	}

	public Ipv6Addresses getIpv6Addresses() {
		return Ipv6Addresses;
	}

	public void setIpv6Addresses(Ipv6Addresses ipv6Addresses) {
		Ipv6Addresses = ipv6Addresses;
	}
}
