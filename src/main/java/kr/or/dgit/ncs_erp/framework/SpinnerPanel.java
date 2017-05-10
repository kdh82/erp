package kr.or.dgit.ncs_erp.framework;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SpinnerPanel extends CompPanel {

	private JSpinner spinner;

	public SpinnerPanel() {
		pValue.setLayout(new GridLayout(0, 1, 0, 0));
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1500000), new Integer(1000000), new Integer(5000000), new Integer(100000)));
		pValue.add(spinner);
	}

	public void setSpinValue(int value){
		spinner.setValue(value);
	}
	
	public int getSpinValue(){
		return (int) spinner.getValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize){
		spinner.setModel(new SpinnerNumberModel(value, minimum, maximum, stepSize));
	}
}
