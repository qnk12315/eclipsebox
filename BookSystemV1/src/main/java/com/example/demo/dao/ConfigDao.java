package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.config;

public interface ConfigDao extends JpaRepository<config, Integer>{
	
	@Query(value="select * from t_config  where id = ?1",nativeQuery = true)
	public config findId(Integer id);
}
