package com.cleantips.s3.bucket.model;

public class Transition {
private String StorageClass;
private String TransitionDate;
public String getStorageClass() {
	return StorageClass;
}
public void setStorageClass(String storageClass) {
	StorageClass = storageClass;
}
public int getTransitionInDays() {
	return TransitionInDays;
}
public void setTransitionInDays(int transitionInDays) {
	TransitionInDays = transitionInDays;
}
private int TransitionInDays;
}
