package main.java.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Serializer {

	public static String serialize(Object obj) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// convert user object to json string and generate string
			return mapper.writeValueAsString(obj);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return "";
	}

	public static <T> T deserialize(String json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			return mapper.readValue(json, clazz);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}
}
