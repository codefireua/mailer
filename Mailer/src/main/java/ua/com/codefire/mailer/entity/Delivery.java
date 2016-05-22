/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author HP-Davydoff
 */
@Entity
@Table(name = "delivery", catalog = "mailer", schema = "")
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
    @Column(name = "delivery_id", nullable = false)
    private Integer deliveryId;
    @Size(max = 255)
    @Column(name = "delivery_shablon_name", length = 255)
    private String deliveryShablonName;
    @Size(max = 255)
    @Column(name = "delivery_from", length = 255)
    private String deliveryFrom;
    @Size(max = 255)
    @Column(name = "delivery_subject", length = 255)
    private String deliverySubject;
    @Lob
    @Size(max = 65535)
    @Column(name = "delivery_body_message", length = 65535)
    private String deliveryBodyMessage;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @JoinColumn(name = "delivery_owner", referencedColumnName = "user_id")
    @ManyToOne
    private Users deliveryOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryId")
    private Collection<DeliveryContactList> deliveryContactListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private Collection<DeliveryType> deliveryTypeCollection;

    public Delivery() {
    }

    public Delivery(Integer deliveryId) {
        this.deliveryId = deliveryId;
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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Users getDeliveryOwner() {
        return deliveryOwner;
    }

    public void setDeliveryOwner(Users deliveryOwner) {
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
        int hash = 0;
        hash += (deliveryId != null ? deliveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryId == null && other.deliveryId != null) || (this.deliveryId != null && !this.deliveryId.equals(other.deliveryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.Delivery[ deliveryId=" + deliveryId + " ]";
    }
    
}
