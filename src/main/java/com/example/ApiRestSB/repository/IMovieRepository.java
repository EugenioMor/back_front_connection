package com.example.ApiRestSB.repository;

import com.example.ApiRestSB.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
