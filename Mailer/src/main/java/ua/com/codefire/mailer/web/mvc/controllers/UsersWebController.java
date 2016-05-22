/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.web.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ua.com.codefire.mailer.IDAO.IUsersDAO;


@Controller
@EnableWebMvc
@RequestMapping("/users")
public class UsersWebController {
    
    @Autowired
    @Qualifier("entity")
    private IUsersDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("Users", dao.GetUsers());
        return "list";
    }
    
}
