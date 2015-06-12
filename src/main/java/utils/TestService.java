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

	public static boolean dial_ext(ExternalCall cust, Receptionist rep) {
		HttpResponse<String> response = null;
		try {
			response = Unirest
					.post("http://ci.bitstack.dk:4242/call/originate/"
							+ cust.extension + "/reception/1/contact/1")
					.queryString("token", rep.auth_token).asString();
			if (response.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean dial(ExternalCall cust) {
		HttpResponse<String> response = null;
		try {
			response = Unirest
					.post(ADDRESS + "/resource/customer/" + cust.id + "/dial/"
							+ "12340001")
					.queryString("token", "canihazmagicplease").asString();
			if (response.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean pickup(ExternalCall cust) {
		HttpResponse<String> response = null;
		try {
			response = Unirest
					.post(ADDRESS + "/resource/customer/" + cust.id + "/pickup")
					.queryString("token", "canihazmagicplease").asString();
			if (response.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean hangUp(ExternalCall cust) {
		HttpResponse<String> response = null;
		try {
			response = Unirest
					.post(ADDRESS + "/resource/customer/" + cust.id
							+ "/hangupAll")
					.queryString("token", "canihazmagicplease").asString();
			if (response.getStatus() > 299)
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean isCustomerInCall(ExternalCall cust) {
		HttpResponse<JsonNode> response = null;
		try {
			response = Unirest.post(ADDRESS + "/resource/customer/" + cust.id)
					.queryString("token", "canihazmagicplease").asJson();
			if (response.getStatus() > 299)
				return false;
			cust = Serializer.deserialize(response.getBody().toString(),
					ExternalCall.class);
			if (cust.current_call != null)
				return true;
			else
				return false;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
