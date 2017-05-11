package kr.or.dgit.ncs_erp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_erp.ui.ViewDepartment;
import kr.or.dgit.ncs_erp.ui.ViewEmployee;
import kr.or.dgit.ncs_erp.ui.ViewTitle;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMember;
	private JButton btnDept;
	private JButton btnPosition;

	public ERP_Application() {
		setTitle("대구아이티ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 463, 111);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		btnMember = new JButton("사원관리");
		btnMember.addActionListener(this);
		contentPane.add(btnMember);
		
		btnDept = new JButton("부서관리");
		btnDept.addActionListener(this);
		contentPane.add(btnDept);
		
		btnPosition = new JButton("직책관리");
		btnPosition.addActionListener(this);
		contentPane.add(btnPosition);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPosition) {
			actionPerformedBtnPosition(arg0);
		}
		if (arg0.getSource() == btnDept) {
			actionPerformedBtnDept(arg0);
		}
		if (arg0.getSource() == btnMember) {
			actionPerformedBtnMember(arg0);
		}
	}
	protected void actionPerformedBtnMember(ActionEvent arg0) {
		ViewEmployee.getInstance().setVisible(true);
	}
	protected void actionPerformedBtnDept(ActionEvent arg0) {
		ViewDepartment.getInstance().setVisible(true);
	}
	protected void actionPerformedBtnPosition(ActionEvent arg0) {
		ViewTitle.getInstance().setVisible(true);
	}
}
