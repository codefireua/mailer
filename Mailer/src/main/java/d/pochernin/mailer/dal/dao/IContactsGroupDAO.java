/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.dao;

import d.pochernin.mailer.dal.entity.ContactsGroup;
import d.pochernin.mailer.dal.entity.User;
import java.util.List;

/**
 *
 * @author d.pochernin
 */
public interface IContactsGroupDAO {

    public List<ContactsGroup> getAll();
    public ContactsGroup getById(Integer id);
    public List<ContactsGroup> findByName(String name);
    public List<ContactsGroup> getByOwner(User user);
    public boolean addNew(ContactsGroup contactgroup);
    public ContactsGroup edit (ContactsGroup contactgroup);
    public ContactsGroup remove (ContactsGroup contactsgroup);
    
}
