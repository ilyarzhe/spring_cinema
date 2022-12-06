package com.example.spring_cinema.repositories;

import com.example.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT movie FROM Movie movie WHERE movie.duration<=?1")
    List<Movie> getMoviesUnderDuration(int duration);
}
