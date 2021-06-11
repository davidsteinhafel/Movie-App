package com.qa.springmovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springmovies.domain.Movie;
import com.qa.springmovies.service.MovieService;



	@RestController
	@RequestMapping("/movie")
	public class MovieController {

		private MovieService service;

		
		
		@Autowired
		public MovieController(MovieService service) {
			this.service = service;
		}
		
		
		//CREATE
		
		
		@PostMapping("/create")
		public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {

			return new ResponseEntity<Movie>(this.service.addMovie(movie), HttpStatus.CREATED);
		}
		

		// READ

		@GetMapping("/getAll")
		public ResponseEntity<List<Movie>> getAllMovies() {

			return ResponseEntity.ok(this.service.getAllMovies());
		}

		// DELETE

		@DeleteMapping("/remove/{id}")
		public ResponseEntity<Movie> removeMovie(@PathVariable long id) {
			return this.removeMovie(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


		// UPDATE

		@PutMapping("/replace/{id}")
		public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie newMovie) {
			this.service.updateMovie(id, newMovie);
			return new ResponseEntity<Movie>(newMovie, HttpStatus.ACCEPTED);
		}

	}
