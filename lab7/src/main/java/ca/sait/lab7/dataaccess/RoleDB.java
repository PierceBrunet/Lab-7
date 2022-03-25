/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.lab7.dataaccess;

import ca.sait.lab7.models.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Regan
 */
public class RoleDB {
    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            Query query = em.createNamedQuery("Role.findAll");
            
            return query.getResultList();
        }finally{
            em.close();
        }
    }
    public Role get(int i) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            Role role = em.find(Role.class, i);
            return role;
        }finally{
            em.close();
        }
    }
}
