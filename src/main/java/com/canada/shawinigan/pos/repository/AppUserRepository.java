/**
 * 
 */
package com.canada.shawinigan.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canada.shawinigan.pos.entity.AppUser;

/**
 * @author TMenad
 *
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	AppUser findByUsername(String username);
	List<AppUser>findAll();

}
