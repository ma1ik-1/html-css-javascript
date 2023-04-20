package com.qa.springdemo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springdemo.domain.Cat;
import com.qa.springdemo.repo.CatRepo;
import com.qa.springdemo.service.CatService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CatServiceDBTest {

	@Autowired
	private CatService service;

	@MockBean
	private CatRepo repo;

	@Test
	void testUpdate() {
		long id = 1l;
		Cat existing = new Cat(id, "Mr B", true, true, 23);
		Cat updated = new Cat(id, "Mr Bb", false, true, 22);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertEquals(updated, this.service.update(id, updated.getName(), updated.isEvil(), updated.isHasWhiskers(),
				updated.getLength()));
	}

	@Test
	void testCreate() {
		long id = 1l;
		Cat c = new Cat(id, "Mr B", true, true, 23);

		Mockito.when(this.repo.save(c)).thenReturn(c);

		assertEquals(c, this.service.createCat(c));
	}

	@Test
	void testDelete() {
		long id = 1l;
		Cat c = new Cat(id, "Mr B", true, true, 23);

//		Mockito.when(this.repo.deleteById((long) id)).thenReturn(c);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(c));

		assertEquals(c, this.service.remove((int) id));
	}

	@Test
	void testGetAll() {
		long id = 1l;
		List<Cat> cats = new ArrayList<>();
		Cat c = new Cat(id, "Mr B", true, true, 23);
		cats.add(c);

		Mockito.when(this.repo.findAll()).thenReturn(cats);

		assertEquals(cats, this.service.getAll());
	}

	@Test
	void testGet() {
		long id = 1l;
		Cat c = new Cat(id, "Mr B", true, true, 23);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(c));

		assertEquals(c, this.service.get((int) id));
	}
}
