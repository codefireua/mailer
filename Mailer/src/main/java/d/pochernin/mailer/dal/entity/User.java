/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
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
 * @author d.pochernin
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserPwd", query = "SELECT u FROM User u WHERE u.userPwd = :userPwd"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pwd")
    private String userPwd;
    @Size(max = 255)
    @Column(name = "user_name")
    private String userName;
    @OneToMany(mappedBy = "templateOwner")
    private Set<EmlUsersTemplate> emlUsersTemplateCollection;
    @OneToMany(mappedBy = "deliveryOwner")
    private Set<Delivery> deliveryCollection;
    @OneToMany(mappedBy = "groupOwner")
    private Set<ContactsGroup> contactsGroupCollection;
    @OneToMany(mappedBy = "userId")
    private Set<Contact> contactListCollection;

    public User() {
    }

    public User(String userEmail, String userPwd, String userName) {
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userName = userName;
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
    public Set<EmlUsersTemplate> getEmlUsersTemplateCollection() {
        return emlUsersTemplateCollection;
    }

    public void setEmlUsersTemplateCollection(Set<EmlUsersTemplate> emlUsersTemplateCollection) {
        this.emlUsersTemplateCollection = emlUsersTemplateCollection;
    }

    @XmlTransient
    public Set<Delivery> getDeliveryCollection() {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Set<Delivery> deliveryCollection) {
        this.deliveryCollection = deliveryCollection;
    }

    @XmlTransient
    public Set<ContactsGroup> getContactsGroupCollection() {
        return contactsGroupCollection;
    }

    public void setContactsGroupCollection(Set<ContactsGroup> contactsGroupCollection) {
        this.contactsGroupCollection = contactsGroupCollection;
    }

    @XmlTransient
    public Set<Contact> getContactListCollection() {
        return contactListCollection;
    }

    public void setContactListCollection(Set<Contact> contactListCollection) {
        this.contactListCollection = contactListCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.userId);
        hash = 23 * hash + Objects.hashCode(this.userEmail);
        hash = 23 * hash + Objects.hashCode(this.userPwd);
        hash = 23 * hash + Objects.hashCode(this.userName);
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
        final User other = (User) obj;
        if (!Objects.equals(this.userEmail, other.userEmail)) {
            return false;
        }
        if (!Objects.equals(this.userPwd, other.userPwd)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", userName=" + userName + '}';
    }
    
}
