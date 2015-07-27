package com.ig.sabc;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Message;
import com.ig.sabc.entities.Service;
import com.ig.sabc.service.IAgenceServ;
import com.ig.sabc.service.IMessageServ;
import com.ig.sabc.service.IServiceServ;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DataAccessException
    {
//        System.out.println("toto es");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sabc");
//        EntityManager em = emf.createEntityManager();
//        IAgenceDao iAgenceDao = new AgenceDaoImpl();
//        ((GenericDao) iAgenceDao).setManager(em);
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//           Agence agence= new Agence();
//           agence.setRegion("NORD");
//          iAgenceDao.create(agence);
//        tx.commit();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");
        
//        On initialise le compte du super utilisateur
        
//        ICompteServ compteServ = (ICompteServ)ctx.getBean("ICompteServ");
//        Compte compte = new Compte();
//        compte.setIdentifiant("admin");
//        compte.setMot_passe("admin");
//        compte.setRole(Role.ADMIN);
//        compteServ.create(compte);
        
//        IMessageServ messageServ = (IMessageServ)ctx.getBean("IMessageServ");
//        Message message = new Message();
//        message.setDate_debut(Calendar.getInstance());
//        message.setMessage("bonjour root, ceci est un message a cause du premier deployement de notre application, bien vouloir le supprimer");
//        message.setStatus(Boolean.TRUE);
//        messageServ.create(message);
//        
//        IAgenceServ agenceServ = (IAgenceServ)ctx.getBean("IAgenceServ");
//        
//        int c = agenceServ.PersonnefindByagence(1L);
        
        
          IServiceServ serviceServ = (IServiceServ)ctx.getBean("IServiceServ");
          List<Service> services = serviceServ.findAllbyAgence(32768L);
          for (Service service : services) {
              System.out.println(service);
        }

//        
//        System.out.println(c);
       
//        int c = agenceServ.findByagence(1L);
//        System.out.println(c);
        
//          Calendar calendar = Calendar.getInstance();
//         // calendar.add(Calendar.DATE,1);
//          
//          SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//          
//          System.out.println(format.format(calendar.getTime()));
    }
}
