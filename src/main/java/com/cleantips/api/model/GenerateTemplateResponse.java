package com.cleantips.api.model;

import java.util.ArrayList;

/**
 * The Class GenerateTemplateResponse.
 */
public class GenerateTemplateResponse {

/** The template urls. */
private ArrayList<TemplateProperties> templateProperties;

public ArrayList<TemplateProperties> getTemplateProperties() {
	return templateProperties;
}

public void setTemplateProperties(ArrayList<TemplateProperties> templateProperties) {
	this.templateProperties = templateProperties;
}

/** The status. */
private String status;

private String description;

private String costUrl;

public String getCostUrl() {
	return costUrl;
}

public void setCostUrl(String costUrl) {
	this.costUrl = costUrl;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}
