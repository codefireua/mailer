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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "eml_body_blank", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmlBodyBlank.findAll", query = "SELECT e FROM EmlBodyBlank e"),
    @NamedQuery(name = "EmlBodyBlank.findByBodyId", query = "SELECT e FROM EmlBodyBlank e WHERE e.bodyId = :bodyId")})
public class EmlBodyBlank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "body_id", nullable = false)
    private Integer bodyId;
    @Lob
    @Size(max = 65535)
    @Column(name = "body_body", length = 65535)
    private String bodyBody;
    @OneToMany(mappedBy = "blankBody")
    private Collection<EmlBlank> emlBlankCollection;

    public EmlBodyBlank() {
    }

    public EmlBodyBlank(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public String getBodyBody() {
        return bodyBody;
    }

    public void setBodyBody(String bodyBody) {
        this.bodyBody = bodyBody;
    }

    @XmlTransient
    public Collection<EmlBlank> getEmlBlankCollection() {
        return emlBlankCollection;
    }

    public void setEmlBlankCollection(Collection<EmlBlank> emlBlankCollection) {
        this.emlBlankCollection = emlBlankCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bodyId != null ? bodyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmlBodyBlank)) {
            return false;
        }
        EmlBodyBlank other = (EmlBodyBlank) object;
        if ((this.bodyId == null && other.bodyId != null) || (this.bodyId != null && !this.bodyId.equals(other.bodyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.EmlBodyBlank[ bodyId=" + bodyId + " ]";
    }
    
}
