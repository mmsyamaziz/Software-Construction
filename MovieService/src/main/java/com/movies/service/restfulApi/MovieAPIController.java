/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.restfulApi;

import com.movies.service.entity.Movie;
import com.movies.service.repository.MovieRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FIQMANAN
 */
@RestController
@RequestMapping("/rest")
public class MovieAPIController {
    
    private final MovieRepository movieRepository;

    @Autowired
    public MovieAPIController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    //Display all the data in term of JSON
    @GetMapping("/all")
    public List<Movie> listMovies(){
        return movieRepository.findAll();
    }
    
    @GetMapping("/Insert")
    public String insert(){
    //Just for testing insert dummy data 
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    try{
        movieRepository.save(new Movie("Avatar",2,df.parse("20/01/2020")));
        movieRepository.save(new Movie("Titanic",1,df.parse("16/06/2019")));
    }
    catch(ParseException e) {
        e.printStackTrace();
    }
    return "Inserted";
    }

    //Post Method to receive the data from API
    //Using Postman to insert the data using JSON format
    @PostMapping("/InsertNew")
    public ResponseEntity<Movie> AddMovie(@RequestBody Movie movie){
        try{
        Movie movies = movieRepository.save(new Movie(movie.getMovieName(),movie.getDuration(),movie.getReleaseDate()));
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
        
        }catch(Exception e){
        return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }
}
