package controller;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class TableRenderer extends DefaultTableCellRenderer{
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		      boolean hasFocus, int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		if(table.getValueAt(row, column).equals("Prestada")) {
			this.setBackground(Color.RED);
		}else if(column == 0) {
			this.setBackground(Color.WHITE);
		}else if(table.getValueAt(row, column).equals("")){
			this.setBackground(Color.GREEN);
		}
		return this;
	}
}
