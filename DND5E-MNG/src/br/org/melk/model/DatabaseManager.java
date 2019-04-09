package br.org.melk.model;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import javax.management.InvalidAttributeValueException;

public class DatabaseManager {
	private static DatabaseManager databaseManager;
	private static Map<String, User> users;
	
	private DatabaseManager() {
		users = new HashMap<String, User>();
	}
	
	public static DatabaseManager getInstance() {
		if(databaseManager.equals(null)) {
			databaseManager = new DatabaseManager();
		}
		return databaseManager;
	}
	
	public static void saveUser(User u) throws InvalidParameterException {
		if(users.containsKey(u.getEmail())) {
			throw new InvalidParameterException("E-mail already exists in database. Please, chose another one.");
		}
		users.put(u.getEmail(), u);
		
	}
	
	public static User getUser(String email, String password) {
		if(users.get(email).getPasswordHash().equals(password)) {
			return users.get(email);
		}
		throw new InvalidParameterException("Incorrect e-mail or password.");
	}
}
