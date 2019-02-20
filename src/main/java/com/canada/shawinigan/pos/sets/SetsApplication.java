package com.canada.shawinigan.pos.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.canada.shawinigan.pos.dto.Employee;

@ComponentScan({"com.canada.*"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories({"com.*"})
@EntityScan({"com.*"})
public class SetsApplication implements CommandLineRunner{

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

	@Override
	public void run(String... args) throws Exception {
		final List<Employee>employees= new ArrayList<>();
		final Employee first = new Employee("A",100);
		final Employee second = new Employee("C",200);
		final Employee third = new Employee("B",300);
		final Employee fourth = new Employee("Z",400);
		
		
		employees.add(third);
		employees.add(fourth);
		employees.add(first);
		employees.add(second);
		
		Collections.sort(employees);
		
		employees.stream().forEach(e ->{
			System.out.println(e.getName() + " salary: "+ e.getSalary());
		});
			
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
