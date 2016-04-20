/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.web.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author CodeFire
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
