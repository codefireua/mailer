/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.entity;

import java.io.Serializable;
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
 * @author HP-Davydoff
 */
@Entity
@Table(name = "delivery_contact_list", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryContactList.findAll", query = "SELECT d FROM DeliveryContactList d"),
    @NamedQuery(name = "DeliveryContactList.findById", query = "SELECT d FROM DeliveryContactList d WHERE d.id = :id")})
public class DeliveryContactList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id", nullable = false)
    @ManyToOne(optional = false)
    private ContactList contactId;
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false)
    @ManyToOne(optional = false)
    private Delivery deliveryId;

    public DeliveryContactList() {
    }

    public DeliveryContactList(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactList getContactId() {
        return contactId;
    }

    public void setContactId(ContactList contactId) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryContactList)) {
            return false;
        }
        DeliveryContactList other = (DeliveryContactList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.DeliveryContactList[ id=" + id + " ]";
    }
    
}
