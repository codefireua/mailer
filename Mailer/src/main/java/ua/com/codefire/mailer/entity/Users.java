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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP-Davydoff
 */
@Entity
@Table(name = "users", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserPwd", query = "SELECT u FROM Users u WHERE u.userPwd = :userPwd"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_email", nullable = false, length = 255)
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pwd", nullable = false, length = 255)
    private String userPwd;
    @Size(max = 255)
    @Column(name = "user_name", length = 255)
    private String userName;
    @OneToMany(mappedBy = "templateOwner")
    private Collection<EmlUsersTemplate> emlUsersTemplateCollection;
    @OneToMany(mappedBy = "deliveryOwner")
    private Collection<Delivery> deliveryCollection;
    @OneToMany(mappedBy = "groupOwner")
    private Collection<GroupContacts> groupContactsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<ContactList> contactListCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<AccessGroup> accessGroupCollection;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userEmail, String userPwd) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlTransient
    public Collection<EmlUsersTemplate> getEmlUsersTemplateCollection() {
        return emlUsersTemplateCollection;
    }

    public void setEmlUsersTemplateCollection(Collection<EmlUsersTemplate> emlUsersTemplateCollection) {
        this.emlUsersTemplateCollection = emlUsersTemplateCollection;
    }

    @XmlTransient
    public Collection<Delivery> getDeliveryCollection() {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Collection<Delivery> deliveryCollection) {
        this.deliveryCollection = deliveryCollection;
    }

    @XmlTransient
    public Collection<GroupContacts> getGroupContactsCollection() {
        return groupContactsCollection;
    }

    public void setGroupContactsCollection(Collection<GroupContacts> groupContactsCollection) {
        this.groupContactsCollection = groupContactsCollection;
    }

    @XmlTransient
    public Collection<ContactList> getContactListCollection() {
        return contactListCollection;
    }

    public void setContactListCollection(Collection<ContactList> contactListCollection) {
        this.contactListCollection = contactListCollection;
    }

    @XmlTransient
    public Collection<AccessGroup> getAccessGroupCollection() {
        return accessGroupCollection;
    }

    public void setAccessGroupCollection(Collection<AccessGroup> accessGroupCollection) {
        this.accessGroupCollection = accessGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.Users[ userId=" + userId + " ]";
    }
    
}
