package ua.com.codefire.mailer.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.DeliveryContactList;
import ua.com.codefire.mailer.entity.DeliveryType;
import ua.com.codefire.mailer.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(Delivery.class)
public class Delivery_ { 

    public static volatile SingularAttribute<Delivery, String> deliverySubject;
    public static volatile SingularAttribute<Delivery, String> deliveryFrom;
    public static volatile SingularAttribute<Delivery, Integer> deliveryId;
    public static volatile SingularAttribute<Delivery, String> deliveryShablonName;
    public static volatile CollectionAttribute<Delivery, DeliveryType> deliveryTypeCollection;
    public static volatile SingularAttribute<Delivery, String> deliveryBodyMessage;
    public static volatile CollectionAttribute<Delivery, DeliveryContactList> deliveryContactListCollection;
    public static volatile SingularAttribute<Delivery, Date> deliveryDate;
    public static volatile SingularAttribute<Delivery, Users> deliveryOwner;

}