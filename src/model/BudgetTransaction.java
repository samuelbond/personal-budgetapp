/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bond
 */
@Entity
@Table(name = "BUDGET_TRANSACTION",schema = "budgetapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetTransaction.findAll", query = "SELECT b FROM BudgetTransaction b"),
    @NamedQuery(name = "BudgetTransaction.findByTrxId", query = "SELECT b FROM BudgetTransaction b WHERE b.trxId = :trxId"),
    @NamedQuery(name = "BudgetTransaction.findBybudgetId", query = "SELECT b FROM BudgetTransaction b WHERE b.budgetId = :budgetId"),
    @NamedQuery(name = "BudgetTransaction.findByTrxName", query = "SELECT b FROM BudgetTransaction b WHERE b.trxName = :trxName"),
    @NamedQuery(name = "BudgetTransaction.findByTrxDesc", query = "SELECT b FROM BudgetTransaction b WHERE b.trxDesc = :trxDesc"),
    @NamedQuery(name = "BudgetTransaction.findByTrxAmount", query = "SELECT b FROM BudgetTransaction b WHERE b.trxAmount = :trxAmount")})
public class BudgetTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRX_ID")
    private String trxId;
    @Basic(optional = false)
    @Column(name = "TRX_NAME")
    private String trxName;
    @Basic(optional = false)
    @Column(name = "TRX_DESC")
    private String trxDesc;
    @Basic(optional = false)
    @Column(name = "TRX_AMOUNT")
    private int trxAmount;
    @JoinColumn(name = "TRX_TYPE", referencedColumnName = "TYPE_ID")
    @ManyToOne(optional = false)
    private TransactionType trxType;
    @JoinColumn(name = "BUDGET_ID", referencedColumnName = "BUDGET_ID")
    @ManyToOne(optional = false)
    private Budget budgetId;

    public BudgetTransaction() {
    }

    public BudgetTransaction(String trxId) {
        this.trxId = trxId;
    }

    public BudgetTransaction(String trxId, String trxName, String trxDesc, int trxAmount) {
        this.trxId = trxId;
        this.trxName = trxName;
        this.trxDesc = trxDesc;
        this.trxAmount = trxAmount;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getTrxName() {
        return trxName;
    }

    public void setTrxName(String trxName) {
        this.trxName = trxName;
    }

    public String getTrxDesc() {
        return trxDesc;
    }

    public void setTrxDesc(String trxDesc) {
        this.trxDesc = trxDesc;
    }

    public int getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(int trxAmount) {
        this.trxAmount = trxAmount;
    }

    public TransactionType getTrxType() {
        return trxType;
    }

    public void setTrxType(TransactionType trxType) {
        this.trxType = trxType;
    }

    public Budget getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Budget budgetId) {
        this.budgetId = budgetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trxId != null ? trxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetTransaction)) {
            return false;
        }
        BudgetTransaction other = (BudgetTransaction) object;
        if ((this.trxId == null && other.trxId != null) || (this.trxId != null && !this.trxId.equals(other.trxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BudgetTransaction[ trxId=" + trxId + " ]";
    }
    
}
