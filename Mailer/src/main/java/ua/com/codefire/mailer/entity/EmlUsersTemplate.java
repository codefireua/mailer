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
import javax.persistence.Lob;
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
@Table(name = "eml_users_template", catalog = "mailer", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmlUsersTemplate.findAll", query = "SELECT e FROM EmlUsersTemplate e"),
    @NamedQuery(name = "EmlUsersTemplate.findByTemplateId", query = "SELECT e FROM EmlUsersTemplate e WHERE e.templateId = :templateId"),
    @NamedQuery(name = "EmlUsersTemplate.findByTemplateName", query = "SELECT e FROM EmlUsersTemplate e WHERE e.templateName = :templateName")})
public class EmlUsersTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "template_id", nullable = false)
    private Integer templateId;
    @Size(max = 255)
    @Column(name = "template_name", length = 255)
    private String templateName;
    @Lob
    @Size(max = 65535)
    @Column(name = "template_header", length = 65535)
    private String templateHeader;
    @Lob
    @Size(max = 65535)
    @Column(name = "template_body", length = 65535)
    private String templateBody;
    @JoinColumn(name = "template_owner", referencedColumnName = "user_id")
    @ManyToOne
    private Users templateOwner;

    public EmlUsersTemplate() {
    }

    public EmlUsersTemplate(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateHeader() {
        return templateHeader;
    }

    public void setTemplateHeader(String templateHeader) {
        this.templateHeader = templateHeader;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public void setTemplateBody(String templateBody) {
        this.templateBody = templateBody;
    }

    public Users getTemplateOwner() {
        return templateOwner;
    }

    public void setTemplateOwner(Users templateOwner) {
        this.templateOwner = templateOwner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (templateId != null ? templateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmlUsersTemplate)) {
            return false;
        }
        EmlUsersTemplate other = (EmlUsersTemplate) object;
        if ((this.templateId == null && other.templateId != null) || (this.templateId != null && !this.templateId.equals(other.templateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.mailer.entity.EmlUsersTemplate[ templateId=" + templateId + " ]";
    }
    
}
