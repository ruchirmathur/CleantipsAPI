package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class RoutingRule {
private RedirectRule RedirectRule;
private RoutingRuleCondition RoutingRuleCondition;
public RedirectRule getRedirectRule() {
	return RedirectRule;
}
public void setRedirectRule(RedirectRule redirectRule) {
	RedirectRule = redirectRule;
}
public RoutingRuleCondition getRoutingRuleCondition() {
	return RoutingRuleCondition;
}
public void setRoutingRuleCondition(RoutingRuleCondition routingRuleCondition) {
	RoutingRuleCondition = routingRuleCondition;
}
}
