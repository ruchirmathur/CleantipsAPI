package com.cleantips.iam.base.model;

import com.cleantips.ec2.instance.model.Parameter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters<T> {
@JsonProperty("GroupType")
private Parameter GroupType;
@JsonProperty("UserType")
private Parameter UserType;
@JsonProperty("RoleType")
private Parameter RoleType;
public Parameter getGroupType() {
	return GroupType;
}
public void setGroupType(Parameter groupType) {
	GroupType = groupType;
}
public Parameter getUserType() {
	return UserType;
}
public void setUserType(Parameter userType) {
	UserType = userType;
}
public Parameter getRoleType() {
	return RoleType;
}
public void setRoleType(Parameter roleType) {
	RoleType = roleType;
}

}
