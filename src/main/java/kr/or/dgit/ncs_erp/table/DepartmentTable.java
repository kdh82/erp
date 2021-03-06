package kr.or.dgit.ncs_erp.table;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class DepartmentTable extends JPanel {
	private JTable table;
	private JPanel pTable;

	public DepartmentTable() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pTable = new JPanel();
		add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
public void loadData(){
		table.setModel(new DefaultTableModel(getRowData(), getColumnData()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CellAlign();
		CellWidth();
	}	
public Object[][] getRowData() {
	// TODO Auto-generated method stub
	return null;
}

public Object[] getColumnData() {
	return new String[] {"번호", "부서명", "위치"};
}

public void CellAlign() {
	tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
}

public void CellWidth() {
	tableSetWidth(50, 80, 50);	
}

public void tableCellAlignment(int align, int...idx){
	DefaultTableCellRenderer dCr = new DefaultTableCellRenderer();
	dCr.setHorizontalAlignment(align);
	
	TableColumnModel tc = table.getColumnModel();		
	for(int i=0; i<idx.length; i++){
		tc.getColumn(idx[i]).setCellRenderer(dCr);
	}
}

public void tableSetWidth(int...width){
	TableColumnModel tc = table.getColumnModel();
	
	for(int i=0; i<width.length; i++){
		tc.getColumn(i).setPreferredWidth(width[i]); 
	}		
}
}
