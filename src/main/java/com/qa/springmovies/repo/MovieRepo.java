package com.qa.springmovies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springmovies.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
}
