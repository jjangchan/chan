package TatalD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO msingleton;
	public static MemberDAO getInstence() {
		if(msingleton == null) {
			msingleton = new MemberDAO();
		}
		return msingleton;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");

		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connection Faile"+e);
		}
		return conn;
	}
	
	public void insert(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		System.out.println("n"+conn);
		
		try {
			ppst = conn.prepareStatement("insert into lotto values(?, ?, ?, ?, ?, ?, ?)");	
			ppst.setString(1, dto.getId());
			ppst.setInt(2, dto.getLotto1());
			ppst.setInt(3, dto.getLotto2());
			ppst.setInt(4, dto.getLotto3());
			ppst.setInt(5, dto.getLotto4());
			ppst.setInt(6, dto.getLotto5());
			ppst.setInt(7, dto.getLotto6());
			
			ppst.executeQuery();
			
			
		} catch (Exception e) {
			System.out.println("SQL Error" +e);
			e.printStackTrace();
		}finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error"+e);
			}
		}

	}
	
	public ArrayList<MemberDTO> getList(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<MemberDTO> memberDTOList = null;
    
    	
    	try {
    		
    		ppst = conn.prepareStatement("select * from member where id=?");
    		ppst.setString(1, dto.getId());
    		rs = ppst.executeQuery();
    		
    	
    		if(rs.next()) {
    			memberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				dto = new MemberDTO();
    				dto.setId(rs.getString("id"));
    				dto.setPwd(rs.getString("pwd"));
    				dto.setName(rs.getString("name"));
    				
    				memberDTOList.add(dto);
    			
    			}while(rs.next());
    			
    		
    		}
    		
    	}catch(Exception e) {
    		System.out.println("SQL Error");
    	}finally {
    		try {
    			if(ppst != null) ppst.close();
    			if(rs != null  ) rs.close();
    			if(conn != null) conn.close();
    		} catch(Exception e) {
    			System.out.println("connection close error");
    		}
    	}
    	return memberDTOList;
    }
	
	public void insert2(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		System.out.println("n"+conn);
		
		try {
			ppst = conn.prepareStatement("insert into member values(?, ?, ?)");	
			ppst.setString(1, dto.getId());
			ppst.setString(2, dto.getPwd());
			ppst.setString(3, dto.getName());
			
			ppst.executeQuery();
			
			
		} catch (Exception e) {
			System.out.println("SQL Error" +e);
			e.printStackTrace();
		}finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error"+e);
			}
		}

	}

	
}
