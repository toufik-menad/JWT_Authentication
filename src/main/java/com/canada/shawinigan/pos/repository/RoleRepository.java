/**
 * 
 */
package com.canada.shawinigan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canada.shawinigan.pos.entity.AppRole;

/**
 * @author TMenad
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<AppRole, Integer> {

	public AppRole findByRoleName(String role);

}