package com.ig.sabc;

import com.douwe.generic.dao.DataAccessException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");
        
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
//        message.setStatus(Etat.NON_LU);
//        messageServ.create(message);
//        
//        IPersonneServ personneServ =(IPersonneServ)ctx.getBean("IPersonneServ");
//        List<Personne> personne = new LinkedList<Personne>();
//        personne = personneServ.findbycompt();
//        for (Personne personne1 : personne) {
//            System.out.println(personne);
//        }
//        
//        IAgenceServ agenceServ = ( )ctx.getBean("IAgenceServ");
//        
//        int c = agenceServ.PersonnefindByagence(1L);
        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
//          IEncreServ encreServ = (IEncreServ)ctx.getBean("IEncreServ");
//          List<Encre> encres = null;
//        try {
//            encres = encreServ.findbydate(dateFormat.parse("2015-01-01"),dateFormat.parse("2015-12-31"));
//        } catch (ParseException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          for (Encre encre : encres) {
//              System.out.println(encre.getImprimante().getIdentifiant());
//        }
//        Calendar calendar= Calendar.getInstance();
//        String d1 = null;
//        String d2 = null;
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
//        d1=dateFormat1.format(calendar.getTime())+"-" +dateFormat.format(calendar.getTime())+"-01";
//        d2=dateFormat1.format(calendar.getTime())+"-" +dateFormat.format(calendar.getTime())+"-30";
//        System.out.println(d1);
//        System.out.println(d2);
//        Date date1 = null;
//        Date date2 = null;
//        try {
//            date1=dateFormat2.parse(d1);
//            date2=dateFormat2.parse(d2);
//        } catch (ParseException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //
//        List<Encre> es = new LinkedList<Encre>();
//       
//        try {
//            es=encreServ.findbytype(date1, date2, EncreType.NOIR);
//        } catch (DataAccessException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        int cmpt=0;
//        if(es!=null){
//            for (Encre e : es) {
//                cmpt= cmpt + e.getNbr_encre();
//            }
//        }
//        System.out.println("le nombre d'encre noir est " + cmpt);
//        //JE VIENS DE RECUPERER L'ENSEMEBLE DE CONSOMMATION D'ENCRE NOIR SUR UNE DATE DONNEE
//        //
//        List<Encre> es2 = new LinkedList<Encre>();
//  
//        try {
//            es2 = encreServ.findbytype(date1, date2, EncreType.COULEUR);
//        } catch (DataAccessException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        int cmpt2 = 0;
//        if(es2!=null){
//            for (Encre es21 : es2) {
//                cmpt2 = cmpt2 + es21.getNbr_encre();
//            }
//        }
//        
////        //JE VIENS DE RECUPERER L'ENSEMEBLE DE CONSOMMATION D'ENCRE COULEUR SUR UNE DATE DONNEE
//        System.out.println("le nombre d'encre couleur est " + cmpt2);
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
     sendMessage("Alerte", "j'espere que sa vas donner");
    }

    public static void sendMessage(String subject, String text) {

        // 1 -> Création de la session 
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        
        properties.put("mail.smtp.starttls.enable", "true");
        
        properties.put("mail.smtp.port", "587");
        
        //properties.put("mail.smtp.starttls.enable", "true");

         Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("sabc.truth@gmail.com","brasserie");
                    }
                });
        System.out.println("session a donnée");
        MimeMessage message = new MimeMessage(session); 

        try {

            message.setText(text);

            message.setSubject(subject);

            message.setFrom(new InternetAddress("sabc.truth@gmail.com"));
            
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("wtakoutsing@gmail.com"));

            System.out.println("ajout des destinataire du message");
        } catch (MessagingException e) {

            e.printStackTrace();
        }
        
        System.out.println("on essaye d'envoyer le message");
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect("sabc.truth@gmail.com", "brasserie");
            transport.sendMessage(message, new Address[] { new InternetAddress("wtakoutsing@gmail.com"),new InternetAddress("wtakoutsing@gmail.com") }); 
            System.out.println("le message est parti");
            
        } catch (MessagingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
