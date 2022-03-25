package ca.sait.lab7.dataaccess;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
/**
 *
 * @author Regan
 */
public class DBUtil {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");

    public static EntityManagerFactory getEmFactory(){
        return emf;    
    }
}
