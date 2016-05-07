/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "group_contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactsGroup.findAll", query = "SELECT c FROM ContactsGroup c"),
    @NamedQuery(name = "ContactsGroup.findByGroupId", query = "SELECT c FROM ContactsGroup c WHERE c.groupId = :groupId"),
    @NamedQuery(name = "ContactsGroup.findByGroupName", query = "SELECT c FROM ContactsGroup c WHERE c.groupName = :groupName")})
public class ContactsGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Size(max = 255)
    @Column(name = "group_name")
    private String groupName;
    @JoinColumn(name = "group_owner", referencedColumnName = "user_id")
    @ManyToOne
    private User groupOwner;
    @OneToMany(mappedBy = "contactGroup")
    private Collection<Contact> contactListCollection;

    public ContactsGroup() {
    }

    public ContactsGroup(String groupName, User groupOwner) {
        this.groupName = groupName;
        this.groupOwner = groupOwner;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(User groupOwner) {
        this.groupOwner = groupOwner;
    }

    @XmlTransient
    public Collection<Contact> getContactListCollection() {
        return contactListCollection;
    }

    public void setContactListCollection(Collection<Contact> contactListCollection) {
        this.contactListCollection = contactListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.groupId);
        hash = 37 * hash + Objects.hashCode(this.groupName);
        hash = 37 * hash + Objects.hashCode(this.groupOwner);
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
        final ContactsGroup other = (ContactsGroup) obj;
        if (!Objects.equals(this.groupName, other.groupName)) {
            return false;
        }
        if (!Objects.equals(this.groupId, other.groupId)) {
            return false;
        }
        if (!Objects.equals(this.groupOwner, other.groupOwner)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContactsGroup{" + "groupId=" + groupId + ", groupName=" + groupName + ", groupOwner=" + groupOwner + '}';
    }
   
}
