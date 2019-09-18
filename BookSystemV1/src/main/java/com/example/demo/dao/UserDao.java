package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;
import com.example.demo.entity.config;

public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
	
	public User findByName(String name);
	
	@Query(value="select * from t_a_user  where id = ?1",nativeQuery = true)
	public User findId(Integer id);
	
}
