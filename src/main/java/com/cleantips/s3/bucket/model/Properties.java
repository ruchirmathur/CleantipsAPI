package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
public AccelerateConfiguration getAccelerateConfiguration() {
		return AccelerateConfiguration;
	}
	public void setAccelerateConfiguration(AccelerateConfiguration accelerateConfiguration) {
		AccelerateConfiguration = accelerateConfiguration;
	}
	public String getAccessControl() {
		return AccessControl;
	}
	public void setAccessControl(String accessControl) {
		AccessControl = accessControl;
	}
	public ArrayList<AnalyticsConfiguration> getAnalyticsConfigurations() {
		return AnalyticsConfigurations;
	}
	public void setAnalyticsConfigurations(ArrayList<AnalyticsConfiguration> analyticsConfigurations) {
		AnalyticsConfigurations = analyticsConfigurations;
	}
	public BucketEncryption getBucketEncryption() {
		return BucketEncryption;
	}
	public void setBucketEncryption(BucketEncryption bucketEncryption) {
		BucketEncryption = bucketEncryption;
	}
	public String getBucketName() {
		return BucketName;
	}
	public void setBucketName(String bucketName) {
		BucketName = bucketName;
	}
	public CorsConfiguration getCorsConfiguration() {
		return CorsConfiguration;
	}
	public void setCorsConfiguration(CorsConfiguration corsConfiguration) {
		CorsConfiguration = corsConfiguration;
	}
	public ArrayList<InventoryConfiguration> getInventoryConfigurations() {
		return InventoryConfigurations;
	}
	public void setInventoryConfigurations(ArrayList<InventoryConfiguration> inventoryConfigurations) {
		InventoryConfigurations = inventoryConfigurations;
	}
	public LifecycleConfiguration getLifecycleConfiguration() {
		return LifecycleConfiguration;
	}
	public void setLifecycleConfiguration(LifecycleConfiguration lifecycleConfiguration) {
		LifecycleConfiguration = lifecycleConfiguration;
	}
	public com.cleantips.s3.bucket.model.LifecycleConfiguration getLoggingConfiguration() {
		return LoggingConfiguration;
	}
	public void setLoggingConfiguration(com.cleantips.s3.bucket.model.LifecycleConfiguration loggingConfiguration) {
		LoggingConfiguration = loggingConfiguration;
	}
	public ArrayList<MetricsConfiguration> getMetricsConfigurations() {
		return MetricsConfigurations;
	}
	public void setMetricsConfigurations(ArrayList<MetricsConfiguration> metricsConfigurations) {
		MetricsConfigurations = metricsConfigurations;
	}
	public NotificationConfiguration getNotificationConfiguration() {
		return NotificationConfiguration;
	}
	public void setNotificationConfiguration(NotificationConfiguration notificationConfiguration) {
		NotificationConfiguration = notificationConfiguration;
	}
	public ObjectLockConfiguration getObjectLockConfiguration() {
		return ObjectLockConfiguration;
	}
	public void setObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration) {
		ObjectLockConfiguration = objectLockConfiguration;
	}
	public boolean isObjectLockEnabled() {
		return ObjectLockEnabled;
	}
	public void setObjectLockEnabled(boolean objectLockEnabled) {
		ObjectLockEnabled = objectLockEnabled;
	}
	public PublicAccessBlockConfiguration getPublicAccessBlockConfiguration() {
		return PublicAccessBlockConfiguration;
	}
	public void setPublicAccessBlockConfiguration(PublicAccessBlockConfiguration publicAccessBlockConfiguration) {
		PublicAccessBlockConfiguration = publicAccessBlockConfiguration;
	}
	public ReplicationConfiguration getReplicationConfiguration() {
		return ReplicationConfiguration;
	}
	public void setReplicationConfiguration(ReplicationConfiguration replicationConfiguration) {
		ReplicationConfiguration = replicationConfiguration;
	}
	public ArrayList<com.cleantips.cloudfront.distribution.model.Tags> getTags() {
		return Tags;
	}
	public void setTags(ArrayList<com.cleantips.cloudfront.distribution.model.Tags> tags) {
		Tags = tags;
	}
	public VersioningConfiguration getVersioningConfiguration() {
		return VersioningConfiguration;
	}
	public void setVersioningConfiguration(VersioningConfiguration versioningConfiguration) {
		VersioningConfiguration = versioningConfiguration;
	}
	public WebsiteConfiguration getWebsiteConfiguration() {
		return WebsiteConfiguration;
	}
	public void setWebsiteConfiguration(WebsiteConfiguration websiteConfiguration) {
		WebsiteConfiguration = websiteConfiguration;
	}
private AccelerateConfiguration AccelerateConfiguration;
private String  AccessControl;
private ArrayList<AnalyticsConfiguration> AnalyticsConfigurations;
private BucketEncryption BucketEncryption;
private String BucketName;
private CorsConfiguration CorsConfiguration;
private ArrayList<InventoryConfiguration> InventoryConfigurations;
private LifecycleConfiguration LifecycleConfiguration;
private com.cleantips.s3.bucket.model.LifecycleConfiguration LoggingConfiguration;
private ArrayList<MetricsConfiguration> MetricsConfigurations;
private NotificationConfiguration NotificationConfiguration;
private ObjectLockConfiguration ObjectLockConfiguration;
private boolean ObjectLockEnabled;
private PublicAccessBlockConfiguration PublicAccessBlockConfiguration;
private ReplicationConfiguration ReplicationConfiguration;
private ArrayList<com.cleantips.cloudfront.distribution.model.Tags> Tags;
private VersioningConfiguration VersioningConfiguration;
private WebsiteConfiguration WebsiteConfiguration;

}