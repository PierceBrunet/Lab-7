package ca.sait.lab7.services;

import ca.sait.lab7.dataaccess.RoleDB;
import ca.sait.lab7.models.Role;
import java.util.List;

/**
 *
 * @author Pierce
 */
public class RoleService {
    private RoleDB roleDB = new RoleDB();

    public Role get(int i) throws Exception{
        Role role = this.roleDB.get(i);
        return role;
    }
    public List<Role> getAll() throws Exception{
            List<Role> roles = this.roleDB.getAll();
            return roles;
        }
}
