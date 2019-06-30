package com.cleantips.iam.base.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources {
private com.cleantips.iam.group.model.Group Group;

public com.cleantips.iam.group.model.Group getGroup() {
	return Group;
}

public void setGroup(com.cleantips.iam.group.model.Group group) {
	Group = group;
}
}
