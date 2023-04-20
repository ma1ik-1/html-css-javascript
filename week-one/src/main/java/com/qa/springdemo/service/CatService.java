package com.qa.springdemo.service;

import java.util.List;

import com.qa.springdemo.domain.Cat;

public interface CatService {

	Cat createCat(Cat c);

	List<Cat> getAll();

	Cat get(int id);

	Cat remove(int id);

	Cat update(long id, String name, Boolean evil, Boolean hasWhiskers, Integer length);
}
