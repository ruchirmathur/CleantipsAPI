package com.cleantips.s3.bucket.model;

public class ServerSideEncryptionRule {
private ServerSideEncryptionByDefault ServerSideEncryptionByDefault;

public ServerSideEncryptionByDefault getServerSideEncryptionByDefault() {
	return ServerSideEncryptionByDefault;
}

public void setServerSideEncryptionByDefault(ServerSideEncryptionByDefault serverSideEncryptionByDefault) {
	ServerSideEncryptionByDefault = serverSideEncryptionByDefault;
}
}
