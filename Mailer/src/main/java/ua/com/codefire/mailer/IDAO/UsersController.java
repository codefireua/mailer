/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.IDAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.com.codefire.mailer.entity.Users;

/**
 *
 * @author HP-Davydoff
 */
@Repository("template")
public class UsersController implements IUsersDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Users> GetUsers() {
        return jdbcTemplate.queryForList("Users.findAll", Users.class);
    }
    
}
