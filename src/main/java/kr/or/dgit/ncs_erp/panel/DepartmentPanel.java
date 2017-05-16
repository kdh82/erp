package kr.or.dgit.ncs_erp.panel;

import javax.swing.JPanel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.framework.TextFieldPanel;

import java.awt.GridLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class DepartmentPanel extends JPanel {

	private TextFieldPanel pDeptNo;
	private TextFieldPanel pDeptName;
	private TextFieldPanel pFloor;

	public DepartmentPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));
		
		pDeptNo = new TextFieldPanel();
		panel.add(pDeptNo);
		pDeptNo.setTitle(" 번    호 ");
		pDeptNo.getTf().setEditable(false);
		pDeptNo.setLayout(new BoxLayout(pDeptNo, BoxLayout.X_AXIS));
		
		pDeptName = new TextFieldPanel();
		panel.add(pDeptName);
		pDeptName.setTitle(" 부서명 ");
		pDeptName.setLayout(new BoxLayout(pDeptName, BoxLayout.X_AXIS));
		
		pFloor = new TextFieldPanel();
		panel.add(pFloor);
		pFloor.setTitle(" 위   치  ");
		pFloor.setLayout(new BoxLayout(pFloor, BoxLayout.X_AXIS));

	}

	public void setObject(Department dept) {
		
		
	}

}
