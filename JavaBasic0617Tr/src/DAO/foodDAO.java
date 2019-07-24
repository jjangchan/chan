package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class foodDAO {

	private static foodDAO daoInstance;

	private foodDAO() {
	};

	public static foodDAO getInstance() {
		if (daoInstance == null) {
			daoInstance = new foodDAO();
		}
		return daoInstance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("orcale.jdbc.driver.OraclDriver");
			conn = DriverManager.getConnection("jdbc:oracl:thin:@localhost", "system", "1111");

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("connection fail");
		}
		return conn;
	}

	public void insert(foodDTO fooddto) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {
			ppst = conn.prepareStatement("insert into fooddao values(aaa.nextVal, ?, ?)");

			ppst.setString(1, fooddto.getName());
			ppst.setInt(2, fooddto.getPrice());

			ppst.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL ERROR");

		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
	}
}
