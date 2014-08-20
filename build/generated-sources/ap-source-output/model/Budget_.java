package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.BudgetTransaction;
import model.Users;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-13T12:17:18")
@StaticMetamodel(Budget.class)
public class Budget_ { 

    public static volatile SingularAttribute<Budget, String> budgetId;
    public static volatile SingularAttribute<Budget, String> budgetName;
    public static volatile SingularAttribute<Budget, Date> lastModified;
    public static volatile SingularAttribute<Budget, Users> userId;
    public static volatile CollectionAttribute<Budget, BudgetTransaction> budgetTransactionCollection;
    public static volatile SingularAttribute<Budget, Date> dateCreated;

}