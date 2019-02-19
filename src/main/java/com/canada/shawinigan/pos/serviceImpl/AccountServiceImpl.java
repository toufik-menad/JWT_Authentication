/**
 * 
 */
package com.canada.shawinigan.pos.serviceImpl;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canada.shawinigan.pos.entity.AppRole;
import com.canada.shawinigan.pos.entity.AppUser;
import com.canada.shawinigan.pos.repository.AppUserRepository;
import com.canada.shawinigan.pos.repository.RoleRepository;
import com.canada.shawinigan.pos.service.AccountService;

/**
 * @author TMenad
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	/**{@inheritDoc}
	 * @see com.canada.shawinigan.pos.service.AccountService#saveUser(com.canada.shawinigan.pos.entity.AppUser)
	 */
	@Override
	public AppUser saveUser(AppUser user) {
		final String pass= passwordEncoder.encode(user.getPassword());
		user.setPassword(pass);
		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 * @see com.canada.shawinigan.pos.service.AccountService#saveRole(com.canada.shawinigan.pos.entity.AppRole)
	 */
	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	/**
	 * {@inheritDoc}
	 * @see com.canada.shawinigan.pos.service.AccountService#addRoleToUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void addRoleToUser(String username, String role) {
		final AppRole roleEntity = roleRepository.findByRoleName(role);
		final AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(roleEntity );		
	}

	/**
	 * {@inheritDoc}
	 * @see com.canada.shawinigan.pos.service.AccountService#findUserByEmail(java.lang.String)
	 */
	@Override
	public AppUser findUserByEmail(String username) {
		LOGGER.info("email {}",username );
		return userRepository.findByUsername(username);
	}

	/**
	 * {@inheritDoc}
	 * @see com.canada.shawinigan.pos.service.AccountService#findAll()
	 */
	@Override
	public List<AppUser> findAll() {
		return userRepository.findAll();
	}

}