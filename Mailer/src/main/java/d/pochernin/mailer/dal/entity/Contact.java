/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "contact_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "Contact.findByContactName", query = "SELECT c FROM Contact c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "Contact.findByContactEmail", query = "SELECT c FROM Contact c WHERE c.contactEmail = :contactEmail"),
    @NamedQuery(name = "Contact.findByContactPhone", query = "SELECT c FROM Contact c WHERE c.contactPhone = :contactPhone")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Size(max = 255)
    @Column(name = "contact_name")
    private String contactName;
    @Size(max = 255)
    @Column(name = "contact_email")
    private String contactEmail;
    @Size(max = 255)
    @Column(name = "contact_phone")
    private String contactPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Set<DeliveryContactList> deliveryContactListCollection;
    @JoinColumn(name = "contact_group", referencedColumnName = "group_id")
    @ManyToOne
    private ContactsGroup contactGroup;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    public Contact() {
    }

    public Contact(String contactName, String contactEmail, String contactPhone, ContactsGroup contactGroup, User userId) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactGroup = contactGroup;
        this.userId = userId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @XmlTransient
    public Set<DeliveryContactList> getDeliveryContactListCollection() {
        return deliveryContactListCollection;
    }

    public void setDeliveryContactListCollection(Set<DeliveryContactList> deliveryContactListCollection) {
        this.deliveryContactListCollection = deliveryContactListCollection;
    }

    public ContactsGroup getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(ContactsGroup contactGroup) {
        this.contactGroup = contactGroup;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.contactId);
        hash = 97 * hash + Objects.hashCode(this.contactName);
        hash = 97 * hash + Objects.hashCode(this.contactEmail);
        hash = 97 * hash + Objects.hashCode(this.contactPhone);
        hash = 97 * hash + Objects.hashCode(this.contactGroup);
        hash = 97 * hash + Objects.hashCode(this.userId);
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.contactName, other.contactName)) {
            return false;
        }
        if (!Objects.equals(this.contactEmail, other.contactEmail)) {
            return false;
        }
        if (!Objects.equals(this.contactPhone, other.contactPhone)) {
            return false;
        }
        if (!Objects.equals(this.contactId, other.contactId)) {
            return false;
        }
        if (!Objects.equals(this.contactGroup, other.contactGroup)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + ", contactGroup=" + contactGroup + ", userId=" + userId + '}';
    }
    
}
