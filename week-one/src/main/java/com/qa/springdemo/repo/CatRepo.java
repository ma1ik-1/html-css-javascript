package com.qa.springdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springdemo.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {

	List<Cat> findByName(String name);

}
