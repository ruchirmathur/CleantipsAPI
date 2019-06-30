package com.cleantips.s3.bucket.model;

public class ObjectLockConfiguration {
private String ObjectLockEnabled;
private ObjectLockRule Rule;
public String getObjectLockEnabled() {
	return ObjectLockEnabled;
}
public void setObjectLockEnabled(String objectLockEnabled) {
	ObjectLockEnabled = objectLockEnabled;
}
}
