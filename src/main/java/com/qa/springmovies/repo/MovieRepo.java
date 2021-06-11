package com.qa.springmovies.repo;

public class MovieRepo {
	package com.qa.movies.repo;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.qa.movies.domain.Movie;

	@Repository
	public interface MovieRepo extends JpaRepository<Movie, Long> {
		
		// SELECT * from Movie where name = '[name]';
		List<Movie> findAnimalByName(String name);
		
		@Query(value = "SELECT * from Movie WHERE name = ?Puma and species = ?Cat", nativeQuery = true)
		 Movie findAnimalByNameAndSpeciesSQL(String name, String species); //name is parameter 1 and age is 2.
	}

}
