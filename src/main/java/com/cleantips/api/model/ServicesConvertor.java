package com.cleantips.api.model;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServicesConvertor implements DynamoDBTypeConverter<String, List<Services>> {

	@Override
	public String convert(List<Services> object) {
		// TODO Auto-generated method stub
		 //Jackson object mapper
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        String objectsString = objectMapper.writeValueAsString(object);
	        return objectsString;
	    } catch (JsonProcessingException e) {
	        //do something
	    }
	    return null;
	}

	@Override
	public List<Services> unconvert(String object) {
		 ObjectMapper objectMapper = new ObjectMapper();
		    try {
		        List<Services> objects = objectMapper.readValue(object, new TypeReference<List<Services>>(){});
		        return objects;
		    } catch (JsonParseException e) {
		        //do something
		    } catch (JsonMappingException e) {
		        //do something
		    } catch (IOException e) {
		        //do something
		    }
		    return null;
	}

}
