package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ReplicationDestination {
private AccessControlTranslation AccessControlTranslation;
private String Account;
private String Bucket;
private EncryptionConfiguration EncryptionConfiguration;
public AccessControlTranslation getAccessControlTranslation() {
	return AccessControlTranslation;
}
public void setAccessControlTranslation(AccessControlTranslation accessControlTranslation) {
	AccessControlTranslation = accessControlTranslation;
}
public String getAccount() {
	return Account;
}
public void setAccount(String account) {
	Account = account;
}
public String getBucket() {
	return Bucket;
}
public void setBucket(String bucket) {
	Bucket = bucket;
}
public String getStorageClass() {
	return StorageClass;
}
public void setStorageClass(String storageClass) {
	StorageClass = storageClass;
}
private String StorageClass;
}
