package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.ContactList;
import ua.com.codefire.mailer.entity.Delivery;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(DeliveryContactList.class)
public class DeliveryContactList_ { 

    public static volatile SingularAttribute<DeliveryContactList, Delivery> deliveryId;
    public static volatile SingularAttribute<DeliveryContactList, ContactList> contactId;
    public static volatile SingularAttribute<DeliveryContactList, Integer> id;

}