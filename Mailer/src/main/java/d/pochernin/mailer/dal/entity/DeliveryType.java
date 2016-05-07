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
@Table(name = "delivery_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryType.findAll", query = "SELECT d FROM DeliveryType d"),
    @NamedQuery(name = "DeliveryType.findById", query = "SELECT d FROM DeliveryType d WHERE d.id = :id"),
    @NamedQuery(name = "DeliveryType.findByEmlDelivery", query = "SELECT d FROM DeliveryType d WHERE d.emlDelivery = :emlDelivery")})
public class DeliveryType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "eml_delivery")
    private Integer emlDelivery;
    @JoinColumn(name = "delivery", referencedColumnName = "delivery_id")
    @ManyToOne(optional = false)
    private Delivery delivery;

    public DeliveryType() {
    }

    public DeliveryType(Integer emlDelivery, Delivery delivery) {
        this.emlDelivery = emlDelivery;
        this.delivery = delivery;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmlDelivery() {
        return emlDelivery;
    }

    public void setEmlDelivery(Integer emlDelivery) {
        this.emlDelivery = emlDelivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.emlDelivery);
        hash = 97 * hash + Objects.hashCode(this.delivery);
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
        final DeliveryType other = (DeliveryType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.emlDelivery, other.emlDelivery)) {
            return false;
        }
        if (!Objects.equals(this.delivery, other.delivery)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DeliveryType{" + "id=" + id + ", emlDelivery=" + emlDelivery + ", delivery=" + delivery + '}';
    }
      
}
