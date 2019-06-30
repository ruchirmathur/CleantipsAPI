package com.cleantips.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters {
private HashMap<String, Object> Map;

public HashMap<String, Object> getMap() {
	return Map;
}

public void setMap(HashMap<String, Object> map) {
	Map = map;
}
}
