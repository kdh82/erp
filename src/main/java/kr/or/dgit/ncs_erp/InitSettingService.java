package kr.or.dgit.ncs_erp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InitSettingService {

	public void initSetting() {
		try {
			DaoSet dao = DaoSet.getInstance();
			dao.getUpdateResult("Drop database if exists " + Config.DB_NAME);
			System.out.println("Drop database if exists " + Config.DB_NAME);

			dao.getUpdateResult("Create Database if not exists " + Config.DB_NAME);
			System.out.println("Create Database " + Config.DB_NAME);

			dao.getUpdateResult("use " + Config.DB_NAME);
			System.out.println("use " + Config.KDH_USER);

			for (int i = 0; i < Config.CREATE_SQL_TABLE.length; i++) {
				dao.getUpdateResult(Config.CREATE_SQL_TABLE[i]);
			}
			dao.getUpdateResult(Config.CREATE_USER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		File buFile = new File(Config.EXPORT_DIR);
		// BackupFiles폴더
		File[] buFiles = buFile.listFiles();
		try {
			if (buFiles.length < 1) {
			}
			initSetting();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "복원 파일이 없습니다");
		}
	}

	public void restore() {
		for (int i = 0; i < Config.TABLE_NAMES.length; i++) {
			loadTableData(i);
		}
		JOptionPane.showMessageDialog(null, "데이터 복원 완료");
	}

	public void backup() {
		File buFile = new File(Config.EXPORT_DIR);

		File[] buFiles = buFile.listFiles();
		if (buFile.exists() == false) {
			buFile.mkdir();
		}
		for (File f : buFiles) {
			if (f.exists()) {
				f.delete();
			}
		}
		for (int i = 0; i < Config.CREATE_SQL_TABLE.length; i++) {
			BackupTableData(i);
		}
		JOptionPane.showMessageDialog(null, "데이터 백업 완료");
	}

	private void loadTableData(int tables) {
		File file = new File(Config.IMPORT_DIR + Config.TABLE_NAMES[tables] + ".txt");
		String sql = "load data local infile '%s' " + "into table " + Config.TABLE_NAMES[tables] + " "
				+ "character set 'UTF8' " + "fields terminated by ',' " + "lines terminated by '\n'";

		executeImportData(String.format(sql, file.getAbsolutePath().replace("\\", "/")), file.getName());
	}

	public void BackupTableData(int tables) {
		String sql = "select * from " + Config.TABLE_NAMES[tables];
		Connection con = DBCon.getConnection(Config.URL + Config.DB_NAME, Config.USER, Config.PWD);
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			StringBuilder sb = new StringBuilder();
			int colCnt = rs.getMetaData().getColumnCount();
			int cnt = 0;
			while (rs.next()) {
				for (int i = 1; i <= colCnt; i++) {
					Object obj = rs.getObject(i);
					if (obj.equals(true)) {
						obj = 1;
					} else if (obj.equals(false)) {
						obj = 0;
					}
					sb.append(obj + ",");
				}
				sb.replace(sb.length() - 1, sb.length(), "");
				sb.append("\n");
				cnt++;
			}
			System.out.printf("Export Table(%s) %d Rows Success! %n", Config.TABLE_NAMES[tables], cnt);
			try (BufferedOutputStream bw = new BufferedOutputStream(
					new FileOutputStream(Config.EXPORT_DIR + Config.TABLE_NAMES[tables] + ".txt"));
					OutputStreamWriter osw = new OutputStreamWriter(bw, "UTF-8")) {
				osw.write(sb.toString());

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void executeImportData(String sql, String tableName) {
		Statement stmt = null;
		try {
			Connection con = DBCon.getConnection(Config.URL + Config.DB_NAME, Config.USER, Config.PWD);
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n", tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
		}
	}
}