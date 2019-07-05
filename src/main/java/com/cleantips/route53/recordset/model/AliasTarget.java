package com.cleantips.route53.recordset.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class AliasTarget {
	private Ref DNSName;

	public Ref getDNSName() {
		return DNSName;
	}

	public void setDNSName(Ref dNSName) {
		DNSName = dNSName;
	}

	private boolean EvaluateTargetHealth;
	private Ref HostedZoneId;

	public boolean isEvaluateTargetHealth() {
		return EvaluateTargetHealth;
	}

	public void setEvaluateTargetHealth(boolean evaluateTargetHealth) {
		EvaluateTargetHealth = evaluateTargetHealth;
	}

	public Ref getHostedZoneId() {
		return HostedZoneId;
	}

	public void setHostedZoneId(Ref hostedZoneId) {
		HostedZoneId = hostedZoneId;
	}

}
