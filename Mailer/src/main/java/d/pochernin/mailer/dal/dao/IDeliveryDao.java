/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.dao;

import d.pochernin.mailer.dal.entity.Delivery;
import d.pochernin.mailer.dal.entity.DeliveryType;
import d.pochernin.mailer.dal.entity.User;
import java.util.List;

/**
 *
 * @author d.pochernin
 */
public interface IDeliveryDao {
    
    public List<Delivery> getAll();
    public boolean addNew(Delivery delivery);
    public Delivery getById(Integer deliveryId);
    public List<Delivery> findByDate(String deliveryDate);
    public List<Delivery> findByName(String deliveryShablonName);
    public Delivery edit(Delivery delivert);
    public Delivery remove(Delivery delivert);
    public List<String> getDeliveryContacts(Delivery delivery);
    public List<DeliveryType>getDeliveryType(Delivery delivery);
    
}
