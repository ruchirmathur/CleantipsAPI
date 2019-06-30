package com.cleantips.s3.bucket.model;

public class SourceSelectionCriteria {
private SseKmsEncryptedObjects SseKmsEncryptedObjects;

public SseKmsEncryptedObjects getSseKmsEncryptedObjects() {
	return SseKmsEncryptedObjects;
}

public void setSseKmsEncryptedObjects(SseKmsEncryptedObjects sseKmsEncryptedObjects) {
	SseKmsEncryptedObjects = sseKmsEncryptedObjects;
}
}
