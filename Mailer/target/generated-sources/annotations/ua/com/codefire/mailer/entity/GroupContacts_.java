package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.ContactList;
import ua.com.codefire.mailer.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(GroupContacts.class)
public class GroupContacts_ { 

    public static volatile SingularAttribute<GroupContacts, String> groupName;
    public static volatile SingularAttribute<GroupContacts, Users> groupOwner;
    public static volatile SingularAttribute<GroupContacts, Integer> groupId;
    public static volatile CollectionAttribute<GroupContacts, ContactList> contactListCollection;

}