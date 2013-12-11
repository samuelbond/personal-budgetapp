/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bond
 */
@Entity
@Table(name = "BUDGET",schema = "budgetapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budget.findAll", query = "SELECT b FROM Budget b"),
    @NamedQuery(name = "Budget.findByBudgetId", query = "SELECT b FROM Budget b WHERE b.budgetId = :budgetId"),
    @NamedQuery(name = "Budget.findByBudgetName", query = "SELECT b FROM Budget b WHERE b.budgetName = :budgetName"),
    @NamedQuery(name = "Budget.findByBudgetUser", query = "SELECT b FROM Budget b WHERE b.userId = :userId"),
    @NamedQuery(name = "Budget.findByDateCreated", query = "SELECT b FROM Budget b WHERE b.dateCreated = :dateCreated"),
    @NamedQuery(name = "Budget.findByLastModified", query = "SELECT b FROM Budget b WHERE b.lastModified = :lastModified")})
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BUDGET_ID")
    private String budgetId;
    @Basic(optional = false)
    @Column(name = "BUDGET_NAME")
    private String budgetName;
    @Basic(optional = false)
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "LAST_MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetId")
    private Collection<BudgetTransaction> budgetTransactionCollection;

    public Budget() {
    }

    public Budget(String budgetId) {
        this.budgetId = budgetId;
    }

    public Budget(String budgetId, String budgetName, Date dateCreated, Date lastModified) {
        this.budgetId = budgetId;
        this.budgetName = budgetName;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<BudgetTransaction> getBudgetTransactionCollection() {
        return budgetTransactionCollection;
    }

    public void setBudgetTransactionCollection(Collection<BudgetTransaction> budgetTransactionCollection) {
        this.budgetTransactionCollection = budgetTransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetId != null ? budgetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.budgetId == null && other.budgetId != null) || (this.budgetId != null && !this.budgetId.equals(other.budgetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Budget[ budgetId=" + budgetId + " ]";
    }
    
}
