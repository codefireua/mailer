/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.mailer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP-Davydoff
 */
@Entity
@Table(name = "eml_blank", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmlBlank.findAll", query = "SELECT e FROM EmlBlank e"),
    @NamedQuery(name = "EmlBlank.findByEmlBlankId", query = "SELECT e FROM EmlBlank e WHERE e.emlBlankId = :emlBlankId"),
    @NamedQuery(name = "EmlBlank.findByBlankName", query = "SELECT e FROM EmlBlank e WHERE e.blankName = :blankName")})
public class EmlBlank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "eml_blank_id", nullable = false)
    private Integer emlBlankId;
    @Size(max = 255)
    @Column(name = "blank_name", length = 255)
    private String blankName;
    @JoinColumn(name = "blank_body", referencedColumnName = "body_id")
    @ManyToOne
    private EmlBodyBlank blankBody;
    @JoinColumn(name = "blank_header", referencedColumnName = "header_id")
    @ManyToOne
    private EmlHeaderBlank blankHeader;

    public EmlBlank() {
    }

    public EmlBlank(Integer emlBlankId) {
        this.emlBlankId = emlBlankId;
    }

    public Integer getEmlBlankId() {
        return emlBlankId;
    }

    public void setEmlBlankId(Integer emlBlankId) {
        this.emlBlankId = emlBlankId;
    }

    public String getBlankName() {
        return blankName;
    }

    public void setBlankName(String blankName) {
        this.blankName = blankName;
    }

    public EmlBodyBlank getBlankBody() {
        return blankBody;
    }

    public void setBlankBody(EmlBodyBlank blankBody) {
        this.blankBody = blankBody;
    }

    public EmlHeaderBlank getBlankHeader() {
        return blankHeader;
    }

    public void setBlankHeader(EmlHeaderBlank blankHeader) {
        this.blankHeader = blankHeader;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emlBlankId != null ? emlBlankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmlBlank)) {
            return false;
        }
        EmlBlank other = (EmlBlank) object;
        if ((this.emlBlankId == null && other.emlBlankId != null) || (this.emlBlankId != null && !this.emlBlankId.equals(other.emlBlankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.EmlBlank[ emlBlankId=" + emlBlankId + " ]";
    }
    
}
