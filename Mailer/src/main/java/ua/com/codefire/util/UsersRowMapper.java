/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ua.com.codefire.mailer.entity.Users;

/**
 *
 * @author HP-Davydoff
 */
public class UsersRowMapper implements RowMapper<Users> {
   
    @Override
    public Users mapRow(ResultSet result, int rowNum) throws SQLException {
        Users User = new Users();
        User.setUserId(result.getInt("user_id"));
        User.setUserName(result.getString("user_name"));
        User.setUserPwd(result.getString("user_pwd"));
        User.setUserEmail(result.getString("user_email"));
        return User;
    }
    
}
