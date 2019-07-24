package MemberD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
			//jdm ��� : DriverManager,forname
		
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connetion Faile");
		}
		
		return conn;
	}
	
	public void insert(MemberDTO memberDTO) {
		/*
		 *1. JDBC ����̺� �ε�
		 *2. connection ����
		 *3. ��������
		 *4. ��� 
		 */
		//����̹� �ε� + connection ����� �ܰ�
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		//preparedStatement :���̺귲�� ����
		try {
			//���� �ۼ� �ܰ�
		
			ppst = conn.prepareStatement("insert into member values(?, ?, ?, default)");
			
			ppst.setString(1, memberDTO.getId());
			ppst.setString(2, memberDTO.getName());
			ppst.setString(3, memberDTO.getAdr());
			
			
			
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
    		ppst = conn.prepareStatement("update member set name=?, adr=? where id=?");
    	
    		ppst.setString(1, memberDTO2.getName());
    		ppst.setString(2, memberDTO2.getAdr());
    		ppst.setString(3, memberDTO2.getId());
    	
    		
    	
    	
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
    
    public void delete(String id) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    
    	
    	try {
    		ppst = conn.prepareStatement("delete from member where id=?");
    		ppst.setString(1, id);
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
    		//���� �ۼ��ܰ�
    		ppst = conn.prepareStatement("select * from member");
    	    //���� ����ܰ�
    		rs = ppst.executeQuery();
    		
    		//���� ����� �ִ°�?
    		if(rs.next()) {
    			memberDTOList = new ArrayList<MemberDTO>();
    			
    			do {
    				MemberDTO dto = new MemberDTO();
    				dto.setId(rs.getString("id"));
    				dto.setName(rs.getString("name"));
    				dto.setAdr(rs.getString("adr"));
    				dto.setPoint(rs.getInt("point"));
    				
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
