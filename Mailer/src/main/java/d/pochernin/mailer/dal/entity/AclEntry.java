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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "acl_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclEntry.findAll", query = "SELECT a FROM AclEntry a"),
    @NamedQuery(name = "AclEntry.findById", query = "SELECT a FROM AclEntry a WHERE a.id = :id"),
    @NamedQuery(name = "AclEntry.findByAceOrder", query = "SELECT a FROM AclEntry a WHERE a.aceOrder = :aceOrder"),
    @NamedQuery(name = "AclEntry.findByMask", query = "SELECT a FROM AclEntry a WHERE a.mask = :mask"),
    @NamedQuery(name = "AclEntry.findByGranting", query = "SELECT a FROM AclEntry a WHERE a.granting = :granting"),
    @NamedQuery(name = "AclEntry.findByAuditSuccess", query = "SELECT a FROM AclEntry a WHERE a.auditSuccess = :auditSuccess"),
    @NamedQuery(name = "AclEntry.findByAuditFailure", query = "SELECT a FROM AclEntry a WHERE a.auditFailure = :auditFailure")})
public class AclEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ace_order")
    private int aceOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mask")
    private int mask;
    @Basic(optional = false)
    @NotNull
    @Column(name = "granting")
    private boolean granting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "audit_success")
    private boolean auditSuccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "audit_failure")
    private boolean auditFailure;
    @JoinColumn(name = "acl_object_identity", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AclObjectIdentity aclObjectIdentity;
    @JoinColumn(name = "sid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AclSid sid;

    public AclEntry() {
    }

    public AclEntry(int aceOrder, int mask, boolean granting, boolean auditSuccess, boolean auditFailure, AclObjectIdentity aclObjectIdentity, AclSid sid) {
        this.aceOrder = aceOrder;
        this.mask = mask;
        this.granting = granting;
        this.auditSuccess = auditSuccess;
        this.auditFailure = auditFailure;
        this.aclObjectIdentity = aclObjectIdentity;
        this.sid = sid;
    }

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAceOrder() {
        return aceOrder;
    }

    public void setAceOrder(int aceOrder) {
        this.aceOrder = aceOrder;
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public boolean getGranting() {
        return granting;
    }

    public void setGranting(boolean granting) {
        this.granting = granting;
    }

    public boolean getAuditSuccess() {
        return auditSuccess;
    }

    public void setAuditSuccess(boolean auditSuccess) {
        this.auditSuccess = auditSuccess;
    }

    public boolean getAuditFailure() {
        return auditFailure;
    }

    public void setAuditFailure(boolean auditFailure) {
        this.auditFailure = auditFailure;
    }

    public AclObjectIdentity getAclObjectIdentity() {
        return aclObjectIdentity;
    }

    public void setAclObjectIdentity(AclObjectIdentity aclObjectIdentity) {
        this.aclObjectIdentity = aclObjectIdentity;
    }

    public AclSid getSid() {
        return sid;
    }

    public void setSid(AclSid sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + this.aceOrder;
        hash = 31 * hash + this.mask;
        hash = 31 * hash + (this.granting ? 1 : 0);
        hash = 31 * hash + (this.auditSuccess ? 1 : 0);
        hash = 31 * hash + (this.auditFailure ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.aclObjectIdentity);
        hash = 31 * hash + Objects.hashCode(this.sid);
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
        final AclEntry other = (AclEntry) obj;
        if (this.aceOrder != other.aceOrder) {
            return false;
        }
        if (this.mask != other.mask) {
            return false;
        }
        if (this.granting != other.granting) {
            return false;
        }
        if (this.auditSuccess != other.auditSuccess) {
            return false;
        }
        if (this.auditFailure != other.auditFailure) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.aclObjectIdentity, other.aclObjectIdentity)) {
            return false;
        }
        if (!Objects.equals(this.sid, other.sid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AclEntry{" + "id=" + id + ", aceOrder=" + aceOrder + ", mask=" + mask + ", granting=" + granting + ", auditSuccess=" + auditSuccess + ", auditFailure=" + auditFailure + ", aclObjectIdentity=" + aclObjectIdentity + ", sid=" + sid + '}';
    }

   
}
