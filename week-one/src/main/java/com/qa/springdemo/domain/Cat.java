package com.qa.springdemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String name;
	public boolean hasWhiskers;
	public boolean evil;
	public int length;

	public Cat() {
		super();
	}

	public Cat(String name, boolean hasWhiskers, boolean evil, int length) {
		super();
		this.hasWhiskers = hasWhiskers;
		this.name = name;
		this.evil = evil;
		this.length = length;
	}

	public Cat(long id, String name, boolean hasWhiskers, boolean evil, int length) {
		super();
		this.id = id;
		this.name = name;
		this.hasWhiskers = hasWhiskers;
		this.evil = evil;
		this.length = length;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEvil() {
		return evil;
	}

	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
