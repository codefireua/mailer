/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d FROM Delivery d WHERE d.deliveryId = :deliveryId"),
    @NamedQuery(name = "Delivery.findByDeliveryShablonName", query = "SELECT d FROM Delivery d WHERE d.deliveryShablonName = :deliveryShablonName"),
    @NamedQuery(name = "Delivery.findByDeliveryFrom", query = "SELECT d FROM Delivery d WHERE d.deliveryFrom = :deliveryFrom"),
    @NamedQuery(name = "Delivery.findByDeliverySubject", query = "SELECT d FROM Delivery d WHERE d.deliverySubject = :deliverySubject"),
    @NamedQuery(name = "Delivery.findByDeliveryDate", query = "SELECT d FROM Delivery d WHERE d.deliveryDate = :deliveryDate")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "delivery_id")
    private Integer deliveryId;
    @Size(max = 255)
    @Column(name = "delivery_shablon_name")
    private String deliveryShablonName;
    @Size(max = 255)
    @Column(name = "delivery_from")
    private String deliveryFrom;
    @Size(max = 255)
    @Column(name = "delivery_subject")
    private String deliverySubject;
    @Lob
    @Size(max = 65535)
    @Column(name = "delivery_body_message")
    private String deliveryBodyMessage;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String deliveryDate;
    @JoinColumn(name = "delivery_owner", referencedColumnName = "user_id")
    @ManyToOne
    private User deliveryOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryId")
    private Collection<DeliveryContactList> deliveryContactListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private Collection<DeliveryType> deliveryTypeCollection;

    public Delivery() {
    }

    public Delivery(String deliveryShablonName, String deliveryFrom, String deliverySubject, String deliveryBodyMessage, String deliveryDate, User deliveryOwner) {
        this.deliveryShablonName = deliveryShablonName;
        this.deliveryFrom = deliveryFrom;
        this.deliverySubject = deliverySubject;
        this.deliveryBodyMessage = deliveryBodyMessage;
        this.deliveryDate = deliveryDate;
        this.deliveryOwner = deliveryOwner;
    }

    

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryShablonName() {
        return deliveryShablonName;
    }

    public void setDeliveryShablonName(String deliveryShablonName) {
        this.deliveryShablonName = deliveryShablonName;
    }

    public String getDeliveryFrom() {
        return deliveryFrom;
    }

    public void setDeliveryFrom(String deliveryFrom) {
        this.deliveryFrom = deliveryFrom;
    }

    public String getDeliverySubject() {
        return deliverySubject;
    }

    public void setDeliverySubject(String deliverySubject) {
        this.deliverySubject = deliverySubject;
    }

    public String getDeliveryBodyMessage() {
        return deliveryBodyMessage;
    }

    public void setDeliveryBodyMessage(String deliveryBodyMessage) {
        this.deliveryBodyMessage = deliveryBodyMessage;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public User getDeliveryOwner() {
        return deliveryOwner;
    }

    public void setDeliveryOwner(User deliveryOwner) {
        this.deliveryOwner = deliveryOwner;
    }

    @XmlTransient
    public Collection<DeliveryContactList> getDeliveryContactListCollection() {
        return deliveryContactListCollection;
    }

    public void setDeliveryContactListCollection(Collection<DeliveryContactList> deliveryContactListCollection) {
        this.deliveryContactListCollection = deliveryContactListCollection;
    }

    @XmlTransient
    public Collection<DeliveryType> getDeliveryTypeCollection() {
        return deliveryTypeCollection;
    }

    public void setDeliveryTypeCollection(Collection<DeliveryType> deliveryTypeCollection) {
        this.deliveryTypeCollection = deliveryTypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.deliveryId);
        hash = 89 * hash + Objects.hashCode(this.deliveryShablonName);
        hash = 89 * hash + Objects.hashCode(this.deliveryFrom);
        hash = 89 * hash + Objects.hashCode(this.deliverySubject);
        hash = 89 * hash + Objects.hashCode(this.deliveryBodyMessage);
        hash = 89 * hash + Objects.hashCode(this.deliveryDate);
        hash = 89 * hash + Objects.hashCode(this.deliveryOwner);
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
        final Delivery other = (Delivery) obj;
        if (!Objects.equals(this.deliveryShablonName, other.deliveryShablonName)) {
            return false;
        }
        if (!Objects.equals(this.deliveryFrom, other.deliveryFrom)) {
            return false;
        }
        if (!Objects.equals(this.deliverySubject, other.deliverySubject)) {
            return false;
        }
        if (!Objects.equals(this.deliveryBodyMessage, other.deliveryBodyMessage)) {
            return false;
        }
        if (!Objects.equals(this.deliveryDate, other.deliveryDate)) {
            return false;
        }
        if (!Objects.equals(this.deliveryId, other.deliveryId)) {
            return false;
        }
        if (!Objects.equals(this.deliveryOwner, other.deliveryOwner)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Delivery{" + "deliveryId=" + deliveryId + ", deliveryShablonName=" + deliveryShablonName + ", deliveryFrom=" + deliveryFrom + ", deliverySubject=" + deliverySubject + ", deliveryBodyMessage=" + deliveryBodyMessage + ", deliveryDate=" + deliveryDate + ", deliveryOwner=" + deliveryOwner + '}';
    }
  
}
