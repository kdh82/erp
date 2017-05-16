package kr.or.dgit.ncs_erp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.ncs_erp.dto.Title;
import kr.or.dgit.ncs_erp.panel.TitlePanel;
import kr.or.dgit.ncs_erp.service.TitleService;
import kr.or.dgit.ncs_erp.table.TitleTable;

@SuppressWarnings("serial")
public class ViewTitle extends JFrame implements ActionListener {

	private JPanel contentPane;
	private TitlePanel panelTitle;
	private TitleTable tTable;
	private JPanel panel_2;
	private JButton btnSave;
	private JButton btnCancel;
	private JPopupMenu popupMenu;
	private static final ViewTitle instance = new ViewTitle();
	

	public static ViewTitle getInstance() {
		return instance;
	}

	public ViewTitle() {
		setTitle("직책 관리");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 300, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		panelTitle = new TitlePanel();
		panelTitle.setBorder(new EmptyBorder(10, 100, 10, 100));
		contentPane.add(panelTitle);
		panelTitle.setLayout(new BoxLayout(panelTitle, BoxLayout.X_AXIS));
		panelTitle.setpTNo();
		
		panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(panel_2);
		
		btnSave = new JButton("추가");
		btnSave.addActionListener(this);
		panel_2.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_2.add(btnCancel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tTable = new TitleTable();
		tTable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON3){
					createPopupMenu();
					popupMenu.show(tTable.getTable(),e.getX(),e.getY());
				}
				super.mouseClicked(e);
			}
			
		});
		panel_1.add(tTable);
	}
	private void createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		JMenuItem deleteItem = new JMenuItem("삭제");
		
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Title title = tTable.getSelectedObject();
				if (title == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				panelTitle.setTitle(title);
			}
		});
		
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Title title = tTable.getSelectedObject();
				if(title == null){
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				TitleService.getInstance().deleteTitle(title);
				tTable.loadData();
				
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
				
			}
		});
		popupMenu.add(updateItem);
		popupMenu.add(deleteItem);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}
	protected void actionPerformedBtnSave(ActionEvent e) {
		TitleService.getInstance().insertTitle(panelTitle.getTitle());
		tTable.loadData();
		panelTitle.clear();
		
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		panelTitle.clear();
	}
}
