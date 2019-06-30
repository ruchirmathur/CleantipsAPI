package com.cleantips.ec2.instance.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailibilityZone {

@JsonProperty("Fn::Select")
private ArrayList<HashMap<Integer,Ref>>  FnSelect;
@JsonProperty("Fn::Select")
public ArrayList<HashMap<Integer, Ref>> getFnSelect() {
	return FnSelect;
}

public void setFnSelect(ArrayList<HashMap<Integer, Ref>> fnSelect) {
	FnSelect = fnSelect;
}




}
