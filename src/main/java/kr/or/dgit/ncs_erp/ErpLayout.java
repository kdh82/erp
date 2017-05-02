package kr.or.dgit.ncs_erp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ErpLayout extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackup;
	private JButton btnRestore;

	public ErpLayout() {
		setTitle("사원DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 111);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));

		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		contentPane.add(btnInit);

		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		contentPane.add(btnBackup);

		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		contentPane.add(btnRestore);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRestore) {
			actionPerformedBtnRestore(arg0);
		}
		if (arg0.getSource() == btnBackup) {
			actionPerformedBtnBackup(arg0);
		}
		if (arg0.getSource() == btnInit) {
			actionPerformedBtnInit(arg0);
		}
	}

	@SuppressWarnings("unused")
	protected void actionPerformedBtnInit(ActionEvent arg0) {
		InitSettingService init = new InitSettingService();
		init.initSetting();
		if (Config.USER == "root") {
			JOptionPane.showMessageDialog(null, "초기화완료");
		} else {
			JOptionPane.showMessageDialog(null, "초기화실패");
		}

	}

	protected void actionPerformedBtnBackup(ActionEvent arg0) {
		InitSettingService init = new InitSettingService();
		init.backup();
	}

	protected void actionPerformedBtnRestore(ActionEvent arg0) {
		InitSettingService init = new InitSettingService();
		init.restore();
	}
}
