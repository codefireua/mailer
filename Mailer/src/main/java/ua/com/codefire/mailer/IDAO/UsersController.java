/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.IDAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ua.com.codefire.mailer.entity.Users;

/**
 *
 * @author HP-Davydoff
 */
@Repository("entity")
public class UsersController implements IDAO{

    @PersistenceContext(unitName = "AutowiredMailer")
    private EntityManager entityManager;
    
    @Override
    public List<Users> GetUsers() {
        return entityManager.createNamedQuery("Users.findAll", Users.class).getResultList();
    }
    
}
