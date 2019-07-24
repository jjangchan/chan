package DB;

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
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");
			//jdm 占쏙옙占� : DriverManager,forname
		
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connetion Faile");
		}
		
		return conn;
	}
	
	public ArrayList<MemberDTO> getList(String id) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<MemberDTO> MemberDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from member where id =?");
    	    //쿼리 수행단계
    		ppst.setString(1, id);
    		ppst.executeUpdate();
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			MemberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				MemberDTO dto = new MemberDTO();
    				dto.setId(rs.getString("id"));
    				dto.setPwd(rs.getString("pwd"));
    				dto.setName(rs.getString("name"));
    				dto.setIp(rs.getString("ip"));
    				MemberDTOList.add(dto);
    				
    				
    			
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
    	return MemberDTOList;
    }
	
	public ArrayList<MemberDTO> totalList() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<MemberDTO> MemberDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from member");
    	    //쿼리 수행단계
    		
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			MemberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				MemberDTO dto = new MemberDTO();
    				dto.setId(rs.getString("id"));
    				dto.setPwd(rs.getString("pwd"));
    				dto.setName(rs.getString("name"));
    				dto.setIp(rs.getString("ip"));
    				MemberDTOList.add(dto);
    				
    				
    			
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
    	return MemberDTOList;
	}
	
	public ArrayList<MemberDTO> getid(String id) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<MemberDTO> MemberDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from member where id =?");
    	    //쿼리 수행단계
    		ppst.setString(1, id);
    		ppst.executeUpdate();
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			MemberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				MemberDTO dto = new MemberDTO();
    				dto.setIp(rs.getString("ip"));
    			
    				MemberDTOList.add(dto);
    				
    				
    			
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
    	return MemberDTOList;
    }
	
	 public void update(MemberDTO memberDTO2) {
	    	Connection conn = getConnection();
	    	PreparedStatement ppst = null;
	    
	    	
	    	try {
	    		ppst = conn.prepareStatement("update member set ip=? where id=?");
	    	
	    		ppst.setString(1, memberDTO2.getIp());
	    		ppst.setString(2, memberDTO2.getId());
	    		
	    	
	    		
	    	
	    	
	    		ppst.executeUpdate();
	    		
	    		
	    	}catch(Exception e) {
	    		System.out.println("SQL Error");
	    	}finally {
	    		try {
	    			if(ppst!= null) ppst.close();
	    			
	    			if(conn != null) conn.close();
	    		} catch(Exception e) {
	    			System.out.println("connection close error");
	    		}
	    	}
	    	
	    }
	    
    			
    		
}
