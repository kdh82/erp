package kr.or.dgit.ncs_erp.framework;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class DepartmentPanel extends JPanel {

	private TextFieldPanel pDeptNo;
	private TextFieldPanel pDeptName;
	private TextFieldPanel pFloor;

	public DepartmentPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 40, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		pDeptNo = new TextFieldPanel();
		GridBagConstraints gbc_pDeptNo = new GridBagConstraints();
		gbc_pDeptNo.fill = GridBagConstraints.BOTH;
		gbc_pDeptNo.insets = new Insets(0, 0, 5, 0);
		gbc_pDeptNo.gridx = 0;
		gbc_pDeptNo.gridy = 0;
		panel.add(pDeptNo, gbc_pDeptNo);
		pDeptNo.setTitle(" 번    호 ");
		pDeptNo.setLayout(new BoxLayout(pDeptNo, BoxLayout.X_AXIS));
		
		pDeptName = new TextFieldPanel();
		GridBagConstraints gbc_pDeptName = new GridBagConstraints();
		gbc_pDeptName.fill = GridBagConstraints.BOTH;
		gbc_pDeptName.insets = new Insets(0, 0, 5, 0);
		gbc_pDeptName.gridx = 0;
		gbc_pDeptName.gridy = 1;
		panel.add(pDeptName, gbc_pDeptName);
		pDeptName.setTitle(" 부서명 ");
		pDeptName.setLayout(new BoxLayout(pDeptName, BoxLayout.X_AXIS));
		
		pFloor = new TextFieldPanel();
		GridBagConstraints gbc_pFloor = new GridBagConstraints();
		gbc_pFloor.fill = GridBagConstraints.BOTH;
		gbc_pFloor.insets = new Insets(0, 0, 5, 0);
		gbc_pFloor.gridx = 0;
		gbc_pFloor.gridy = 2;
		panel.add(pFloor, gbc_pFloor);
		pFloor.setTitle(" 위   치  ");
		pFloor.setLayout(new BoxLayout(pFloor, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel.add(panel_4, gbc_panel_4);
		
		JButton btnSave = new JButton("추 가");
		panel_4.add(btnSave);
		
		JButton btnCancel = new JButton("취 소");
		panel_4.add(btnCancel);

	}

}
