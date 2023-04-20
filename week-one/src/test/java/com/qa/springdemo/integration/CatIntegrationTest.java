package com.qa.springdemo.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springdemo.domain.Cat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:cat-schema.sql", "classpath:cat-data.sql" })
public class CatIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Cat newCat = new Cat(1l, "Mr B", true, true, 23);
		String newCatAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = post("/create").content(newCatAsJson).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isCreated();
		Cat created = new Cat(1l, "Mr B", true, true, 23);
		String createdAsJson = this.mapper.writeValueAsString(created);
		ResultMatcher checkBody = content().json(createdAsJson);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {

		List<Cat> cats = List.of(new Cat(1l, "Mr B", true, true, 23));
		String catAsJson = this.mapper.writeValueAsString(cats);
		RequestBuilder req1 = get("/getAll");

		// RequestBuilder req =
		// get("/getAll").content(firstCatString).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(catAsJson);

		this.mvc.perform(req1).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		Long id = 1l;
		Cat newCat = new Cat(1l, "Mr B", true, true, 23);
		String newCatAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = get("/get/" + id).content(newCatAsJson).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatAsJson);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		long id = 1l;
		Cat c = new Cat(1l, "Mr B", true, true, 23);
		String catAsJson = this.mapper.writeValueAsString(c);

		RequestBuilder req = delete("/remove/" + id);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(catAsJson);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testUpdate() throws Exception {
		long id = 1l;
		Cat c = new Cat(1l, "Mr B", true, true, 23);
		String catAsJson = this.mapper.writeValueAsString(c);

		RequestBuilder req = patch("/update/" + id).queryParam("name", "Mr B").queryParam("hasWhiskers", "true")
				.queryParam("evil", "true").queryParam("length", "23");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(catAsJson);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

}
