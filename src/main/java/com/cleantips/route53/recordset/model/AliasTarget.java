package com.cleantips.route53.recordset.model;

public class AliasTarget {
private String DNSName;
private boolean EvaluateTargetHealth;
private Ref HostedZoneId;
public String getDNSName() {
	return DNSName;
}
public void setDNSName(String dNSName) {
	DNSName = dNSName;
}
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
