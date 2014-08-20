package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.BudgetTransaction;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-13T12:17:18")
@StaticMetamodel(TransactionType.class)
public class TransactionType_ { 

    public static volatile SingularAttribute<TransactionType, String> typeName;
    public static volatile CollectionAttribute<TransactionType, BudgetTransaction> budgetTransactionCollection;
    public static volatile SingularAttribute<TransactionType, Integer> typeId;

}