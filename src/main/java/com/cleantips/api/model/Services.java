package com.cleantips.api.model;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The Class Services.
 */
public class Services implements Comparable< Services > {

/** The type. */
private String type;

/** The priority. */
private Integer priority;

/** The template url. */
private String templateUrl;


/**
 * Gets the template url.
 *
 * @return the template url
 */
public String getTemplateUrl() {
	return templateUrl;
}

/**
 * Sets the template url.
 *
 * @param templateUrl the new template url
 */
public void setTemplateUrl(String templateUrl) {
	this.templateUrl = templateUrl;
}

/**
 * Gets the priority.
 *
 * @return the priority
 */
public Integer getPriority() {
	return priority;
}

/**
 * Sets the priority.
 *
 * @param priority the new priority
 */
public void setPriority(Integer priority) {
	this.priority = priority;
}

/**
 * Gets the dependent on.
 *
 * @return the dependent on
 */
public String getDependentOn() {
	return dependentOn;
}

/**
 * Sets the dependent on.
 *
 * @param dependentOn the new dependent on
 */
public void setDependentOn(String dependentOn) {
	this.dependentOn = dependentOn;
}

/** The dependent on. */
private String dependentOn;

/** The properties. */
private ConcurrentHashMap properties;


/**
 * Gets the properties.
 *
 * @return the properties
 */
public ConcurrentHashMap getProperties() {
	return properties;
}

/**
 * Sets the properties.
 *
 * @param properties the new properties
 */
public void setProperties(ConcurrentHashMap properties) {
	this.properties = properties;
}

/**
 * Gets the type.
 *
 * @return the type
 */
public String getType() {
	return type;
}

/**
 * Sets the type.
 *
 * @param type the new type
 */
public void setType(String type) {
	this.type = type;
}

/**
 * Compare to.
 *
 * @param o the o
 * @return the int
 */
public int compareTo(Services o) {
    return this.getPriority().compareTo(o.getPriority());
}

@Override
public boolean equals(Object obj) {
    if (obj instanceof Services) {

        return ((Services) obj).type == type;
    }
    return false;
}
@Override
public int hashCode() {
    return getType().hashCode();
}

}
