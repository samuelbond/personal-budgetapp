/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bond
 */
public class Model {
    
    private static final String PERSISTENCE_UNIT_NAME = "BudgetAppPU";
    private static EntityManagerFactory factory;
    private  EntityManager em = null;
    
    public Model() {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
     em = factory.createEntityManager();
    }
    
    
    public boolean insertNewUser(Users usr)
    {
        try
        {
           em.getTransaction().begin();
           em.persist(usr);
           em.getTransaction().commit();
    
        }catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    
    
    public boolean updateUser(Users us)
    {
     try
        {
           em.getTransaction().begin();
           em.merge(us);
           em.getTransaction().commit();
    
        }catch(Exception ex)
        {
            return false;
        }
        return true;
    }   
    
    
    public Users getUser(String userid)
    {
        return em.find(Users.class, userid);
    }
    
    
    public Users getUserLogin(String username, String pass)
    {
        Users usr;
        try
        {
         usr = em.createNamedQuery("Users.findByuserandpass", Users.class)
                .setParameter("username", username).setParameter("password", pass).getSingleResult();
        }catch(Exception ex){
            return null;
        }
        return usr;
    }
    
    
    public List<Users> getAllUsers()
    {
        return em.createQuery("SELECT u FROM Users u").getResultList();
    }
    
    
    public boolean insertNewBudget(Budget bdg)
    {
        try
        {
           em.getTransaction().begin();
           em.persist(bdg);
           em.getTransaction().commit();
        }catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    
    
    public boolean insertNewBudgetTrx(BudgetTransaction btrx)
    {
        try
        {
           em.getTransaction().begin();
           em.persist(btrx);
           em.getTransaction().commit();
        }catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    
    public boolean insertNewTransactionType(TransactionType trtype)
    {
        try
        {
           em.getTransaction().begin();
           em.persist(trtype);
           em.getTransaction().commit();
        }catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    
    
   public List<Budget> getUserBudget(Users user)
   {
       return em.createNamedQuery("Budget.findByBudgetUser", Budget.class).setParameter("userId", user).getResultList();
   }
   
   public List<BudgetTransaction> getTransactions(Budget bg)
   {
       return em.createNamedQuery("BudgetTransaction.findBybudgetId", 
               BudgetTransaction.class).setParameter("budgetId", bg).getResultList();
   }
   
   public void runSomeAlter()
   {
       try
       {
       em.createNativeQuery("ALTER TABLE BUDGET_TRANSACTION ADD COLUMN TRX_DATE DATE "
               + "CONSTRAINT NEW_CONSTRAINT CHECK (TRX_DATE IS NOT NULL)").executeUpdate();
       }catch(Exception ex){
          ex.printStackTrace();
       }
   }
    
}
