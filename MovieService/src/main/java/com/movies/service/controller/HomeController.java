/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.controller;

import com.movies.service.entity.Movie;
import com.movies.service.entity.User;
import com.movies.service.repository.MovieRepository;
import com.movies.service.repository.MoviesRepository;
import com.movies.service.repository.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FIQMANAN
 */
@Controller
public class HomeController {
    
    private final MoviesRepository movieRepository;
    private final MovieRepository moviRepository;
    private final UsersRepository userRepository;        
    
       @Autowired
    public HomeController(MoviesRepository movieRepository,MovieRepository moviRepository,UsersRepository userRepository) {
        this.movieRepository = movieRepository;
        this.moviRepository = moviRepository;
        this.userRepository = userRepository;
    }

        //@ModelAttribute("user")
       // public User loadEmpyModelBean(){
       //     return new User();
       // }
        
        @RequestMapping("/register")
        public String addUser(Model model){
        model.addAttribute("user",new User());    
        return "Register";
    }
    
        @PostMapping("/addUser")
        public String AddUsers(User user, BindingResult result,Model model){
        userRepository.save(user);
        model.addAttribute("user",new User());
        return "Register";
    }
    
    @RequestMapping("/Index")
    public String Index(){
        return "index";
    }
    //This will mapping to the addmovies link on the templates
    @RequestMapping("/addMovies")
    public String addMovies(){
        return "addMovies";
    }
    
    @RequestMapping("/editForm")
     public String editForm(Model model){
        List<Movie> movie = moviRepository.findAll();
        model.addAttribute("movies", movie);
        return "EditForm";
    }
    
    @RequestMapping("/updateMovies")
    public String updateMovies(){
        return "UpdateMovie";
    }
    
    @RequestMapping("/deleteMovies")
    public String deleteMovie(Model model){
        List<Movie> movie = moviRepository.findAll();
        model.addAttribute("movies", movie);
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
    
    @GetMapping("/edit/{id}")
        public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id)); 
        model.addAttribute("movie", movie);
        return "UpdateMovie";
    }
     
    @PostMapping("/update/{id}")
    public String UpdateUser(@PathVariable("id") Integer id, Movie movie, BindingResult result, Model model) {
    if (result.hasErrors()) {
        movie.setId(id);
        return "UpdateMovie";
    }
    
    movieRepository.save(movie);
    model.addAttribute("movies", movieRepository.findAll());

    return "EditForm";
    }

    @GetMapping("/delete/{id}")
        public String deleteMovie(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id)); 
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "DeleteMovies";
}
        
}

