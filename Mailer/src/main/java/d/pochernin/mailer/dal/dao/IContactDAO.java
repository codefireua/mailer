/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.dao;

import d.pochernin.mailer.dal.entity.Contact;
import d.pochernin.mailer.dal.entity.ContactsGroup;
import d.pochernin.mailer.dal.entity.DeliveryContactList;
import d.pochernin.mailer.dal.entity.User;
import java.util.List;

/**
 *
 * @author d.pochernin
 */
public interface IContactDAO {
    
    public List<Contact> getAll();
    public boolean  addNew (Contact contact);
    public List<Contact> findByName (String name);
    public Contact getById (Integer contactId);
    public List<Contact> findByEmail (String email);
    public List<Contact> findByPhone (String phone);
    public Contact edit (Contact contact);
    public Contact remove(Contact contact);
    public ContactsGroup getGroup (Contact contact);
    public User getOwner (Contact contact);
    
}
