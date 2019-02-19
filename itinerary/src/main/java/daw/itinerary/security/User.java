package daw.itinerary.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String passwordHash;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<String>();

	// Constructor, getters, setters

	public User(String newName, String newPass, String rol) {
		name = newName;
		passwordHash = newPass;
		roles.add(rol);
	}
	
	public User(String newName, String newPass, String rol1, String rol2) {
		name = newName;
		passwordHash = newPass;
		roles.add(rol1);
		roles.add(rol2);
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return passwordHash;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setPassword(String newPass) {
		passwordHash = newPass;
	}
	
	public void setRoles(List<String> newRoles) {
		roles = newRoles;
	}
}
