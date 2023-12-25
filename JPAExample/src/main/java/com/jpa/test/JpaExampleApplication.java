package com.jpa.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository ur = context.getBean(UserRepository.class);
		/*
		// Create Object of User --------------------
		User user1 = new User();
		user1.setId(1);
		user1.setName("Ram");
		user1.setCity("Ayodhya");
		user1.setStatus("Python Programmer");
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("Shyam");
		user2.setCity("Mathura");
		user2.setStatus("Java Programmer");
		
		
		// Save User ------------------------
		
		//Save single user
		//User savedUser = ur.save(user2);
		
		//Save mutiple users
		Iterable<User> savedUser = Arrays.asList(user1, user2);
		Iterable<User> allUser = ur.saveAll(savedUser);
		
		allUser.forEach(user -> {
			System.out.println(user);
		});
		*/
		
		/*
		// Update the user of id 2 -----------------
		Optional<User> optional = ur.findById(1);
		User user = optional.get();
		
		user.setName("Krishna");
		User updatedUser = ur.save(user);
		
		System.out.println("UPDATE THE DATA -------");
		System.out.println(updatedUser);
		*/
		// Get the data -------------
		//1. findById();
		//2. findAl();
		/*
		Iterable<User> it = ur.findAll();
//		Iterator<User> iterator = it.iterator();
		System.out.println("GET THE DATA -------");
//		while(iterator.hasNext()) {
//			User getuser = iterator.next();
//			System.out.println(getuser);
//		}
		
		it.forEach(users -> System.out.println(users));
		*/
		
		/*
		// Delete the user ---------
		System.out.println("DELETE THE DATA -------");
		ur.deleteById(1);
		
		 // Print the users after deletion
        Iterable<User> remainingUsers = ur.findAll();
        System.out.println("REMAINING USERS AFTER DELETION -------");
        remainingUsers.forEach(users -> System.out.println(users));
        */
		
		System.out.println("CUSTOM METHOD -------");
        //List<User> u = ur.findByName("Shyam");
        List<User> u = ur.findByNameAndCity("Ram", "Ayodhya");
        u.forEach(e -> System.out.println(e));
	}

}
