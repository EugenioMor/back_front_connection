package com.example.ApiRestSB.service;

import com.example.ApiRestSB.model.Movie;
import com.example.ApiRestSB.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public ResponseEntity<Movie> getMovieById(Long id) {
        Optional<Movie> opt = movieRepository.findById(id);

        if(opt.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(opt.get());
        }
    }

    @Override
    public ResponseEntity<Movie> saveMovie(Movie movie) {
        if (movie.getId() !=null){
            return ResponseEntity.badRequest().build();
        }

        movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }

    @Override
    public ResponseEntity<Movie> deleteMovie(Long id) {
        if (id ==null || !movieRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Movie> editMovie(Movie movie) {
        if (movie.getId() ==null || !movieRepository.existsById(movie.getId())){
            return ResponseEntity.badRequest().build();
        }

        movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }

}
