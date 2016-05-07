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
 * @author d.pochernin
 */
@Entity
@Table(name = "eml_users_template")
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
    @Column(name = "template_id")
    private Integer templateId;
    @Size(max = 255)
    @Column(name = "template_name")
    private String templateName;
    @Lob
    @Size(max = 65535)
    @Column(name = "template_header")
    private String templateHeader;
    @Lob
    @Size(max = 65535)
    @Column(name = "template_body")
    private String templateBody;
    @JoinColumn(name = "template_owner", referencedColumnName = "user_id")
    @ManyToOne
    private User templateOwner;

    public EmlUsersTemplate() {
    }

    public EmlUsersTemplate(String templateName, String templateHeader, String templateBody, User templateOwner) {
        this.templateName = templateName;
        this.templateHeader = templateHeader;
        this.templateBody = templateBody;
        this.templateOwner = templateOwner;
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

    public User getTemplateOwner() {
        return templateOwner;
    }

    public void setTemplateOwner(User templateOwner) {
        this.templateOwner = templateOwner;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.templateId);
        hash = 11 * hash + Objects.hashCode(this.templateName);
        hash = 11 * hash + Objects.hashCode(this.templateHeader);
        hash = 11 * hash + Objects.hashCode(this.templateBody);
        hash = 11 * hash + Objects.hashCode(this.templateOwner);
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
        final EmlUsersTemplate other = (EmlUsersTemplate) obj;
        if (!Objects.equals(this.templateName, other.templateName)) {
            return false;
        }
        if (!Objects.equals(this.templateHeader, other.templateHeader)) {
            return false;
        }
        if (!Objects.equals(this.templateBody, other.templateBody)) {
            return false;
        }
        if (!Objects.equals(this.templateId, other.templateId)) {
            return false;
        }
        if (!Objects.equals(this.templateOwner, other.templateOwner)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmlUsersTemplate{" + "templateId=" + templateId + ", templateName=" + templateName + ", templateHeader=" + templateHeader + ", templateBody=" + templateBody + ", templateOwner=" + templateOwner + '}';
    }

}
