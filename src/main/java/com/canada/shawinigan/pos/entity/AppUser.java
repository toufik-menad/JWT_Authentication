/**
 * 
 */
package com.canada.shawinigan.pos.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**basic POJO to manage users data
 * @author TMenad
 *
 */
@Entity
@Table
public class AppUser {
	
	@Id @GeneratedValue
	Integer id;
	@Column
	String username;
	@Column
	String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();
	
	/**
	 * default constructor
	 */
	public AppUser() {
	}
	

	public AppUser(Integer id, String username, String password, Collection<AppRole> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public Collection<AppRole> getRoles() {
		return roles;
	}


	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
