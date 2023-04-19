package com.qa.springdemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue
	private long id;

	public boolean hasWhiskers;
	public String name;
	public boolean evil;
	public int length;

	public Cat() {
		super();
	}

	public Cat(boolean hasWhiskers, String name, boolean evil, int length) {
		super();
		this.hasWhiskers = hasWhiskers;
		this.name = name;
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
