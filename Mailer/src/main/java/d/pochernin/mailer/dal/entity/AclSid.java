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
 * @author d.pochernin
 */
@Entity
@Table(name = "acl_sid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclSid.findAll", query = "SELECT a FROM AclSid a"),
    @NamedQuery(name = "AclSid.findById", query = "SELECT a FROM AclSid a WHERE a.id = :id"),
    @NamedQuery(name = "AclSid.findByPrincipal", query = "SELECT a FROM AclSid a WHERE a.principal = :principal"),
    @NamedQuery(name = "AclSid.findBySid", query = "SELECT a FROM AclSid a WHERE a.sid = :sid")})
public class AclSid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "principal")
    private boolean principal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sid")
    private String sid;
    @OneToMany(mappedBy = "ownerSid")
    private Collection<AclObjectIdentity> aclObjectIdentityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private Collection<AclEntry> aclEntryCollection;

    public AclSid() {
    }

   
    public AclSid(boolean principal, String sid) {
        this.id = id;
        this.principal = principal;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @XmlTransient
    public Collection<AclObjectIdentity> getAclObjectIdentityCollection() {
        return aclObjectIdentityCollection;
    }

    public void setAclObjectIdentityCollection(Collection<AclObjectIdentity> aclObjectIdentityCollection) {
        this.aclObjectIdentityCollection = aclObjectIdentityCollection;
    }

    @XmlTransient
    public Collection<AclEntry> getAclEntryCollection() {
        return aclEntryCollection;
    }

    public void setAclEntryCollection(Collection<AclEntry> aclEntryCollection) {
        this.aclEntryCollection = aclEntryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + (this.principal ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.sid);
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
        final AclSid other = (AclSid) obj;
        if (this.principal != other.principal) {
            return false;
        }
        if (!Objects.equals(this.sid, other.sid)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
