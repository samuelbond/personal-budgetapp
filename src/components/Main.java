/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import helper.HashString;
import helper.RandomGenerator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Budget;
import model.BudgetTransaction;
import model.Model;
import model.TransactionType;
import model.Users;
import views.NewTransaction;


/**
 *
 * @author samuelbond
 */
public class Main {
    
    private Model model;
    private Users usr;
    private RandomGenerator rd;

    public Main() {
       rd = new RandomGenerator(5);
       model = new Model();
    }
    
    
    
    public boolean registerNewUser(String fname, String username, String password)
    {
        HashString hs = new HashString(password);
        
        usr = new Users(rd.generate(), fname, username, hs.HashPassword());
        if(model.insertNewUser(usr))
        {
            return true;
        }
        return false;
    }
    
    public boolean loginUser(String username, String password)
    {
        HashString hs = new HashString(password);
        
        if((usr = model.getUserLogin(username, hs.HashPassword())) == null){
            return false;
        }        
        return true;
    }
    
    
    public Users getUserDetails(String user)
    {
        return model.getUser(user);
    }
    
    
    public void showAllUsers()
    {
        List<Users> usrList = model.getAllUsers();
        
        for(Users usrs: usrList)
        {
            System.out.println("Fullname: "+usrs.getFullname()+" Username: "+usrs.getUsername());
        }
    }
    
    public boolean createNewBudget(String name, Date budgetDate, String userid)
    {
        Budget bg = new Budget(rd.generate(), name, budgetDate, budgetDate);
        bg.setUserId(new Users(userid));
        if(model.insertNewBudget(bg))
        {
            return true;
        }
        
        return false;
    }

    public Users getUsr() {
        return usr;
    }
    
   
    public List<Budget> getBudgetList(String userid)
    {
       return model.getUserBudget(new Users(userid));
    }
    
    public List<BudgetTransaction> getTransactionList(String budgetId)
    {
        return model.getTransactions(new Budget(budgetId));
    }
    
    
    public boolean createNewTransaction(String budgetid, String name, String desc, int amount, int type)
    {
        BudgetTransaction bt = new BudgetTransaction(rd.generate(), name, desc, amount, new Date());
        bt.setBudgetId(new Budget(budgetid));
        bt.setTrxType(new TransactionType(type));
        
        if(model.insertNewBudgetTrx(bt))
        {
            return true;
        }
        
        return false;
    }
    

    public void doSomething()
    {
       Connection con = null;
    
     
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:budgetapp;create=true", "samuel", "samuel");

        }catch( ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
   
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM budgetapp.TRANSACTION_TYPE");
            while(rs.next()){
                System.out.println(rs.getString("type_id"));  
            }
            System.out.println("Insrt done");  
        }catch(Exception exs){
         exs.printStackTrace();
        }
    
    }
    
    
    public int trackBudget(String budgetId)
    {
        List<BudgetTransaction> btList = this.getTransactionList(budgetId);
        int sum = 0;
        for(BudgetTransaction bg: btList)
        {
            if(bg.getTrxType().getTypeId() == 1)
            {
                sum = sum + bg.getTrxAmount();
            }
            else
            {
                sum = sum - bg.getTrxAmount();
            }
        }
        return sum;
    }
    
    
    public int trackBudgetForAGivenPeriod(String budgetid, Date start, Date stop)
    {
        List<BudgetTransaction> btList = this.getTransactionList(budgetid);
       
        int sum = 0;
        for(BudgetTransaction bg: btList)
        {
            int equal1 = start.compareTo(bg.getTrxDate());
            int equal2 = bg.getTrxDate().compareTo(stop);
            
            if(equal1 <= 0 && equal2 <= 0)
            {
            if(bg.getTrxType().getTypeId() == 1)
            {
                sum = sum + bg.getTrxAmount();
            }
            else
            {
                sum = sum - bg.getTrxAmount();
            }
            }
        }
        return sum;
    }
    
    
    public boolean updateUserAccount(String fullname, String username, String password, String userid)
    {
        usr = model.getUser(userid);
        if(password != null)
        {
            HashString hs = new HashString(password);
            usr.setPassword(hs.HashPassword());
        }
        usr.setFullname(fullname);
        usr.setUsername(username);
        
        if(model.updateUser(usr)){
            return true;
        }
        
        return false;
    }
   
    
}
