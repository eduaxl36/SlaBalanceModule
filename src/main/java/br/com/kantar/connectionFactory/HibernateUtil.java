/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.connectionFactory;

import br.com.kantar.model.variaveis.Cabo;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;







public class HibernateUtil {
         
    public EntityManager ConnectionFactoryJPA(){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BalanceJPA");
        EntityManager em =emf.createEntityManager();
        
        return em;
    
    }
    
    
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BalanceJPA");
        EntityManager em =emf.createEntityManager();
        
        em.getTransaction().begin();
        Cabo c1 = new Cabo(LocalDate.now(), 0, 0, "teste", 103);
        em.persist(c1);
        em.getTransaction().commit();
    
    
    }
    
    
}
