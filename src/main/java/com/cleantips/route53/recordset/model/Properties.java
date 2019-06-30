package com.cleantips.route53.recordset.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String Comment;
private String Failover;
private Geolocation GeoLocation;
private String HealthCheckId;
private String HostedZoneId;
private String HostedZoneName;
private boolean MultiValueAnswer;
private String Name;
private String Region;
private String ResourceRecords[];
private String SetIdentifier;
private String TTL;
private String Type;
private String Weight;
private AliasTarget AliasTarget;
public String getComment() {
	return Comment;
}
public void setComment(String comment) {
	Comment = comment;
}
public String getFailover() {
	return Failover;
}
public void setFailover(String failover) {
	Failover = failover;
}
public Geolocation getGeoLocation() {
	return GeoLocation;
}
public void setGeoLocation(Geolocation geoLocation) {
	GeoLocation = geoLocation;
}
public String getHealthCheckId() {
	return HealthCheckId;
}
public void setHealthCheckId(String healthCheckId) {
	HealthCheckId = healthCheckId;
}
public String getHostedZoneId() {
	return HostedZoneId;
}
public void setHostedZoneId(String hostedZoneId) {
	HostedZoneId = hostedZoneId;
}
public String getHostedZoneName() {
	return HostedZoneName;
}
public void setHostedZoneName(String hostedZoneName) {
	HostedZoneName = hostedZoneName;
}
public boolean isMultiValueAnswer() {
	return MultiValueAnswer;
}
public void setMultiValueAnswer(boolean multiValueAnswer) {
	MultiValueAnswer = multiValueAnswer;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getRegion() {
	return Region;
}
public void setRegion(String region) {
	Region = region;
}
public String[] getResourceRecords() {
	return ResourceRecords;
}
public void setResourceRecords(String[] resourceRecords) {
	ResourceRecords = resourceRecords;
}
public String getSetIdentifier() {
	return SetIdentifier;
}
public void setSetIdentifier(String setIdentifier) {
	SetIdentifier = setIdentifier;
}
public String getTTL() {
	return TTL;
}
public void setTTL(String tTL) {
	TTL = tTL;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getWeight() {
	return Weight;
}
public void setWeight(String weight) {
	Weight = weight;
}
public AliasTarget getAliasTarget() {
	return AliasTarget;
}
public void setAliasTarget(AliasTarget aliasTarget) {
	AliasTarget = aliasTarget;
}
}