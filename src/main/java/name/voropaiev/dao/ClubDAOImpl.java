/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.dao;

import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import name.voropaiev.dao.entity.Club;
import name.voropaiev.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author paulvoropaiev
 */
@Transactional
public class ClubDAOImpl implements ClubDAO {

    private SessionFactory sessionFactory;
    
    Session session = HibernateUtil.openSession();
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection loadAllClubs() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Club c")
                .list();
    }
    
    @Override
    public void add(Club c) {
        
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        
    }

    @Override
    public Club edit(Club c) {
        
        session.beginTransaction();
        Club club = (Club) session.merge(c);
        session.getTransaction().commit();
        
        return club;
    }

    @Override
    public void delete(Long id) {
        
        session.beginTransaction();
        Club club = findById(id);
        session.delete(club);
        session.getTransaction().commit();
    }

    @Override
    public List<Club> findAll() {
        
        return session.getNamedQuery("Club.findAll").list();
    }

    @Override
    public Club findById(Long id) {
        
        return (Club) session.get(Club.class, id);
    }
    
}
