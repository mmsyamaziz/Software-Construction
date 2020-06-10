/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movies.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FIQMANAN
 */
@Controller
public class HomeController {
    
    //This will mapping to the addmovies link on the templates
    @RequestMapping("/Home")
    public String addMovies(){
        return "addMovies";
    }
}
