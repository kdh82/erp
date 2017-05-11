package kr.or.dgit.ncs_erp.framework;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {

	private TextFieldPanel pTNo;
	private TextFieldPanel pTitle;

	public TitlePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		pTNo = new TextFieldPanel();
		GridBagConstraints gbc_pTNo = new GridBagConstraints();
		gbc_pTNo.fill = GridBagConstraints.BOTH;
		gbc_pTNo.insets = new Insets(0, 0, 5, 0);
		gbc_pTNo.gridx = 0;
		gbc_pTNo.gridy = 0;
		panel.add(pTNo, gbc_pTNo);
		pTNo.setTitle(" 번    호 ");
		pTNo.setLayout(new BoxLayout(pTNo, BoxLayout.X_AXIS));
		
		pTitle = new TextFieldPanel();
		GridBagConstraints gbc_pTitle = new GridBagConstraints();
		gbc_pTitle.fill = GridBagConstraints.BOTH;
		gbc_pTitle.insets = new Insets(0, 0, 5, 0);
		gbc_pTitle.gridx = 0;
		gbc_pTitle.gridy = 1;
		panel.add(pTitle, gbc_pTitle);
		pTitle.setTitle(" 직책명 ");
		pTitle.setLayout(new BoxLayout(pTitle, BoxLayout.X_AXIS));
		
		JPanel pTbtn = new JPanel();
		GridBagConstraints gbc_pTbtn = new GridBagConstraints();
		gbc_pTbtn.fill = GridBagConstraints.BOTH;
		gbc_pTbtn.gridx = 0;
		gbc_pTbtn.gridy = 2;
		panel.add(pTbtn, gbc_pTbtn);
		pTbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSave = new JButton("추 가");
		pTbtn.add(btnSave);
		
		JButton btnCancel = new JButton("취 소");
		pTbtn.add(btnCancel);

	}

}
