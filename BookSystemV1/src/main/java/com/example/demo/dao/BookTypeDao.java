package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.BookType;

public interface BookTypeDao extends JpaRepository<BookType, Integer>,JpaSpecificationExecutor<BookType> {

}
