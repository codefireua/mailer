/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.dal.interfaces;

import d.pochernin.dal.objects.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author d.pochernin
 */
public interface IDAO_ContactsAndContactGroups {
    
    List<Contact> getAllContacts();
    List<Contact> getAllUserContacts(int userId);
    List<Contact> getContactByName (String name);
    List<Contact> getContactsByGroup (int groupId);
    Map<Integer, String> getAllGroupsOfUser (int userId);
    Boolean addContact (String contactName, String contactEmail, int userId);
    Boolean addContact (String contactName, String contactEmail, String contactPhone, int contactGroup, int userId);
    Contact editContact (Contact newContact, int contactId);
    Boolean deleteContact (int contactId);
    Boolean addNewGroup (String groupName, int userId);
    Boolean deleteGroup (int groupId, int userId);
    
}
