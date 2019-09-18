package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.RoleMenu;

public interface RoleMenuDao extends JpaRepository<RoleMenu, Integer>,JpaSpecificationExecutor<RoleMenu> {

}
