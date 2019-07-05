package com.cleantips.api.model;

import java.util.ArrayList;

/**
 * The Class GenerateTemplateResponse.
 */
public class GenerateTemplateResponse {

/** The template urls. */
private ArrayList<String> templateUrls;

/** The status. */
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

/**
 * Gets the template urls.
 *
 * @return the template urls
 */
public ArrayList<String> getTemplateUrls() {
	return templateUrls;
}

/**
 * Sets the template urls.
 *
 * @param templateUrls the new template urls
 */
public void setTemplateUrls(ArrayList<String> templateUrls) {
	this.templateUrls = templateUrls;
}
}
