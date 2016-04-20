/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.dal.interfaces;

import d.pochernin.dal.objects.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author d.pochernin
 */
public interface IDAO_UserAndAccessGroups {

    List<User> getAllUsers();
    User getUserById(int userId);
    List<User> getUserByName(String name);
    User getUserByEmail(String email);
    Boolean addUser(String userEmail, String userPwd, String userName);
    User editUserById(User user, int userId);
    Boolean deleteUser (int userId);
    List<String> getAccessGroups();
    Map<String, Integer> getUserRights(int userId);
    Boolean setUserRights (Map<String, Integer> rights, int userId);

}
