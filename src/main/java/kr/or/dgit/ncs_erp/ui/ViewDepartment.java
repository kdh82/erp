package kr.or.dgit.ncs_erp.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;

import kr.or.dgit.ncs_erp.panel.DepartmentPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ViewDepartment extends JFrame {

	private JPanel contentPane;
	private DepartmentPanel pDept;
	private JScrollPane scrollPane;
	private JTable table;
	private static final ViewDepartment instance = new ViewDepartment();
	private JPanel pBtnDept;
	private JButton btnSave;
	private JButton btnCancel;
	


	public static ViewDepartment getInstance() {
		return instance;
	}

	public ViewDepartment() {
		setTitle("부서 관리");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(900, 300, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pDept = new DepartmentPanel();
		pDept.setBorder(new EmptyBorder(0, 100, 5, 100));
		contentPane.add(pDept);
		pDept.setLayout(new GridLayout(1, 0, 0, 0));
		
		pBtnDept = new JPanel();
		FlowLayout fl_pBtnDept = (FlowLayout) pBtnDept.getLayout();
		fl_pBtnDept.setHgap(10);
		contentPane.add(pBtnDept);
		
		btnSave = new JButton("추가");
		pBtnDept.add(btnSave);
		
		btnCancel = new JButton("취소");
		pBtnDept.add(btnCancel);
	
		JPanel pTDept = new JPanel();
		pTDept.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(pTDept);
		pTDept.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pTDept.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		table.setModel(new DefaultTableModel(new Object[][]{{"김두환","1층"}}, new Object[]{"이름","위치"}));
		
}
}

