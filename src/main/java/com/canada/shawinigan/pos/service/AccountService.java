package com.canada.shawinigan.pos.service;

import java.util.List;

import com.canada.shawinigan.pos.entity.AppRole;
import com.canada.shawinigan.pos.entity.AppUser;

/**
 * @author TMenad
 *
 */
public interface AccountService {
	/**saves a user
	 * @param user
	 * @return
	 */
	public AppUser saveUser(AppUser user);
	
	/**saves a role
	 * @param role
	 * @return
	 */
	public AppRole saveRole(AppRole role);
	
	/**add a role to an existing user
	 * @param userName
	 * @param role
	 */
	public void addRoleToUser(String userName, String role); 
	
	/**finds a user based on the email address
	 * @param email
	 * @return
	 */
	public AppUser findUserByEmail(String email);
	
	/**returns all users from the database
	 * @return
	 */
	public List<AppUser> findAll();
}
