package com.canada.shawinigan.pos.sets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan({"com.canada.*"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories({"com.*"})
@EntityScan({"com.*"})
public class SetsApplication{

	public static void main(String[] args) {
		SpringApplication.run(SetsApplication.class, args);
	}

//	@Autowired
//	AccountService service;
	
	
	
//	@Bean
//	public PasswordEncoder delegatingPasswordEncoder() {
//		
//		String idForEncode = "bcrypt";
//		Map<String, PasswordEncoder> encoders = new HashMap<>();
//		encoders.put(idForEncode, new BCryptPasswordEncoder());
//		encoders.put("noop", NoOpPasswordEncoder.getInstance());
//		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//		encoders.put("scrypt", new SCryptPasswordEncoder());
//		encoders.put("sha256", new StandardPasswordEncoder());
//		PasswordEncoder passwordEncoder =
//		 new DelegatingPasswordEncoder(idForEncode, encoders);
//		return passwordEncoder;
//	}
	
	@Bean
	public BCryptPasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
  
//	@Override
//	public void run(String... arg0) throws Exception{
//		
////		AppRole role = new AppRole(null, "ADMIN");
////  
////		AppUser userEntity = new AppUser(null,"jaco","jaco",null );
////		
////		service.saveUser(userEntity);
////		
////		service.saveRole(role);
////		service.addRoleToUser("jaco", "ADMIN");
//		
//}
	
}
