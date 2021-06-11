package com.qa.springmovies.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springmovies.domain.Movie;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovieControllerIntegrationTest {

	@Autowired
	private MockMvc mock; // to mock our controller as well as any relevant mappers

	@Autowired
	private ObjectMapper mapper; // convert our requests to JSON Format

	@Test
	void testCreate() throws JsonProcessingException {

		// Creating our movie
		Movie movie1 = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "Crime Drama");

		// Convert to JSON string
		String movie1AsJSON = this.mapper.writeValueAsString(movie1);

		// Build our mock REQUEST

		RequestBuilder mockRequest = 
				post("/movie/create")
				.contentType(MediaType.APPLICATION_JSON)
				.contentType(movie1AsJSON);
		
		// Create our "saved" movie
	}
}
