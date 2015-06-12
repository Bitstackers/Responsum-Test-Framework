package main.java.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestService {
	final static String ADDRESS = "http://ci.bitstack.dk:4224";

	public static Receptionist aquireReceptionist() {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest
					.post(ADDRESS + "/resource/receptionist/aquire")
					.queryString("token", "canihazmagicplease").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonResponse.getBody().toString());
		return Serializer.deserialize(jsonResponse.getBody().toString(),
				Receptionist.class);
	}

	public static ExternalCall aquireCustomer() {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post(ADDRESS + "/resource/customer/aquire")
					.queryString("token", "canihazmagicplease").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonResponse.getBody().toString());
		return Serializer.deserialize(jsonResponse.getBody().toString(),
				ExternalCall.class);
	}

	public static boolean releaseReceptionist(Receptionist rep) {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest
					.post(ADDRESS + "/resource/receptionist/" + rep.id
							+ "/release")
					.queryString("token", "canihazmagicplease").asJson();
			if (jsonResponse.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean releaseCustomer(ExternalCall customer) {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest
					.post(ADDRESS + "/resource/customer/" + customer.id
							+ "/release")
					.queryString("token", "canihazmagicplease").asJson();
			if (jsonResponse.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean dial(ExternalCall cust) {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest
					.post(ADDRESS + "/resource/customer/" + cust.id + "/dial/"
							+ cust.extension)
					.queryString("token", "canihazmagicplease").asJson();
			if (jsonResponse.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
