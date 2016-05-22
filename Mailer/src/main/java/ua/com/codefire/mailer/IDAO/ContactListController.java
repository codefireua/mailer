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
import ua.com.codefire.mailer.entity.ContactList;


@Repository("template")
public class ContactListController implements IContactListDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ContactList> GetContactList() {
        return jdbcTemplate.queryForList("ContactList.findAll", ContactList.class);
    }

}
