/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.dal.interfaces;

import d.pochernin.dal.objects.Contact;
import d.pochernin.dal.objects.Delivery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author d.pochernin
 */
public interface IDAO_Delivery {

    Boolean addNewDelivery(String deliveryShablonName, String deliveryFrom, String deliverySubject, String deliveryBodyMessage, Integer userId,
            List<Integer> contactsId, Map<String, Integer> deliveryType);
    List<Contact> getContactsOfDelivery(int deliveryId);
    Map<String, Integer> getDeliveryType (int deliveryId);
    List<Delivery> getDelyveryByUser (int userId);
    List<Delivery> getDelyveryBySubject (String deliverySubject);
    List<Delivery> getDelyveryByName (String deliveryShablonName);
    Boolean deleteDelivery (int deliveryId,int userId);
    
}
