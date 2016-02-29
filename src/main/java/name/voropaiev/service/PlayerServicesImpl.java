/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.service;

import java.util.List;
import name.voropaiev.dao.PlayerDAO;
import name.voropaiev.dao.PlayerDAOImpl;
import name.voropaiev.dao.entity.Player;

/**
 *
 * @author paulvoropaiev
 */
public class PlayerServicesImpl implements PlayerServices {

    PlayerDAO dao = new PlayerDAOImpl();
    
    @Override
    public void add(Player c) {
        dao.add(c);
    }

    @Override
    public Player edit(Player c) {
        return dao.edit(c);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Player> findAll() {
        return dao.findAll();
    }

    @Override
    public Player findById(Long id) {
        return dao.findById(id);
    }
    
}
