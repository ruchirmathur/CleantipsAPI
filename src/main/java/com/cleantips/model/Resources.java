package com.cleantips.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources<T> {


private HashMap<String,Stack> Resources;

public HashMap<String, Stack> getResources() {
	return Resources;
}

public void setResources(HashMap<String, Stack> resources) {
	Resources = resources;
}

}
