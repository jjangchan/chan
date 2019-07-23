package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
	Scanner in=new Scanner(System.in);
	private static MemberDAO daoInstance;
	
	private MemberDAO(){
		
		
	};
	public static MemberDAO getInstance() {
		if(daoInstance == null) {
			daoInstance = new MemberDAO();
		}
		return daoInstance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","system","1111");
			//jdm 기능 : DriverManager,forname
		
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connetion Faile");
		}
		
		return conn;
	}
	
	public void insert(MemberDTO memberDTO) {
		/*
		 *1. JDBC 드라이브 로드
		 *2. connection 맺음
		 *3. 쿼리수행
		 *4. 결과 
		 */
		//드라이버 로드 + connection 만드는 단계
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		//preparedStatement :라이브럴리 설명서
		try {
			//쿼리 작성 단계
		
			ppst = conn.prepareStatement("insert into member values(no.nextVal, ?, ?, ?)");
			
			ppst.setString(1, memberDTO.getName());
			ppst.setString(2, memberDTO.getAddr());
			ppst.setString(3, memberDTO.getMail());
			
			
			ppst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("SQL Error");
		}finally {
			try {
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				System.out.println("connection close error");
			}
		}

		
	
	}
	
    public void update(MemberDTO memberDTO2) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    
    	
    	try {
    		ppst = conn.prepareStatement("update member set name=?,mail=?,addr=? where id=?");
    	
    		ppst.setString(1, memberDTO2.getName());
    		ppst.setString(2, memberDTO2.getAddr());
    		ppst.setString(3, memberDTO2.getMail());
    		ppst.setInt(4, memberDTO2.getId());
    		
    	
    	
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
    
    public void delete(MemberDTO memberDTO3) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    
    	
    	try {
    		ppst = conn.prepareStatement("delete from member where id=?");
    		ppst.setInt(1, memberDTO3.getId());
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
    
    public ArrayList<MemberDTO> getList() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<MemberDTO> memberDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from member");
    	    //쿼리 수행단계
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			memberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				MemberDTO dto = new MemberDTO();
    				dto.setId(rs.getInt("id"));
    				dto.setAddr(rs.getString("addr"));
    				dto.setMail(rs.getString("mail"));
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
}

    		
    		
    	
    	
    		
    		
   
