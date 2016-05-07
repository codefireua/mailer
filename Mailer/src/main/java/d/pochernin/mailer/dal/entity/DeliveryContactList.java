/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "delivery_contact_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryContactList.findAll", query = "SELECT d FROM DeliveryContactList d"),
    @NamedQuery(name = "DeliveryContactList.findById", query = "SELECT d FROM DeliveryContactList d WHERE d.id = :id")})
public class DeliveryContactList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    @ManyToOne(optional = false)
    private Contact contactId;
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    @ManyToOne(optional = false)
    private Delivery deliveryId;

    public DeliveryContactList() {
    }

    public DeliveryContactList(Contact contactId, Delivery deliveryId) {
        this.contactId = contactId;
        this.deliveryId = deliveryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    public Delivery getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Delivery deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.contactId);
        hash = 47 * hash + Objects.hashCode(this.deliveryId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeliveryContactList other = (DeliveryContactList) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.contactId, other.contactId)) {
            return false;
        }
        if (!Objects.equals(this.deliveryId, other.deliveryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DeliveryContactList{" + "id=" + id + ", contactId=" + contactId + ", deliveryId=" + deliveryId + '}';
    }

}
