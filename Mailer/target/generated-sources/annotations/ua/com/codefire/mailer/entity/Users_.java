package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.AccessGroup;
import ua.com.codefire.mailer.entity.ContactList;
import ua.com.codefire.mailer.entity.Delivery;
import ua.com.codefire.mailer.entity.EmlUsersTemplate;
import ua.com.codefire.mailer.entity.GroupContacts;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Delivery> deliveryCollection;
    public static volatile CollectionAttribute<Users, EmlUsersTemplate> emlUsersTemplateCollection;
    public static volatile SingularAttribute<Users, String> userPwd;
    public static volatile SingularAttribute<Users, String> userEmail;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile CollectionAttribute<Users, GroupContacts> groupContactsCollection;
    public static volatile CollectionAttribute<Users, ContactList> contactListCollection;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile CollectionAttribute<Users, AccessGroup> accessGroupCollection;

}