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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d.pochernin
 */
@Entity
@Table(name = "eml_blank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmlBlank.findAll", query = "SELECT e FROM EmlBlank e"),
    @NamedQuery(name = "EmlBlank.findByEmlBlankId", query = "SELECT e FROM EmlBlank e WHERE e.emlBlankId = :emlBlankId"),
    @NamedQuery(name = "EmlBlank.findByBlankName", query = "SELECT e FROM EmlBlank e WHERE e.blankName = :blankName")})
public class EmlBlank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eml_blank_id")
    private Integer emlBlankId;
    @Size(max = 255)
    @Column(name = "blank_name")
    private String blankName;
    @Lob
    @Size(max = 65535)
    @Column(name = "blank_html")
    private String blankHtml;

    public EmlBlank() {
    }

    public EmlBlank(String blankName, String blankHtml) {
        this.blankName = blankName;
        this.blankHtml = blankHtml;
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

    public String getBlankHtml() {
        return blankHtml;
    }

    public void setBlankHtml(String blankHtml) {
        this.blankHtml = blankHtml;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.emlBlankId);
        hash = 71 * hash + Objects.hashCode(this.blankName);
        hash = 71 * hash + Objects.hashCode(this.blankHtml);
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
        final EmlBlank other = (EmlBlank) obj;
        if (!Objects.equals(this.blankName, other.blankName)) {
            return false;
        }
        if (!Objects.equals(this.blankHtml, other.blankHtml)) {
            return false;
        }
        if (!Objects.equals(this.emlBlankId, other.emlBlankId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmlBlank{" + "emlBlankId=" + emlBlankId + ", blankName=" + blankName + ", blankHtml=" + blankHtml + '}';
    }
      
}
