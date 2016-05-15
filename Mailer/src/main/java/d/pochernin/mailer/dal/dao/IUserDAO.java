/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.dao;

import d.pochernin.mailer.dal.entity.Contact;
import d.pochernin.mailer.dal.entity.ContactsGroup;
import d.pochernin.mailer.dal.entity.Delivery;
import d.pochernin.mailer.dal.entity.EmlUsersTemplate;
import d.pochernin.mailer.dal.entity.User;
import java.util.List;
import java.util.Set;

/**
 *
 * @author d.pochernin
 */
public interface IUserDAO {
  
  public List<User> getAll();  
  public boolean addNew (User user);
  public User findByID (int id);
  public List<User> findByName (String name);
  public User findByEmail (String email);
  public User edit (User user);
  public User remove (User user);
  public Set<EmlUsersTemplate> getEmlTemplates (User user);
  public Set<Delivery> getDeliverys (User user);
  public Set<ContactsGroup> getContactGroups (User user);
  public Set<Contact> getContacts (User user);
  
}
