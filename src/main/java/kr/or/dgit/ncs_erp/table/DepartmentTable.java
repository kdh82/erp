package kr.or.dgit.ncs_erp.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.service.DepartmentService;

public class DepartmentTable {
	protected JTable table;	
	public Object getSelectedObject;

	public DepartmentTable() {
		loadData();
	}

	protected void cellWith() {
		tableSetWidth(50, 80, 50);

	}

	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
	}

	public Object[][] getRowData() {
		List<Department> pub = DepartmentService.getInstance().selectDepartmentAll();
		Object[][] datas = new Object[pub.size()][];
		for(int i=0; i<datas.length;i++){
			datas[i] = pub.get(i).toArray();
		}
		return datas;
	}

	protected Object[] getColumn() {
		return new String[] {"부서번호","부서명","위치"};
	}

	public Department getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1){
			return null;
		}

		String dCode = (String) table.getValueAt(selectedIdx, 0);
		String dName = (String) table.getValueAt(selectedIdx, 1);
		int floor = (int) table.getValueAt(selectedIdx, 2);
		return null;

		//return new PublisherInfo(pCode, publisher, pName, pTel, Integer.parseInt(pZipCode), pAddress);
		
	}
	public boolean loadData() {
		Object[][] rowData= getRowData();
		
		table.setModel(new DefaultTableModel(rowData, getColumn()) {
		
			@Override
			public boolean isCellEditable(int row, int column) {
				// Cell 항목 더블클릭해도 수정되지 않게함
				return false;
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// cell 두개이상 선택 불가. 한개만 선택가능
		CellAlign();
		cellWith();
		return true;
	}
	protected void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
}
