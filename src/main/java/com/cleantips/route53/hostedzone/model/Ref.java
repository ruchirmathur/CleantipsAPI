package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class Ref {
@JsonProperty("Ref")
private String ref;

public String getRef() {
	return ref;
}

public void setRef(String ref) {
	this.ref = ref;
}



}
