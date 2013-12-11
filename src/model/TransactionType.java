/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bond
 */
@Entity
@Table(name = "TRANSACTION_TYPE",schema = "budgetapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t"),
    @NamedQuery(name = "TransactionType.findByTypeId", query = "SELECT t FROM TransactionType t WHERE t.typeId = :typeId"),
    @NamedQuery(name = "TransactionType.findByTypeName", query = "SELECT t FROM TransactionType t WHERE t.typeName = :typeName")})
public class TransactionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TYPE_ID")
    private Integer typeId;
    @Basic(optional = false)
    @Column(name = "TYPE_NAME")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trxType")
    private Collection<BudgetTransaction> budgetTransactionCollection;

    public TransactionType() {
    }

    public TransactionType(Integer typeId) {
        this.typeId = typeId;
    }

    public TransactionType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TransactionType[ typeId=" + typeId + " ]";
    }
    
}
