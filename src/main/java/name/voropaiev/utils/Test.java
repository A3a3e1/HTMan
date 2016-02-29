/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.voropaiev.utils;

import java.util.Collection;
import java.util.List;
import name.voropaiev.dao.ClubDAO;
import name.voropaiev.dao.ClubDAOImpl;
import name.voropaiev.dao.entity.Club;
import name.voropaiev.dao.entity.Player;
import org.hibernate.Session;
import name.voropaiev.dao.PlayerDAOImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author paulvoropaiev
 */
public class Test {
    
    static Session session = HibernateUtil.openSession();
    
    public static Logger log = Logger.getLogger(Test.class);
    
    public static void main(String[] args) {


//        PlayerDAOImpl daoLuckyLion = new PlayerDAOImpl();
//        
//        Player player1 = new Player();
//        Player player2 = new Player();
//        Player player3 = new Player();
//        
//        Club clubLuckyLion = new Club();
//        clubLuckyLion.setTeamid(527626);
//        
//        player1.setPlayerid(412601434);
//        player1.setPlayername("Taras Beletskiy");
//        player1.setTeamid(clubLuckyLion);
//        
//        player2.setPlayerid(412660009);
//        player2.setPlayername("Vitaliy Moravskiy");
//        player2.setTeamid(clubLuckyLion);
//        
//        player3.setPlayerid(414791205);
//        player3.setPlayername("Sergiy Lysenko");
//        player3.setTeamid(clubLuckyLion);
//        
//        daoLuckyLion.add(player1);
//        daoLuckyLion.add(player2);
//        daoLuckyLion.add(player3);
        
        
//        ----------------        
//        ClubDAO dao = new ClubDAOImpl();
//        
//        Club club = new Club();
//        club.setTeamid(527626);
//        club.setClubname("Lucky_St@r");
//        dao.add(club);
        
//        ----------------
//        List<Player> allPlayers = session.getNamedQuery("Player.findAll").list();

        
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernateSessionBeanSpringXMLConfig.xml");
        
        PlayerDAOImpl playerDaoImpl = (PlayerDAOImpl) context.getBean("myPlayerDao");
        Collection<Player> allPlayersSpring = playerDaoImpl.loadAllPlayers();
        
        ClubDAOImpl clubDaoImpl = (ClubDAOImpl) context.getBean("myClubDao");
        Collection<Club> allClubsSpring = clubDaoImpl.loadAllClubs();
        
        System.out.println("============CLUBS===========");
        for (Club club : allClubsSpring) {
            System.out.println("id: " + club.getTeamid() + ". name: " + club.getClubname());
        }
        
        System.out.println("==========PLAYERS===========");
        for (Player player : allPlayersSpring) {
            System.out.println("id: " + player.getPlayerid().toString() + ". name: " 
                    + player.getPlayername() + ". team: " + player.getTeamid().getClubname());
        }
        
//        List<Club> allClubs = session.createQuery("SELECT c FROM Club c").list();
//        
//        for (Club club : allClubs) {
//            System.out.println("id: " + club.getTeamid() + ". name: " + club.getClubname());
//        }
//        
//        System.out.println("=======================");
//        
//        List<Player> allPlayers = session.createQuery("SELECT p FROM Player p").list();
//        
//        for (Player player : allPlayers) {
//            System.out.println("id: " + player.getPlayerid().toString() + ". name: " 
//                    + player.getPlayername() + ". team: " + player.getTeamid().getClubname());
//        }
//        
//        log.info("INFO msg");
        
        session.close();
        
    }
    
}
