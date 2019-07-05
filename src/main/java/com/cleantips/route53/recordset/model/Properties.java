/*
 * 
 */
package com.cleantips.route53.recordset.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class Properties.
 */
@SuppressWarnings("deprecation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
	
	/** The Comment. */
	private String Comment;
	
	/** The Failover. */
	private String Failover;
	
	/** The Geo location. */
	private Geolocation GeoLocation;
	
	/** The Health check id. */
	private String HealthCheckId;
	
	/** The Hosted zone id. */
	private Ref HostedZoneId;
	
	/** The Hosted zone name. */
	private String HostedZoneName;
	
	/** The Multi value answer. */
	private boolean MultiValueAnswer;
	
	/** The Name. */
	private String Name;
	
	/** The Region. */
	private String Region;
	
	/** The Resource records. */
	private String ResourceRecords[];
	
	/** The Set identifier. */
	private String SetIdentifier;
	
	/** The ttl. */
	private String TTL;
	
	/** The Type. */
	private String Type;
	
	/** The Weight. */
	private String Weight;
	
	/** The Alias target. */
	private AliasTarget AliasTarget;

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return Comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		Comment = comment;
	}

	/**
	 * Gets the failover.
	 *
	 * @return the failover
	 */
	public String getFailover() {
		return Failover;
	}

	/**
	 * Sets the failover.
	 *
	 * @param failover the new failover
	 */
	public void setFailover(String failover) {
		Failover = failover;
	}

	/**
	 * Gets the geo location.
	 *
	 * @return the geo location
	 */
	public Geolocation getGeoLocation() {
		return GeoLocation;
	}

	/**
	 * Sets the geo location.
	 *
	 * @param geoLocation the new geo location
	 */
	public void setGeoLocation(Geolocation geoLocation) {
		GeoLocation = geoLocation;
	}

	/**
	 * Gets the health check id.
	 *
	 * @return the health check id
	 */
	public String getHealthCheckId() {
		return HealthCheckId;
	}

	/**
	 * Sets the health check id.
	 *
	 * @param healthCheckId the new health check id
	 */
	public void setHealthCheckId(String healthCheckId) {
		HealthCheckId = healthCheckId;
	}

	/**
	 * Gets the hosted zone id.
	 *
	 * @return the hosted zone id
	 */
	public Ref getHostedZoneId() {
		return HostedZoneId;
	}

	/**
	 * Sets the hosted zone id.
	 *
	 * @param hostedZoneId the new hosted zone id
	 */
	public void setHostedZoneId(Ref hostedZoneId) {
		HostedZoneId = hostedZoneId;
	}

	/**
	 * Gets the hosted zone name.
	 *
	 * @return the hosted zone name
	 */
	public String getHostedZoneName() {
		return HostedZoneName;
	}

	/**
	 * Sets the hosted zone name.
	 *
	 * @param hostedZoneName the new hosted zone name
	 */
	public void setHostedZoneName(String hostedZoneName) {
		HostedZoneName = hostedZoneName;
	}

	/**
	 * Checks if is multi value answer.
	 *
	 * @return true, if is multi value answer
	 */
	public boolean isMultiValueAnswer() {
		return MultiValueAnswer;
	}

	/**
	 * Sets the multi value answer.
	 *
	 * @param multiValueAnswer the new multi value answer
	 */
	public void setMultiValueAnswer(boolean multiValueAnswer) {
		MultiValueAnswer = multiValueAnswer;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return Region;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(String region) {
		Region = region;
	}

	/**
	 * Gets the resource records.
	 *
	 * @return the resource records
	 */
	public String[] getResourceRecords() {
		return ResourceRecords;
	}

	/**
	 * Sets the resource records.
	 *
	 * @param resourceRecords the new resource records
	 */
	public void setResourceRecords(String[] resourceRecords) {
		ResourceRecords = resourceRecords;
	}

	/**
	 * Gets the sets the identifier.
	 *
	 * @return the sets the identifier
	 */
	public String getSetIdentifier() {
		return SetIdentifier;
	}

	/**
	 * Sets the sets the identifier.
	 *
	 * @param setIdentifier the new sets the identifier
	 */
	public void setSetIdentifier(String setIdentifier) {
		SetIdentifier = setIdentifier;
	}

	/**
	 * Gets the ttl.
	 *
	 * @return the ttl
	 */
	public String getTTL() {
		return TTL;
	}

	/**
	 * Sets the ttl.
	 *
	 * @param tTL the new ttl
	 */
	public void setTTL(String tTL) {
		TTL = tTL;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public String getWeight() {
		return Weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(String weight) {
		Weight = weight;
	}

	/**
	 * Gets the alias target.
	 *
	 * @return the alias target
	 */
	public AliasTarget getAliasTarget() {
		return AliasTarget;
	}

	/**
	 * Sets the alias target.
	 *
	 * @param aliasTarget the new alias target
	 */
	public void setAliasTarget(AliasTarget aliasTarget) {
		AliasTarget = aliasTarget;
	}
}