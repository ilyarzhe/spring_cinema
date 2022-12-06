package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.models.Reply;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public MovieService(){}

    public Reply addMovie(Movie movie){
        movieRepository.save(movie);
        return new Reply("Movie Successfully added");
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }
    public void removeMovieById(int id){
        movieRepository.deleteById(id);
    }
    public void updateMovieDuration(int id,int duration){
        Movie movie = movieRepository.findById(id).get();
        movie.setDuration(duration);
        movieRepository.save(movie);
    }

}
