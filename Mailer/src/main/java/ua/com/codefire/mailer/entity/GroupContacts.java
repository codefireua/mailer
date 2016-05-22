/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author HP-Davydoff
 */
@Entity
@Table(name = "group_contacts", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupContacts.findAll", query = "SELECT g FROM GroupContacts g"),
    @NamedQuery(name = "GroupContacts.findByGroupId", query = "SELECT g FROM GroupContacts g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupContacts.findByGroupName", query = "SELECT g FROM GroupContacts g WHERE g.groupName = :groupName")})
public class GroupContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id", nullable = false)
    private Integer groupId;
    @Size(max = 255)
    @Column(name = "group_name", length = 255)
    private String groupName;
    @JoinColumn(name = "group_owner", referencedColumnName = "user_id")
    @ManyToOne
    private Users groupOwner;
    @OneToMany(mappedBy = "contactGroup")
    private Collection<ContactList> contactListCollection;

    public GroupContacts() {
    }

    public GroupContacts(Integer groupId) {
        this.groupId = groupId;
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

    public Users getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(Users groupOwner) {
        this.groupOwner = groupOwner;
    }

    @XmlTransient
    public Collection<ContactList> getContactListCollection() {
        return contactListCollection;
    }

    public void setContactListCollection(Collection<ContactList> contactListCollection) {
        this.contactListCollection = contactListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupContacts)) {
            return false;
        }
        GroupContacts other = (GroupContacts) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.GroupContacts[ groupId=" + groupId + " ]";
    }
    
}
