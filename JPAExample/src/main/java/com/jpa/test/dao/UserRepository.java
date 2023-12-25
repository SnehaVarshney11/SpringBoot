package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	// Custom Finder Method
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name, String city);
	
	//Custom Query 
	@Query("select u from User u") //JPQL 
	public List<User> getAllUser();
	
	@Query("select u from User u where u.name =:n") //JPQL
	public List<User> getUserByName(@Param("n") String name);
	
	@Query(value = "select * from User", nativeQuery = true) //SQL 
	public List<User> getUsers();
}
