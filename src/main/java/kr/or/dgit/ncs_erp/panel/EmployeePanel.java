package kr.or.dgit.ncs_erp.panel;

import javax.swing.JPanel;

import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.framework.ComboBoxPanel;
import kr.or.dgit.ncs_erp.framework.RadioBtnPanel;
import kr.or.dgit.ncs_erp.framework.SpinnerPanel;
import kr.or.dgit.ncs_erp.framework.TextFieldFormatPanel;
import kr.or.dgit.ncs_erp.framework.TextFieldPanel;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmployeePanel extends JPanel {

	private TextFieldPanel pNo;
	private TextFieldPanel pName;
	private ComboBoxPanel<Title> pTitle;
	private SpinnerPanel pSalary;
	private RadioBtnPanel pGender;
	private ComboBoxPanel<Department> pDept;
	private TextFieldFormatPanel pJoinDate;

	public EmployeePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 0, 0, 5));
		
		pNo = new TextFieldPanel();
		panel.add(pNo);
		pNo.setTitle(" 번    호 ");
		pNo.getTf().setEditable(false);
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
		pGender.setSelectedItem("남");
		pGender.setLayout(new BoxLayout(pGender, BoxLayout.X_AXIS));
		
		pDept = new ComboBoxPanel<>();
		panel.add(pDept);
		pDept.setTitle(" 부    서 ");
		pDept.setLayout(new BoxLayout(pDept, BoxLayout.X_AXIS));
		
		pJoinDate = new TextFieldFormatPanel((String) null, '0');
		panel.add(pJoinDate);
		pJoinDate.setTitle(" 입사일 ");
		pJoinDate.setLayout(new BoxLayout(pJoinDate, BoxLayout.X_AXIS));

	}
/*	protected void initField() {
		String pNo = String.format("E%ty%03d", new Date(), tablePanel.getDataModel().getLastNum()+1);
		EmployeePanel.getNoPanel().setTfValue(pNo);		
	}*/
	private void setObject(){
	}
	private void clear(){
		pNo.setTfValue("");
		pName.setTfValue("");
		pTitle.setSelectedIndex(0);
		pSalary.setSpinValue(new Integer(1500000));
		pGender.setSelectedItem("남");
		pDept.setSelectedIndex(0);
		pJoinDate.setTfValue("");
	}
}
