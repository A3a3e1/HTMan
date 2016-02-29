/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.service;

import java.util.List;
import name.voropaiev.dao.entity.Club;

/**
 *
 * @author paulvoropaiev
 */
public interface ClubServices {
    
    public void add(Club c);
    
    public Club edit(Club c);
    
    public void delete(Long id);
    
    public List<Club> findAll();
    
    public Club findById(Long id);
    
}
