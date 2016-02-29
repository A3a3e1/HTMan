/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.dao;

import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import name.voropaiev.dao.entity.Player;
import name.voropaiev.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author paulvoropaiev
 */
@Transactional
public class PlayerDAOImpl implements PlayerDAO{

    
    private SessionFactory sessionFactory;

    Session session = HibernateUtil.openSession();
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection loadAllPlayers() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM Player p")
                .list();
    }
    
    @Override
    public void add(Player p) {
        
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        
    }

    @Override
    public Player edit(Player p) {
        
        session.beginTransaction();
        Player player = (Player) session.merge(p);
        session.getTransaction().commit();
        
        return player;
    }

    @Override
    public void delete(Long id) {
        
        session.beginTransaction();
        Player player = findById(id);
        session.delete(player);
        session.getTransaction().commit();
    }

    @Override
    public List<Player> findAll() {
        
        return session.getNamedQuery("Player.findAll").list();
    }

    @Override
    public Player findById(Long id) {
        
        return (Player) session.get(Player.class, id);
    }
    
}
