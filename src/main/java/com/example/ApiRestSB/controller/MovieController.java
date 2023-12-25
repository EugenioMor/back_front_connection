package com.example.ApiRestSB.controller;

import com.example.ApiRestSB.model.Movie;
import com.example.ApiRestSB.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping("/edit")
    public ResponseEntity<Movie> editMovie(@RequestBody Movie movie){
        return movieService.editMovie(movie);
    }


}
