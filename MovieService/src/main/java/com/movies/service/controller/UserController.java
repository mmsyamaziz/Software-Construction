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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hasuo
 */
@Controller
public class UserController {
    
    private final UsersRepository userRepository;

    public UserController(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
        
        @ModelAttribute("user")
        public User loadEmpyModelBean(){
            return new User();
        }
        
             @RequestMapping("/Register")
    public String addUser(){
        return "Register";
    }
    
        @PostMapping("/addUser")
    public String AddUsers(User user, BindingResult result,Model model){
        userRepository.save(user);
        model.addAttribute("user",new User());
        return "Register";
    }
    
}
