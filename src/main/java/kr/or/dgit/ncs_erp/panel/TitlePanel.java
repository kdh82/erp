package kr.or.dgit.ncs_erp.panel;

import javax.swing.JPanel;

import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.framework.TextFieldPanel;
import kr.or.dgit.ncs_erp.service.TitleService;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {

	private TextFieldPanel pTNo;
	private TextFieldPanel pTitle;
	private JPanel panel;
	private JPanel panel_1;

	public TitlePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));
		
		pTNo = new TextFieldPanel();
		panel.add(pTNo);
		pTNo.setTitle(" 번    호 ");
		pTNo.getTf().setEditable(false);
		pTNo.setLayout(new BoxLayout(pTNo, BoxLayout.X_AXIS));
		
		pTitle = new TextFieldPanel();
		panel.add(pTitle);
		pTitle.setTitle(" 직책명 ");
		pTitle.setLayout(new BoxLayout(pTitle, BoxLayout.X_AXIS));
		
		panel_1 = new JPanel();
		panel.add(panel_1);

	}
	public void setTitle(Title title){
		pTNo.setTfValue(String.format("T%03d", title.gettCode()));
		pTitle.setTfValue(title.gettName());
	}
	public Title getTitle(){
		System.out.println("pTNo.getTfValue():"+ pTNo.getTfValue());
		int tCode = Integer.parseInt(pTNo.getTfValue().substring(1, pTNo.getTfValue().length()));
		String tName = pTitle.getTfValue();
		return new Title(tCode, tName);
	}
	public void clear(){
		pTitle.setTfValue("");
		pTitle.getTf().requestFocus();		
	}
	public void setpTNo() {
		pTNo.setTfValue(String.format("T%03d", TitleService.getInstance().selectByAllCnt()+1));
	}

	
}
