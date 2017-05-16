package kr.or.dgit.ncs_erp.framework;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class CompPanel extends JPanel {
	protected JPanel pValue;
	private JLabel lblTitle;

	public CompPanel() {
		
		lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		addComponentToFrame(lblTitle,0,0,1,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);

		pValue = new JPanel();
		addComponentToFrame(pValue,1,0,2,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);
	}

	public void setTitle(String title){
		lblTitle.setText(title);
	}
	
	public JPanel getValue() {
		return pValue;
	}

	private void addComponentToFrame(JComponent comp, int x, int y, int width, int height, double weightx, double weighty, int fill, int anchor){
		setLayout(new GridLayout(0, 2, 0, 0));
		add(comp);
	}

}
