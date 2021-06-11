package com.qa.springmovies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springmovies.domain.Movie;
import com.qa.springmovies.repo.MovieRepo;

@Service
public class MovieService {
	
	private MovieRepo repo;
	
	public MovieService(MovieRepo repo) {
		super();
		this.repo = repo;
	}
	
	//CREATE
	
	public Movie addMovie(Movie movie) {
		return this.repo.save(movie);
	}
	
	//READ
	
	public List<Movie> getAllMovies(){
		return this.repo.findAll();
	}
	
	//UPDATE
	
	public Movie updateMovie(Long id, Movie newMovie) {
		Optional<Movie> existingOptional = this.repo.findById(id);
		Movie existing = existingOptional.get();
		
		existing.setTitle(newMovie.getTitle());
		existing.setDirector(newMovie.getDirector());
		existing.setYear(newMovie.getYear());
		existing.setGenre(newMovie.getGenre());
		
		return this.repo.save(existing);
	}
	
	//DELETE
	
	public boolean removeMovie(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
}
