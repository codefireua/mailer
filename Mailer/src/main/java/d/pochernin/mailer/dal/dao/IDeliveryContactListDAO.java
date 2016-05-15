/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.dao;

import d.pochernin.mailer.dal.entity.Contact;
import d.pochernin.mailer.dal.entity.Delivery;
import d.pochernin.mailer.dal.entity.DeliveryContactList;
import java.util.List;

/**
 *
 * @author d.pochernin
 */
public interface IDeliveryContactListDAO {
    
    public List<DeliveryContactList> getAll();
    public DeliveryContactList getById(Integer id);
    public List<DeliveryContactList> findByContact(Contact contact);
    public List<DeliveryContactList> findByDelivery(Delivery delivery);
    public boolean addNew (DeliveryContactList deliveryContactList);
    public DeliveryContactList remove(DeliveryContactList deliveryContactList);
            
}
