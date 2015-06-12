package main.java.utils;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Receptionist {
	public String id;
	@JsonIgnore
	public String user;
	public String auth_token;
	@JsonIgnore
	public String phone;
	public List<String> event_stack;
}
