package kr.or.dgit.ncs_erp.main;

import java.awt.EventQueue;

import kr.or.dgit.ncs_erp.ERP_Application;
import kr.or.dgit.ncs_erp.ErpLayout;

public class TestMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpLayout frame = new ErpLayout();
					frame.setVisible(true);
					ERP_Application frame1 = new ERP_Application();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}