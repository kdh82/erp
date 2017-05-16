package kr.or.dgit.ncs_erp.table;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.service.TitleService;

@SuppressWarnings("serial")
public class TitleTable extends JPanel {
	private JTable table;
	private JPanel pTable;
	private List<Title> titleList;

	public TitleTable() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pTable = new JPanel();
		add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
	}
	
	
	public void loadData(){
		table.setModel(new DefaultTableModel(getRowData(), getColumnData()){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}			
		});			
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);					
		CellAlign();
		CellWidth();
	}
	
public Object[][] getRowData(){
	titleList = TitleService.getInstance().selectTitleAll();
	for(Title t:titleList){
		System.out.println(t);
	}
	Object[][] datas = new Object[titleList.size()][];
	for(int i=0;i<datas.length;i++){
		datas[i]=titleList.get(i).toArray();
	}
	return datas;
}

public Object[] getColumnData() {
	return new String[] {"번호", "직책"};
}

public void CellAlign() {
	tableCellAlignment(SwingConstants.CENTER, 0, 1);
}

public void CellWidth() {
	tableSetWidth(50, 80);	
}
public Title getSelectedObject(){
	int selectedIdx = table.getSelectedRow();
	if(selectedIdx == -1){ 
		return null;
	}
	String sNo = (String) table.getValueAt(selectedIdx, 0);
	int tCode = Integer.parseInt(sNo.substring(1, sNo.length()));
	Title title = new Title();
	title.settCode(tCode);
	return TitleService.getInstance().selectTitleOne(title);
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
public JTable getTable() {
	return table;
}

}
