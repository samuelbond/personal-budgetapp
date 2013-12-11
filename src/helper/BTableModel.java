/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import components.Main;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import model.Budget;

/**
 *
 * @author samuelbond
 */
public class BTableModel extends AbstractTableModel{
private Vector<Budget> data;
private final String[] tableHeaders = {"#", "Name", "Date"};

public BTableModel(String userid)
{
    data = (Vector<Budget>) new Main().getBudgetList(userid);
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
    return 4;
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
                return ((rowIndex)+1);
            case 1:
                 return data.get(rowIndex).getBudgetName();
            case 2:
                  return sdf.format(data.get(rowIndex).getDateCreated());
           
    }
    
    return null;
}

    public Vector<Budget> getData() {
        return data;
    }

    

}
