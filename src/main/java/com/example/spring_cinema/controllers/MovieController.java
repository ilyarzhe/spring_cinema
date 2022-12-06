package com.example.spring_cinema.controllers;
import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.models.Reply;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<Reply> addMovie(
            @RequestBody Movie movie){
        Reply reply = movieService.addMovie(movie);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Movie>> displayAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
