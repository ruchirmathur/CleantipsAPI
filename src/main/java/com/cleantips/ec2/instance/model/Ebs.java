package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Ebs {
@JsonProperty("VolumeSize")
private String VolumeSize;
@JsonProperty("DeleteOnTermination")
private boolean DeleteOnTermination;
@JsonProperty("DeleteOnTermination")
public boolean isDeleteOnTermination() {
	return DeleteOnTermination;
}

public void setDeleteOnTermination(boolean deleteOnTermination) {
	DeleteOnTermination = deleteOnTermination;
}
@JsonProperty("Encrypted")
public boolean isEncrypted() {
	return Encrypted;
}

public void setEncrypted(boolean encrypted) {
	Encrypted = encrypted;
}
@JsonProperty("Iops")
public int getIops() {
	return Iops;
}

public void setIops(int iops) {
	Iops = iops;
}
@JsonProperty("SnapshotId")
public String getSnapshotId() {
	return SnapshotId;
}

public void setSnapshotId(String snapshotId) {
	SnapshotId = snapshotId;
}
@JsonProperty("VolumeType")
public String getVolumeType() {
	return VolumeType;
}

public void setVolumeType(String volumeType) {
	VolumeType = volumeType;
}

@JsonProperty("Encrypted")
private boolean Encrypted;
@JsonProperty("Iops")
private int Iops;
@JsonProperty("SnapshotId")
private String SnapshotId;
@JsonProperty("VolumeType")
private String VolumeType;
@JsonProperty("VolumeSize")
public String getVolumeSize() {
	return VolumeSize;
}

public void setVolumeSize(String volumeSize) {
	VolumeSize = volumeSize;
}
}
