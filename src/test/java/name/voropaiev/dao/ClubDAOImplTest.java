/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.dao;

import java.util.List;
import javax.transaction.UserTransaction;
import name.voropaiev.dao.entity.Club;
import name.voropaiev.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author paulvoropaiev
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) - annotation of junit to run test methods in order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClubDAOImplTest {
    
    Session session;
    
    public ClubDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        session = HibernateUtil.openSession();
    }
    
    @After
    public void tearDown() {
        session.close();
    }

    /**
     * Test of add method, of class ClubDAOImpl.
     */
    @Test
    public void testAdd() {
        
        Club dummyClub = new Club();
        dummyClub.setClubname("DUMMY");
        dummyClub.setTeamid(666666);
        
        session.beginTransaction();
        session.save(dummyClub);
        
        Club clubFromDB = (Club) session.get(Club.class, 666666);
        
        assertEquals(clubFromDB.getClubname(), dummyClub.getClubname());
       
//        session.getTransaction().rollback();
//        Transaction is not commited to avoid entry being written into DB
        session.getTransaction().commit();
        
        
    }

    /**
     * Test of edit method, of class ClubDAOImpl.
     */
    @Test
    public void testEdit() {
        
        Club dummyEditedClub = new Club();
        dummyEditedClub.setClubname("DUMMY_EDITED");
        dummyEditedClub.setTeamid(666666);
        
        session.beginTransaction();
        
        Club clubFromDB = (Club) session.merge(dummyEditedClub);
        assertEquals(dummyEditedClub.getClubname(), clubFromDB.getClubname());
        
        session.getTransaction().commit();
        
    }

    /**
     * Test of delete method, of class ClubDAOImpl.
     */
    @Test
    public void testOfDelete() {
        
        session.beginTransaction();
        Club club = (Club) session.get(Club.class, 666666);
        session.delete(club);
        session.getTransaction().commit();
        
        session.beginTransaction();
        List<Club> allClubs = session.createQuery("SELECT c FROM Club c").list();
        session.getTransaction().commit();
        
        assertFalse(allClubs.contains(club));
        
    }


    
}
