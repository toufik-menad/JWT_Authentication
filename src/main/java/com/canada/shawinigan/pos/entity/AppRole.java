/**
 * 
 */
package com.canada.shawinigan.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**basic POJO to manage roles and their data
 * @author TMenad
 *
 */
@Entity
@Table
public class AppRole {
	
	@Id @GeneratedValue
	Integer id;
	@Column
	String roleName;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public AppRole() {
	}
	
	
	public AppRole(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
	

}
