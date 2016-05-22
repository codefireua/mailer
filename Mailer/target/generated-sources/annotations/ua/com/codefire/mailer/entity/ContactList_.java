package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.DeliveryContactList;
import ua.com.codefire.mailer.entity.GroupContacts;
import ua.com.codefire.mailer.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(ContactList.class)
public class ContactList_ { 

    public static volatile SingularAttribute<ContactList, Integer> contactId;
    public static volatile SingularAttribute<ContactList, String> contactEmail;
    public static volatile SingularAttribute<ContactList, String> contactName;
    public static volatile SingularAttribute<ContactList, GroupContacts> contactGroup;
    public static volatile CollectionAttribute<ContactList, DeliveryContactList> deliveryContactListCollection;
    public static volatile SingularAttribute<ContactList, String> contactPhone;
    public static volatile SingularAttribute<ContactList, Users> userId;

}