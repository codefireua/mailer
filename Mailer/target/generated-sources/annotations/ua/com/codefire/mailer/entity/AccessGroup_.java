package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(AccessGroup.class)
public class AccessGroup_ { 

    public static volatile SingularAttribute<AccessGroup, Integer> moderator;
    public static volatile SingularAttribute<AccessGroup, Integer> id;
    public static volatile SingularAttribute<AccessGroup, Integer> user;
    public static volatile SingularAttribute<AccessGroup, Users> userId;

}