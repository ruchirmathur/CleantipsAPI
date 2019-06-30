package com.cleantips.template;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cleantips.api.model.Services;
import com.cleantips.model.Template;

// TODO: Auto-generated Javadoc
/**
 * The Interface BaseTemplateGenerator.
 */
public interface BaseTemplateGenerator {

	/**
	 * Execute.
	 *
	 * @param services the services
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void execute(ArrayList<Services> services)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException;

	/**
	 * Generate template version.
	 *
	 * @param template the template
	 * @return the template
	 */
	public Template generateTemplateVersion(Template template);

	/**
	 * Generate parameters.
	 *
	 * @param template the template
	 * @return the template
	 */
	public Template generateParameters(Template template);

	/**
	 * Generate mappings.
	 *
	 * @param template the template
	 * @return the template
	 */
	public Template generateMappings(Template template);

	/**
	 * Generate conditions.
	 *
	 * @param template the template
	 * @return the template
	 */
	public Template generateConditions(Template template);

	/**
	 * Generate resources.
	 *
	 * @param template the template
	 * @param services the services
	 * @param output the output
	 * @return the template
	 */
	public Template generateResources(Template template, ArrayList<Services> services, HashMap output);

	/**
	 * Generate output.
	 *
	 * @param template the template
	 * @param services the services
	 * @param output the output
	 * @return the template
	 */
	public Template generateOutput(Template template, ArrayList<Services> services, HashMap output);

	/**
	 * Creates the services.
	 *
	 * @param services the services
	 * @return the hash map
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public HashMap createServices(ArrayList<Services> services)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
