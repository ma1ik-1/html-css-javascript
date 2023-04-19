package com.qa.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springdemo.domain.Cat;

@Service
public class CatServiceList implements CatService {

	List<Cat> cats = new ArrayList<>();

	@Override
	public Cat createCat(Cat c) {
		// TODO Auto-generated method stub
		this.cats.add(c);
		Cat created = this.cats.get(cats.size() - 1);
		return created;
	}

	@Override
	public List<Cat> getAll() {
		// TODO Auto-generated method stub
		return this.cats;

	}

	@Override
	public Cat get(int id) {
		// TODO Auto-generated method stub
		return this.cats.get(id);
	}

	@Override
	public Cat remove(int id) {
		// TODO Auto-generated method stub
		return this.cats.remove(id);
	}

	@Override
	public Cat update(int id, String name, Boolean evil, Boolean hasWhiskers, Integer length) {
		// TODO Auto-generated method stub
		Cat toUpdate = this.cats.get(id);

		if (name != null) {
			toUpdate.setName(name);
		}
		if (evil != null) {
			toUpdate.setEvil(evil);
		}
		if (hasWhiskers != null) {
			toUpdate.setHasWhiskers(hasWhiskers);
		}
		if (length != null) {
			toUpdate.setLength(length);
		}

		return toUpdate;
	}

}
