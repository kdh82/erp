package kr.or.dgit.ncs_erp.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.ncs_erp.panel.EmployeePanel;
import kr.or.dgit.ncs_erp.table.TitleTable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewEmployee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static final ViewEmployee instance = new ViewEmployee();
	
	public static ViewEmployee getInstance() {
		return instance;
	}
	
	public ViewEmployee() {
		setTitle("사원 관리");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 300, 575, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		EmployeePanel panel = new EmployeePanel();
		panel.setBorder(new EmptyBorder(0, 150, 0, 150));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnSave = new JButton("추가");
		panel_2.add(btnSave);
		
		JButton btnCancel = new JButton("취소");
		panel_2.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
