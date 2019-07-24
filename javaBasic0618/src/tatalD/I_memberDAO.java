package tatalD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class I_memberDAO {
	private static I_memberDAO isingleton;
	private I_memberDAO() {}
	public static I_memberDAO getInstence() {
		if(isingleton == null) {
			isingleton = new I_memberDAO();
		}
		return isingleton;
	}

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","system","1111");
			
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile");
		}
		
		return conn;
	}
	
	public void insert(I_memberDTO ift1) {
		Connection conn =  getConnection();
		PreparedStatement ppst = null;
		try {
			
			ppst = conn.prepareStatement("insert into i_comment values(no.nextVal,?,?,?,?)");
			
			ppst.setString(1, ift1.getId());
			ppst.setString(2, ift1.getCm());
			ppst.setString(3, ift1.getName());
			ppst.setString(4, ift1.getMy_id());
		
			ppst.executeUpdate();
		} catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(conn != null) ppst.close();
				
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}
	}
	
	public ArrayList<I_memberDTO> select(String myid) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<I_memberDTO> memberDTOList = null;
		
		try {
			ppst = conn.prepareStatement("select * from i_comment where id=?");
			ppst.setString(1, myid);
			ppst.executeUpdate();
			rs = ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<I_memberDTO>();
				
				do {
					I_memberDTO dto = new I_memberDTO();
					
					dto.setMy_id(rs.getString("my_id"));
					dto.setName(rs.getString("name"));
					dto.setCm(rs.getString("cm"));
					
					memberDTOList.add(dto);
				}while(rs.next());
				
			}
		} catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(rs != null) rs.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}
		return memberDTOList;
	}
			
		

}
