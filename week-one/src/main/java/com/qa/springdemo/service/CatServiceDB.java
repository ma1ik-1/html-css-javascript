package com.qa.springdemo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.springdemo.domain.Cat;
import com.qa.springdemo.exception.CatNotFoundException;
import com.qa.springdemo.repo.CatRepo;

@Primary
@Service
public class CatServiceDB implements CatService {

	private CatRepo repo;

	public CatServiceDB(CatRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Cat createCat(Cat c) {
		// TODO Auto-generated method stub
		return this.repo.save(c);
	}

	@Override
	public List<Cat> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Cat get(int id) {
		// TODO Auto-generated method stub
		return this.repo.findById((long) id).orElseThrow(() -> new CatNotFoundException());
	}

	@Override
	public Cat remove(int id) {
		// TODO Auto-generated method stub
		Cat removed = this.get(id);
		this.repo.deleteById((long) id);
		return removed;
	}

	@Override
	public Cat update(long id, String name, Boolean evil, Boolean hasWhiskers, Integer length) {
		// TODO Auto-generated method stub
		Cat c = this.get((int) id);

		if (name != null) {
			c.setName(name);
		}
		if (evil != null) {
			c.setEvil(evil);
		}
		if (hasWhiskers != null) {
			c.setHasWhiskers(hasWhiskers);
		}
		if (length != null) {
			c.setLength(length);
		}

		return this.repo.save(c);
	}

}
