package com.cleantips.iam.group.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Statement {
public String getEffect() {
		return Effect;
	}
	public void setEffect(String effect) {
		Effect = effect;
	}
	public ArrayList getAction() {
		return Action;
	}
	public void setAction(ArrayList action) {
		Action = action;
	}
private String Effect;
private ArrayList Action;
}
