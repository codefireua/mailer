/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.IDAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ua.com.codefire.mailer.entity.ContactList;
import ua.com.codefire.mailer.entity.Users;


@Repository("entity")
public class ContactListController implements IUsersDAO {

    @PersistenceContext(unitName = "AutowiredMailer")
    private EntityManager entityManager;
    
    @Override
    public List<ContactList> GetContactList() {
        return entityManager.createNamedQuery("ContactList.findAll", ContactList.class).getResultList();
    }

    @Override
    public List<Users> GetUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
