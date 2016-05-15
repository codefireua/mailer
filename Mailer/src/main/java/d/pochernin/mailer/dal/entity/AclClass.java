/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.mailer.dal.entity;

import java.io.Serializable;
//import java.util.Collection;
import java.util.Objects;
import java.util.Set;
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
@Table(name = "acl_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclClass.findAll", query = "SELECT a FROM AclClass a"),
    @NamedQuery(name = "AclClass.findById", query = "SELECT a FROM AclClass a WHERE a.id = :id"),
    @NamedQuery(name = "AclClass.findByClass1", query = "SELECT a FROM AclClass a WHERE a.class1 = :class1")})
public class AclClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "class")
    private String class1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectIdClass")
    private Set<AclObjectIdentity> aclObjectIdentityCollection;

    public AclClass() {
    }

    public AclClass(String class1) {
        this.class1 = class1;
    }

  
    public AclClass(Integer id, String class1) {
        this.id = id;
        this.class1 = class1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @XmlTransient
    public Set<AclObjectIdentity> getAclObjectIdentityCollection() {
        return aclObjectIdentityCollection;
    }

    public void setAclObjectIdentityCollection(Set<AclObjectIdentity> aclObjectIdentityCollection) {
        this.aclObjectIdentityCollection = aclObjectIdentityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.class1);
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
        final AclClass other = (AclClass) obj;
        if (!Objects.equals(this.class1, other.class1)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AclClass{" + "id=" + id + ", class1=" + class1 + '}';
    }
   
}
