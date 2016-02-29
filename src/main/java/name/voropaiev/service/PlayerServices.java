/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.service;

import java.util.List;
import name.voropaiev.dao.entity.Player;

/**
 *
 * @author paulvoropaiev
 */
public interface PlayerServices {
    
    public void add(Player c);
    
    public Player edit(Player c);
    
    public void delete(Long id);
    
    public List<Player> findAll();
    
    public Player findById(Long id);
    
}
