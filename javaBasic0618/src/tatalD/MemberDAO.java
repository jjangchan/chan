package tatalD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	private static MemberDAO Msingleton;
	private MemberDAO() {}
	public static MemberDAO getInstence() {
		if(Msingleton == null) {
			Msingleton = new MemberDAO();
		}
		return Msingleton;
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
			
			ppst = conn.prepareStatement("insert into member values(no.nextVal,?,?,?,?)");
			
			ppst.setString(1, ft1.getId());
			ppst.setString(2, ft1.getPwd());
			ppst.setString(3, ft1.getName());
			ppst.setInt(4, ft1.getPh());
			
			
		
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
			ppst = conn.prepareStatement("update member set pwd=?,name=?,ph=? where id=?");
			ppst.setString(1, ft2.getPwd());
			ppst.setString(2, ft2.getName());
			
			ppst.setInt(3, ft2.getPh());
			ppst.setString(4, ft2.getId());
			
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
	
	public void delete(String did) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {
			ppst = conn.prepareStatement("delete from member where id=?");
			ppst.setString(1, did );
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
	
	
	public ArrayList<MemberDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> memberDTOList = null;
		
		try {
			ppst = conn.prepareStatement("select * from member");
			rs = ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<MemberDTO>();
				
				do {
					MemberDTO dto = new MemberDTO();
					
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setPh(rs.getInt("ph"));
					
					
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
	
	public ArrayList<MemberDTO> select(String myid) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> memberDTOList = null;
		
		try {
			ppst = conn.prepareStatement("select * from member where id=?");
			ppst.setString(1, myid);
			ppst.executeUpdate();
			rs = ppst.executeQuery();
			
			if(rs.next()) {
				memberDTOList = new ArrayList<MemberDTO>();
				
				do {
					MemberDTO dto = new MemberDTO();
					
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					dto.setName(rs.getString("name"));
					dto.setPh(rs.getInt("ph"));
					
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
