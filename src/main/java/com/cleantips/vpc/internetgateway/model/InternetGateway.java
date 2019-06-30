package com.cleantips.vpc.internetgateway.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class InternetGateway {
	
private String Type="AWS::EC2::InternetGateway";

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

}
