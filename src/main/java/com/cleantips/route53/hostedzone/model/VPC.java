/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class VPC.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class VPC {

/** The VPC id. */
private String VPCId;

/** The VPC region. */
private String VPCRegion;

/**
 * Gets the VPC id.
 *
 * @return the VPC id
 */
public String getVPCId() {
	return VPCId;
}

/**
 * Sets the VPC id.
 *
 * @param vPCId the new VPC id
 */
public void setVPCId(String vPCId) {
	VPCId = vPCId;
}

/**
 * Gets the VPC region.
 *
 * @return the VPC region
 */
public String getVPCRegion() {
	return VPCRegion;
}

/**
 * Sets the VPC region.
 *
 * @param vPCRegion the new VPC region
 */
public void setVPCRegion(String vPCRegion) {
	VPCRegion = vPCRegion;
}
}
