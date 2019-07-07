package com.cleantips.iam.base.model;

import java.util.HashMap;

import com.cleantips.iam.usertogroup.model.UserToGroupAddition;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources {
private com.cleantips.iam.group.model.Group Group;
private UserToGroupAddition UserToGroupAddition;
private com.cleantips.iam.policy.model.Policy Policy;

public com.cleantips.iam.policy.model.Policy getPolicy() {
	return Policy;
}

public void setPolicy(com.cleantips.iam.policy.model.Policy policy) {
	Policy = policy;
}

public UserToGroupAddition getUserToGroupAddition() {
	return UserToGroupAddition;
}

public void setUserToGroupAddition(UserToGroupAddition userToGroupAddition) {
	UserToGroupAddition = userToGroupAddition;
}

public com.cleantips.iam.group.model.Group getGroup() {
	return Group;
}

public void setGroup(com.cleantips.iam.group.model.Group group) {
	Group = group;
}

private com.cleantips.iam.user.model.User User;

public com.cleantips.iam.user.model.User getUser() {
	return User;
}

public void setUser(com.cleantips.iam.user.model.User user) {
	User = user;
}


}
