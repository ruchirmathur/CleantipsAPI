package com.cleantips.vpc.subnetroutetableassociation.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private Ref RouteTableId;
private Ref SubnetId;
public Ref getRouteTableId() {
	return RouteTableId;
}
public void setRouteTableId(Ref routeTableId) {
	RouteTableId = routeTableId;
}
public Ref getSubnetId() {
	return SubnetId;
}
public void setSubnetId(Ref subnetId) {
	SubnetId = subnetId;
}

}
