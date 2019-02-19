/**
 * 
 */
package com.canada.shawinigan.pos.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canada.shawinigan.pos.entity.AppUser;
import com.canada.shawinigan.pos.service.AccountService;

/**
 * @author mint
 *
 */
@RestController
@CrossOrigin
public class AppUserController {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AccountService accountService;
	
	/**registers user using an open end point
	 * @param user
	 * @return
	 */
	@PostMapping(value="/user")
	public AppUser register(@RequestBody AppUser user) {
		
		logger.info("object: {}", user.toString());
		
		AppUser appUser = accountService.saveUser(user);
		accountService.addRoleToUser(user.getUsername(), "USER");
		
		return appUser;
		
	}
	
	/**lists all users from the database
	 * @return
	 */
	@GetMapping(value="/users")
	public List<AppUser> list() {
		logger.info("-------> getting the users list ----");
		return accountService.findAll();
		
	}

}
