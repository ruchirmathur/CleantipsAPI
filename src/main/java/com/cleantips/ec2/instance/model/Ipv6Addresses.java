package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Ipv6Addresses {
private String Ipv6Address;

public String getIpv6Address() {
	return Ipv6Address;
}

public void setIpv6Address(String ipv6Address) {
	Ipv6Address = ipv6Address;
}
}
