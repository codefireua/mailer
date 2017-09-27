/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.dal.interfaces;

import d.pochernin.dal.objects.EmlUsersTemplate;
import java.util.List;

/**
 *
 * @author d.pochernin
 */
public interface IDAO_EmlUsersTamplate {
    
    Boolean addNewTemplate (String templateName, String templateHeader, String templateBody, Integer templateOwner);
    EmlUsersTemplate getTemplateById (int templateId);
    List<EmlUsersTemplate> getTemplateByName (String templateName);
    List<EmlUsersTemplate> getAllTemplatesOfUser (int templateOwner);
    EmlUsersTemplate editTemplate (int templateId, EmlUsersTemplate newTemplate);
    
}
