package com.cleantips.api.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class ArchitectureSearchResponse2.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchitectureSearchResponse {

	/** The architecture. */
	private String architecture;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String architectureImage;
	
	private ArrayList<Suggest> suggest;

	public ArrayList<Suggest> getSuggest() {
		return suggest;
	}

	public void setSuggest(ArrayList<Suggest> suggest) {
		this.suggest = suggest;
	}

	public String getArchitectureImage() {
		return architectureImage;
	}

	public void setArchitectureImage(String architectureImage) {
		this.architectureImage = architectureImage;
	}

	/** The app services. */
	private ArrayList<Services> appServices;

	/**
	 * Gets the architecture.
	 *
	 * @return the architecture
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * Gets the app services.
	 *
	 * @return the app services
	 */
	public ArrayList<Services> getAppServices() {
		return appServices;
	}

	/**
	 * Sets the app services.
	 *
	 * @param appServices the new app services
	 */
	public void setAppServices(ArrayList<Services> appServices) {
		this.appServices = appServices;
	}

	/**
	 * Sets the architecture.
	 *
	 * @param architecture the new architecture
	 */
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

}
