package kr.or.dgit.ncs_erp.framework;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CompPanel extends JPanel {
	protected JPanel pValue;
	private GridBagConstraints gbConstraints;
	private JLabel lblTitle;

	public CompPanel() {
		gbConstraints = new GridBagConstraints();
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.0, 1.0};
		gbl.columnWidths = new int[]{100, 200};
		setLayout(gbl);
		
		lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		addComponentToFrame(lblTitle,0,0,1,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);

		pValue = new JPanel();
		addComponentToFrame(pValue,1,0,2,1,1.0,1.0,GridBagConstraints.BOTH, GridBagConstraints.WEST);
	}

	public void setTitle(String title){
		lblTitle.setText(title);
	}
	
	public JPanel getValueComp() {
		return pValue;
	}

	private void addComponentToFrame(JComponent comp, int x, int y, int width, int height, double weightx, double weighty, int fill, int anchor){
//		gbConstraints.ipady = 10;  //컴포넌트 내  여백 padding
//		gbConstraints.ipadx = 20;  //컴포넌트 내  여백 padding
		gbConstraints.insets = new Insets(0, 5, 0, 5);//컴포넌트간여백
		gbConstraints.fill = fill; 
		gbConstraints.gridx = x;
		gbConstraints.gridy = y;
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;
		add(comp, gbConstraints);
	}

}
