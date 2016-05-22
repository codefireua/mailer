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
@Table(name = "eml_header_blank", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmlHeaderBlank.findAll", query = "SELECT e FROM EmlHeaderBlank e"),
    @NamedQuery(name = "EmlHeaderBlank.findByHeaderId", query = "SELECT e FROM EmlHeaderBlank e WHERE e.headerId = :headerId")})
public class EmlHeaderBlank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "header_id", nullable = false)
    private Integer headerId;
    @Lob
    @Size(max = 65535)
    @Column(name = "header_body", length = 65535)
    private String headerBody;
    @OneToMany(mappedBy = "blankHeader")
    private Collection<EmlBlank> emlBlankCollection;

    public EmlHeaderBlank() {
    }

    public EmlHeaderBlank(Integer headerId) {
        this.headerId = headerId;
    }

    public Integer getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Integer headerId) {
        this.headerId = headerId;
    }

    public String getHeaderBody() {
        return headerBody;
    }

    public void setHeaderBody(String headerBody) {
        this.headerBody = headerBody;
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
        hash += (headerId != null ? headerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmlHeaderBlank)) {
            return false;
        }
        EmlHeaderBlank other = (EmlHeaderBlank) object;
        if ((this.headerId == null && other.headerId != null) || (this.headerId != null && !this.headerId.equals(other.headerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.EmlHeaderBlank[ headerId=" + headerId + " ]";
    }
    
}
