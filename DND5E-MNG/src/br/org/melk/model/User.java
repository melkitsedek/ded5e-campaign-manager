package br.org.melk.model;

import java.util.List;

public class User {
	private String email, password, nickname;
	private List<Character> characters;
	
	public User(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswordHash() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public List<Character> getCharacters() {
		return characters;
	}
	
	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	public void addCharacter(Character c) {
		try {
			characters.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
