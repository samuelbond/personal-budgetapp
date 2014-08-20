/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import components.Main;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import model.BudgetTransaction;

/**
 *
 * @author samuelbond
 */
public class BudgetTableModel extends AbstractTableModel{
   private Vector<BudgetTransaction> data;
private final String[] tableHeaders = {"Name", "Description", "Type", "Amount", "Date"};

public BudgetTableModel(String budgetId)
{
    data = (Vector<BudgetTransaction>) new Main().getTransactionList(budgetId);
}

@Override
public boolean isCellEditable(int rowIndex, int columnIndex)
{
    return false; // does not allowed to edit cells 
}

@Override
public int getRowCount()
{
    return data.size();
}

@Override
public int getColumnCount()
{
    return 5;
}

@Override
 public String getColumnName(int columnIndex) {
  return tableHeaders[columnIndex];
 }

@Override
public Object getValueAt(final int rowIndex, int columnIndex)
{
    javax.swing.JTextField field = null;
    javax.swing.JButton jb = null;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
    switch(columnIndex){
            case 0:
                return data.get(rowIndex).getTrxName();
            case 1:
                 return data.get(rowIndex).getTrxDesc();
            case 2:
                  return data.get(rowIndex).getTrxType().getTypeName();
            case 3:
                  return data.get(rowIndex).getTrxAmount()+"Ft";
            case 4:
                  return data.get(rowIndex).getTrxDate();
           
    }
    
    return null;
}

    public Vector<BudgetTransaction> getData() {
        return data;
    }
 
}
