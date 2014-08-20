package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Budget;
import model.TransactionType;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-13T12:17:18")
@StaticMetamodel(BudgetTransaction.class)
public class BudgetTransaction_ { 

    public static volatile SingularAttribute<BudgetTransaction, Integer> trxAmount;
    public static volatile SingularAttribute<BudgetTransaction, Budget> budgetId;
    public static volatile SingularAttribute<BudgetTransaction, String> trxName;
    public static volatile SingularAttribute<BudgetTransaction, String> trxId;
    public static volatile SingularAttribute<BudgetTransaction, String> trxDesc;
    public static volatile SingularAttribute<BudgetTransaction, TransactionType> trxType;
    public static volatile SingularAttribute<BudgetTransaction, Date> trxDate;

}