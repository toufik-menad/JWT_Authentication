package com.canada.shawinigan.pos.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
		
		final List<Employee>emps = new ArrayList<>();
		final List<Employee>valid = new ArrayList<>();
		for(int i =0;i<10000;i++) {
			final Employee em = new Employee("em"+i,i);
			emps.add(em);
		}
		
		final long start = System.nanoTime();
		for(Employee em: emps) {
			if(em.getSalary()>=50) {
				valid.add(em);
			}
		}
		System.out.println(valid.size());
		
		final long end = System.nanoTime();
		
		System.out.print("total time: ------------------------");
		System.out.print(end-start);
		System.out.print("\n");
		
		final long start_1 = System.nanoTime();
		final int targer = Collections.binarySearch(emps, new Employee(null,50));
		final List<Employee>valid_1 = emps.subList(targer, emps.size());
		System.out.println(valid_1.size());
		final long end_1 = System.nanoTime();
		System.out.print("\n"+"total time_1: ------------------------");
		System.out.print(end_1-start_1);
		
		System.out.print("\n"+"-------------------DONE-----------------------");
			
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
