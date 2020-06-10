/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.controller;

import com.movies.service.entity.Movie;
import com.movies.service.repository.MovieRepository;
import com.movies.service.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FIQMANAN
 */
@Controller
public class HomeController {
    
    private final MoviesRepository movieRepository;
            
    @Autowired
    public HomeController(MoviesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @RequestMapping("/Index")
    public String Index(){
        return "Index";
    }
    //This will mapping to the addmovies link on the templates
    @RequestMapping("/addMovies")
    public String addMovies(){
        return "addMovies";
    }
    
    @RequestMapping("/updateMovies")
    public String updateMovies(){
        return "UpdateMovie";
    }
    
    @RequestMapping("/deleteMovies")
    public String deleteMovie(){
        return "DeleteMovies";
    }
    
    @ModelAttribute("movie")
    public Movie loadEmpyModelBean(){
        return new Movie();
    }
    
    @PostMapping("/add")
    public String AddMovies(Movie movie, BindingResult result,Model model){
        //if(result.hasErrors()){
        //    return "addMovies";
        //}
        movieRepository.save(movie);
        model.addAttribute("movie",new Movie());
        return "addMovies";
    }
}
