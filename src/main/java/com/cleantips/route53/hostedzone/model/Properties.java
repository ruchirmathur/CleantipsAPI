/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class Properties.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {

/** The Hosted zone config. */
private HostedZoneConfig HostedZoneConfig;

/** The Hosted zone tags. */
private ArrayList<HostedZoneTag> HostedZoneTags;

/** The Name. */
private String Name;

/** The Query logging config. */
private QueryLoggingConfig QueryLoggingConfig;

/** The VP cs. */
private VPC VPCs;

/**
 * Gets the hosted zone config.
 *
 * @return the hosted zone config
 */
public HostedZoneConfig getHostedZoneConfig() {
	return HostedZoneConfig;
}

/**
 * Sets the hosted zone config.
 *
 * @param hostedZoneConfig the new hosted zone config
 */
public void setHostedZoneConfig(HostedZoneConfig hostedZoneConfig) {
	HostedZoneConfig = hostedZoneConfig;
}

/**
 * Gets the hosted zone tags.
 *
 * @return the hosted zone tags
 */
public ArrayList<HostedZoneTag> getHostedZoneTags() {
	return HostedZoneTags;
}

/**
 * Sets the hosted zone tags.
 *
 * @param hostedZoneTags the new hosted zone tags
 */
public void setHostedZoneTags(ArrayList<HostedZoneTag> hostedZoneTags) {
	HostedZoneTags = hostedZoneTags;
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
 * Gets the query logging config.
 *
 * @return the query logging config
 */
public QueryLoggingConfig getQueryLoggingConfig() {
	return QueryLoggingConfig;
}

/**
 * Sets the query logging config.
 *
 * @param queryLoggingConfig the new query logging config
 */
public void setQueryLoggingConfig(QueryLoggingConfig queryLoggingConfig) {
	QueryLoggingConfig = queryLoggingConfig;
}

/**
 * Gets the VP cs.
 *
 * @return the VP cs
 */
public VPC getVPCs() {
	return VPCs;
}

/**
 * Sets the VP cs.
 *
 * @param vPCs the new VP cs
 */
public void setVPCs(VPC vPCs) {
	VPCs = vPCs;
}

}