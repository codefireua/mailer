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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "acl_object_identity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclObjectIdentity.findAll", query = "SELECT a FROM AclObjectIdentity a"),
    @NamedQuery(name = "AclObjectIdentity.findById", query = "SELECT a FROM AclObjectIdentity a WHERE a.id = :id"),
    @NamedQuery(name = "AclObjectIdentity.findByObjectIdIdentity", query = "SELECT a FROM AclObjectIdentity a WHERE a.objectIdIdentity = :objectIdIdentity"),
    @NamedQuery(name = "AclObjectIdentity.findByEntriesInheriting", query = "SELECT a FROM AclObjectIdentity a WHERE a.entriesInheriting = :entriesInheriting")})
public class AclObjectIdentity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "object_id_identity")
    private int objectIdIdentity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entries_inheriting")
    private boolean entriesInheriting;
    @JoinColumn(name = "object_id_class", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AclClass objectIdClass;
    @OneToMany(mappedBy = "parentObject")
    private Collection<AclObjectIdentity> aclObjectIdentityCollection;
    @JoinColumn(name = "parent_object", referencedColumnName = "id")
    @ManyToOne
    private AclObjectIdentity parentObject;
    @JoinColumn(name = "owner_sid", referencedColumnName = "id")
    @ManyToOne
    private AclSid ownerSid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aclObjectIdentity")
    private Collection<AclEntry> aclEntryCollection;

    public AclObjectIdentity() {
    }

    public AclObjectIdentity(int objectIdIdentity, boolean entriesInheriting) {
        this.id = id;
        this.objectIdIdentity = objectIdIdentity;
        this.entriesInheriting = entriesInheriting;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getObjectIdIdentity() {
        return objectIdIdentity;
    }

    public void setObjectIdIdentity(int objectIdIdentity) {
        this.objectIdIdentity = objectIdIdentity;
    }

    public boolean getEntriesInheriting() {
        return entriesInheriting;
    }

    public void setEntriesInheriting(boolean entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
    }

    public AclClass getObjectIdClass() {
        return objectIdClass;
    }

    public void setObjectIdClass(AclClass objectIdClass) {
        this.objectIdClass = objectIdClass;
    }

    @XmlTransient
    public Collection<AclObjectIdentity> getAclObjectIdentityCollection() {
        return aclObjectIdentityCollection;
    }

    public void setAclObjectIdentityCollection(Collection<AclObjectIdentity> aclObjectIdentityCollection) {
        this.aclObjectIdentityCollection = aclObjectIdentityCollection;
    }

    public AclObjectIdentity getParentObject() {
        return parentObject;
    }

    public void setParentObject(AclObjectIdentity parentObject) {
        this.parentObject = parentObject;
    }

    public AclSid getOwnerSid() {
        return ownerSid;
    }

    public void setOwnerSid(AclSid ownerSid) {
        this.ownerSid = ownerSid;
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
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + this.objectIdIdentity;
        hash = 83 * hash + (this.entriesInheriting ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.objectIdClass);
        hash = 83 * hash + Objects.hashCode(this.parentObject);
        hash = 83 * hash + Objects.hashCode(this.ownerSid);
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
        final AclObjectIdentity other = (AclObjectIdentity) obj;
        if (this.objectIdIdentity != other.objectIdIdentity) {
            return false;
        }
        if (this.entriesInheriting != other.entriesInheriting) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.objectIdClass, other.objectIdClass)) {
            return false;
        }
        if (!Objects.equals(this.parentObject, other.parentObject)) {
            return false;
        }
        if (!Objects.equals(this.ownerSid, other.ownerSid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AclObjectIdentity{" + "id=" + id + ", objectIdIdentity=" + objectIdIdentity + ", entriesInheriting=" + entriesInheriting + ", objectIdClass=" + objectIdClass + ", parentObject=" + parentObject + ", ownerSid=" + ownerSid + '}';
    }
    
}
