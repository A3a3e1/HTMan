/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.presentation;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import name.voropaiev.dao.entity.Club;
import name.voropaiev.dao.entity.Player;
import name.voropaiev.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author paulvoropaiev
 */

@ManagedBean(name="clubbean")
@SessionScoped
public class ClubBean {
    
    public Logger log = Logger.getLogger(ClubBean.class);
    static Session session = HibernateUtil.openSession();
    
    private String clubName;
    private int teamId;
    private List<Player> allPlayers;
    private List<Club> allClubs;

    public List<Club> getAllClubs() {
        
        return allClubs;
    }

    public void setAllClubs(List<Club> allClubs) {
        this.allClubs = allClubs;
    }

    public ClubBean() {
        
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }
    
}
