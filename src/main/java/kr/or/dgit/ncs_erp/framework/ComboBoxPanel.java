package kr.or.dgit.ncs_erp.framework;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ComboBoxPanel<T> extends CompPanel {
	private JComboBox<T> tf;
	
	public ComboBoxPanel() {
		pValue.setLayout(new GridLayout(0, 1));
		tf = new JComboBox<>();
		pValue.add(tf);
	}

	public void setComboDatas(Vector<T> items){
		for(int i=0; i<items.size(); i++){
			tf.addItem(items.get(i));
		}
	}
	
	public Object getSelectedItem(){
		return tf.getSelectedItem();
	}
	
	public void setSelectedItem(Object obj){
		tf.setSelectedItem(obj);
	}
	
	public void setSelectedIndex(int idx){
		tf.setSelectedIndex(idx);
	}
}
