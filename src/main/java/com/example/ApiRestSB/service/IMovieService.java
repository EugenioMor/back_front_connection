package com.example.ApiRestSB.service;

import com.example.ApiRestSB.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMovieService {

    public List<Movie> getAllMovies();
    public ResponseEntity<Movie> getMovieById(Long id);
    public ResponseEntity<Movie> saveMovie(Movie movie);
    public ResponseEntity<Movie> deleteMovie(Long id);
    public ResponseEntity<Movie> editMovie(Movie movie);


}
