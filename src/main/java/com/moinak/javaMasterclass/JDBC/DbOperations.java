package com.moinak.javaMasterclass.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moinak.javaMasterclass.JDBC.util.DbUtil;

public class DbOperations {
	public boolean insertCategory(String type) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into category (type) values (?)");
		pstmt.setString(1, type);
		int insertCount = pstmt.executeUpdate();
		DbUtil.closeConnection(con);
		
		if(insertCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList getCategoryById(int id) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select id,type from category where id = ?");
		ArrayList<Object> resultList = new ArrayList<Object>();
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		DbUtil.closeConnection(con);
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				resultList.add(rs.getObject(i));
			}
		}
		return resultList;
	}

	public ResultSet getAllCategory() throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select id,type from category order by id");
		ResultSet rs = pstmt.executeQuery();
		DbUtil.closeConnection(con);
		return rs;
	}

	public boolean insertProduct(String name, float price, String type) throws SQLException {
		return false;
	}

	public ArrayList getProductById(int id) throws SQLException {
		return null;
	}

	public ResultSet getAllProduct() throws SQLException {
		return null;
	}

	public boolean insertOrder(String product_name, Date date) throws SQLException {
		return false;
	}

	public ArrayList getOrderById(int id) throws SQLException {
		return null;
	}

	public ResultSet getAllOrder() throws SQLException {
		return null;
	}
}
