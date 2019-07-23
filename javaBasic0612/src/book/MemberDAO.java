package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
	Scanner in=new Scanner(System.in);
	private MemberDAO(){}
	
	private static MemberDAO daosingleton;
	public static MemberDAO getInstance() {
		if(daosingleton==null) {
			daosingleton=new MemberDAO();
		}
		return daosingleton;
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
	
	public void insert(MemberDTO ft1) {
		Connection conn =  getConnection();
		PreparedStatement ppst = null;
		try {
			
			ppst = conn.prepareStatement("insert into book values(no2.nextVal, ?, ?,sysdate, ?)");
			
			ppst.setString(1, ft1.getName());
			ppst.setString(2, ft1.getAuthor());
			ppst.setString(3, ft1.getRent_id());
			
		
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
	
	public void update(MemberDTO ft2) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {
			ppst = conn.prepareStatement("update member set name=?,author=?,rent_id=? where ISBN=?");
			ppst.setString(1, ft2.getName());
			ppst.setString(2, ft2.getAuthor());
			
			ppst.setString(3, ft2.getRent_id());
			ppst.setInt(4, ft2.getISBN());
			
			ppst.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(conn != null) conn.close();
				if(ppst != null) ppst.close();
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}
	}
	
	public void delete(MemberDTO ft3) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {
			ppst = conn.prepareStatement("delete from book where ISBN=?");
			ppst.setInt(1, ft3.getISBN());
			ppst.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("SQL Error");
		}finally{
			try {
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}
	}
	
	
	public List<MemberDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> memberDTOList = null;
		
		try {
			ppst = conn.prepareStatement("select * from book");
			rs = ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<MemberDTO>();
				
				do {
					MemberDTO dto = new MemberDTO();
					dto.setISBN(rs.getInt("ISBN"));
					dto.setName(rs.getString("name"));
					dto.setAuthor(rs.getString("author"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					dto.setRent_id(rs.getString("rent_id"));
					
					memberDTOList.add(dto);
				}while(rs.next());
				
			}
		} catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(rs != null) rs.close();
				if(conn != null) rs.close();
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}
		return memberDTOList;
	}

}
