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
	Connection con;
	public static final String INSERT_CATEGORY = "INSERT INTO category (type) VALUES (?)";
	public static final String GET_ID_CATEGORY = "SELECT id, type FROM category WHERE id = ?";
	public static final String GET_ALL_CATEGORY = "SELECT id, type FROM category";
	public static final String INSERT_PRODUCT = "INSERT INTO product (name, price, category_id) VALUES (?, ?, id) SELECT id FROM category WHERE type = \"?\"";
	public static final String GET_ID_PRODUCT = "";
	public static final String GET_ALL_PRODUCT = "";
	public static final String INSERT_ORDER = "";
	public static final String GET_ID_ORDER = "";
	public static final String GET_ALL_ORDER = "";
	
	
	public DbOperations() {
        con = DbUtil.getConnection();
    }
	
	
	public boolean insertCategory(String type) throws SQLException {
		PreparedStatement preparedStatement = this.con.prepareStatement(INSERT_CATEGORY);

		preparedStatement.setString(0, "\"" + type + "\"");

		return preparedStatement.execute();
	}

	public ArrayList getCategoryById(int id) throws SQLException {
		PreparedStatement preparedStatement = this.con.prepareStatement(GET_ID_CATEGORY);
		preparedStatement.setInt(0, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList arrayList = new ArrayList();
		while (resultSet.next()) {
			arrayList.add(resultSet.getInt("id"));
			arrayList.add(resultSet.getString("type"));
		}

		return arrayList;
	}

	public ResultSet getAllCategory() throws SQLException {
		PreparedStatement preparedStatement = this.con.prepareStatement(GET_ALL_CATEGORY);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	public boolean insertProduct(String name, float price, String type) throws SQLException {
		PreparedStatement statement = this.con.prepareStatement("INSERT INTO product (name, price, category_id) VALUES (?,?,(SELECT id FROM category WHERE type = ?))");
        statement.setString(0, "\"" + name + "\"");
        statement.setFloat(1, price);
        statement.setString(2,"\"" + type + "\"");
        return statement.execute();
	}

	public ArrayList getProductById(int id) throws SQLException {
		 PreparedStatement statement = this.con.prepareStatement(GET_ID_PRODUCT);
	        statement.setInt(0, id);
	        ArrayList arrayList = new ArrayList();
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()){
	            arrayList.add(resultSet.getInt("id"));
	            arrayList.add(resultSet.getString("name"));
	            arrayList.add(resultSet.getFloat("price"));
	            arrayList.add(resultSet.getInt("category_id"));
	        }
	        return arrayList;
	}

	public ResultSet getAllProduct() throws SQLException {
		PreparedStatement preparedStatement = this.con.prepareStatement(GET_ALL_PRODUCT);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	public boolean insertOrder(String product_name, Date date) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"insert into product (product_id,date) values (id,?) select id from product where name = ?");
		pstmt.setDate(1, date);
		pstmt.setString(2, product_name);
		int insertCount = pstmt.executeUpdate();
		DbUtil.closeConnection(con);

		if (insertCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList getOrderById(int id) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select id,product_id,order_date from orders where id = ?");
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

	public ResultSet getAllOrder() throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select id,product_id,order_date from category order by id");
		ResultSet resultSet = pstmt.executeQuery();
		DbUtil.closeConnection(con);
		return resultSet;
	}
}
