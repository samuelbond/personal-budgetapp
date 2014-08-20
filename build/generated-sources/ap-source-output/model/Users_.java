package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Budget;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-13T12:17:18")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Budget> budgetCollection;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> userId;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> fullname;

}