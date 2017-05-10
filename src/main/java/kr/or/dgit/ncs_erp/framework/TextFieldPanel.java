package kr.or.dgit.ncs_erp.framework;

import java.awt.GridLayout;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldPanel extends CompPanel {
	private JTextField tf;

	public TextFieldPanel() {
		pValue.setLayout(new GridLayout(0, 1));
		tf = new JTextField();
		pValue.add(tf);
	}

	public String getTfValue() {
		return tf.getText().trim();
	}

	public void setTfValue(String value) {
		tf.setText(value);
	}

	public void isEmptyCheck() throws Exception {
		if (tf.getText().equals("")) {
			tf.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public JTextField getTf() {
		return tf;
	}

}
