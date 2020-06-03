/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.controller;

import com.movies.service.entity.Movie;
import com.movies.service.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FIQMANAN
 */
@RestController
@RequestMapping("/rest")
public class MovieController {
    
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    @GetMapping("/all")
    public List<Movie> listMovies(){
        return movieRepository.findAll();
    }
    
    @GetMapping("/Insert")
    public String insert(){
        movieRepository.save(new Movie("Avenger",2));
    return "Inserted";
    }
}
