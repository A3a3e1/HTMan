/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.service;

import java.util.List;
import name.voropaiev.dao.ClubDAO;
import name.voropaiev.dao.ClubDAOImpl;
import name.voropaiev.dao.entity.Club;

/**
 *
 * @author paulvoropaiev
 */
public class ClubServicesImpl implements ClubServices {

    ClubDAO dao = new ClubDAOImpl();
    
    @Override
    public void add(Club c) {
        dao.add(c);
    }

    @Override
    public Club edit(Club c) {
        return dao.edit(c);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Club> findAll() {
        return dao.findAll();
    }

    @Override
    public Club findById(Long id) {
        return dao.findById(id);
    }
    
}
