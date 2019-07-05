/*
 * 
 */
package com.cleantips.route53.recordset.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class AliasTarget.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class AliasTarget {
	
	/** The DNS name. */
	private Ref DNSName;

	/**
	 * Gets the DNS name.
	 *
	 * @return the DNS name
	 */
	public Ref getDNSName() {
		return DNSName;
	}

	/**
	 * Sets the DNS name.
	 *
	 * @param dNSName the new DNS name
	 */
	public void setDNSName(Ref dNSName) {
		DNSName = dNSName;
	}

	/** The Evaluate target health. */
	private boolean EvaluateTargetHealth;
	
	/** The Hosted zone id. */
	private Ref HostedZoneId;

	/**
	 * Checks if is evaluate target health.
	 *
	 * @return true, if is evaluate target health
	 */
	public boolean isEvaluateTargetHealth() {
		return EvaluateTargetHealth;
	}

	/**
	 * Sets the evaluate target health.
	 *
	 * @param evaluateTargetHealth the new evaluate target health
	 */
	public void setEvaluateTargetHealth(boolean evaluateTargetHealth) {
		EvaluateTargetHealth = evaluateTargetHealth;
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

}
