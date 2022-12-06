package com.example.spring_cinema.repositories;

import com.example.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
