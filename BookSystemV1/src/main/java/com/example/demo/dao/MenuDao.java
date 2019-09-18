package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Menu;

public interface MenuDao extends JpaRepository<Menu, Integer>,JpaSpecificationExecutor<Menu> {

}
