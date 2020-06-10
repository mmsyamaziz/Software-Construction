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

/**
 *
 * @author FIQMANAN
 */
@Controller
public class MovieController {
        
        private final MovieRepository movieRepository;
        MoviesRepository moveiRepo;
        
        @Autowired
        public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
        @ModelAttribute("movie")
        public Movie loadEmpyModelBean(){
            return new Movie();
        }
        

}
