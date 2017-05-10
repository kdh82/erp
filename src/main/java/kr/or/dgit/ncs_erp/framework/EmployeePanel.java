package kr.or.dgit.ncs_erp.framework;

import javax.swing.JPanel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EmployeePanel extends JPanel {

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private ComboBoxPanel<Title> pTitle;
	private SpinnerPanel pSalary;
	private RadioBtnPanel pGender;
	private ComboBoxPanel<Department> pDept;
	private TextFieldFormatPanel pJoinDate;
	private JPanel panel_1;
	private JButton btnSave;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public EmployeePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(8, 0, 0, 5));
		
		pNo = new TextFieldPanel();
		panel.add(pNo);
		pNo.setTitle(" 번    호 ");
		pNo.setLayout(new BoxLayout(pNo, BoxLayout.X_AXIS));
		
		pName = new TextFieldPanel();
		panel.add(pName);
		pName.setTitle(" 사원명 ");
		pName.setLayout(new BoxLayout(pName, BoxLayout.X_AXIS));
		
		pTitle = new ComboBoxPanel<>();
		panel.add(pTitle);
		pTitle.setTitle(" 직    책 ");
		pTitle.setLayout(new BoxLayout(pTitle, BoxLayout.X_AXIS));
		
		pSalary = new SpinnerPanel();
		panel.add(pSalary);
		pSalary.setTitle(" 급    여 ");
		pSalary.setLayout(new BoxLayout(pSalary, BoxLayout.X_AXIS));
		
		pGender = new RadioBtnPanel("남", "여");
		panel.add(pGender);
		pGender.setTitle(" 성    별 ");
		pGender.setLayout(new BoxLayout(pGender, BoxLayout.X_AXIS));
		
		pDept = new ComboBoxPanel<>();
		panel.add(pDept);
		pDept.setTitle(" 부    서 ");
		pDept.setLayout(new BoxLayout(pDept, BoxLayout.X_AXIS));
		
		pJoinDate = new TextFieldFormatPanel((String) null, '0');
		panel.add(pJoinDate);
		pJoinDate.setTitle(" 입사일 ");
		pJoinDate.setLayout(new BoxLayout(pJoinDate, BoxLayout.X_AXIS));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnSave = new JButton("추 가");
		panel_1.add(btnSave);
		
		btnCancel = new JButton("취 소");
		panel_1.add(btnCancel);

	}

}
