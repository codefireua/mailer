/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author HP-Davydoff
 */
@Entity
@Table(name = "contact_list", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactList.findAll", query = "SELECT c FROM ContactList c"),
    @NamedQuery(name = "ContactList.findByContactId", query = "SELECT c FROM ContactList c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "ContactList.findByContactName", query = "SELECT c FROM ContactList c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "ContactList.findByContactEmail", query = "SELECT c FROM ContactList c WHERE c.contactEmail = :contactEmail"),
    @NamedQuery(name = "ContactList.findByContactPhone", query = "SELECT c FROM ContactList c WHERE c.contactPhone = :contactPhone")})
public class ContactList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id", nullable = false)
    private Integer contactId;
    @Size(max = 255)
    @Column(name = "contact_name", length = 255)
    private String contactName;
    @Size(max = 255)
    @Column(name = "contact_email", length = 255)
    private String contactEmail;
    @Size(max = 255)
    @Column(name = "contact_phone", length = 255)
    private String contactPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Collection<DeliveryContactList> deliveryContactListCollection;
    @JoinColumn(name = "contact_group", referencedColumnName = "group_id")
    @ManyToOne
    private GroupContacts contactGroup;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public ContactList() {
    }

    public ContactList(Integer contactId) {
        this.contactId = contactId;
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
    public Collection<DeliveryContactList> getDeliveryContactListCollection() {
        return deliveryContactListCollection;
    }

    public void setDeliveryContactListCollection(Collection<DeliveryContactList> deliveryContactListCollection) {
        this.deliveryContactListCollection = deliveryContactListCollection;
    }

    public GroupContacts getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(GroupContacts contactGroup) {
        this.contactGroup = contactGroup;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactList)) {
            return false;
        }
        ContactList other = (ContactList) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.ContactList[ contactId=" + contactId + " ]";
    }
    
}
