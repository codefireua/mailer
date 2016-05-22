/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.IDAO;

import java.io.Serializable;
import java.util.List;
import ua.com.codefire.mailer.entity.ContactList;
import ua.com.codefire.mailer.entity.Users;

/**
 *
 * @author HP-Davydoff
 */
public interface IUsersDAO extends Serializable{
    
    public List<Users> GetUsers();
    
    
}
