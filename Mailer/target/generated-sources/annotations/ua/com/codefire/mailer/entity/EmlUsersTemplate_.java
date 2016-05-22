package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(EmlUsersTemplate.class)
public class EmlUsersTemplate_ { 

    public static volatile SingularAttribute<EmlUsersTemplate, String> templateHeader;
    public static volatile SingularAttribute<EmlUsersTemplate, String> templateName;
    public static volatile SingularAttribute<EmlUsersTemplate, String> templateBody;
    public static volatile SingularAttribute<EmlUsersTemplate, Integer> templateId;
    public static volatile SingularAttribute<EmlUsersTemplate, Users> templateOwner;

}