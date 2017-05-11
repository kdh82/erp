package kr.or.dgit.ncs_erp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.spi.ThrowableRendererSupport;

import kr.or.dgit.ncs_erp.Config;
import kr.or.dgit.ncs_erp.DBCon;

public class Dao {
	private static Dao instance = new Dao();

	private Dao() {
	}

	public static Dao getInstance() {
		return instance;
	}

	public PreparedStatement getPreStmt(String sql, Object... objects) throws Exception {
		Connection con = DBCon.getConnection(Config.URL + Config.DB_NAME, Config.USER, Config.PWD);
		PreparedStatement pStmt = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			pStmt.setObject(i + 1, objects[i]);
		}
		return pStmt;

	}

	public int getQueryCnt(String sql, Object... objects) throws Exception {
		PreparedStatement pstmt = getPreStmt(sql, objects);
		pstmt.execute();
		int res = pstmt.getUpdateCount();
		return res;

	}

	public ResultSet getQueryRes(String sql, Object... objects) throws Exception {
		PreparedStatement pstmt = getPreStmt(sql, objects);
		return pstmt.executeQuery();
	}

}
