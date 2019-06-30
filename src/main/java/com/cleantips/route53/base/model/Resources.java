package com.cleantips.route53.base.model;

import com.cleantips.ec2.instance.model.BlockDeviceMappings;
import com.cleantips.ec2.instance.model.Instance;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.eipassociation.model.EIPAssociation;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources {

private com.cleantips.route53.hostedzone.model.HostedZone HostedZone;

private com.cleantips.route53.recordset.model.RecordSet RecordSet;

public com.cleantips.route53.hostedzone.model.HostedZone getHostedZone() {
	return HostedZone;
}

public void setHostedZone(com.cleantips.route53.hostedzone.model.HostedZone hostedZone) {
	HostedZone = hostedZone;
}

public com.cleantips.route53.recordset.model.RecordSet getRecordSet() {
	return RecordSet;
}

public void setRecordSet(com.cleantips.route53.recordset.model.RecordSet recordSet) {
	RecordSet = recordSet;
}


}
