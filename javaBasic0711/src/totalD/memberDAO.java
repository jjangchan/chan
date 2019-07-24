package totalD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class memberDAO {
	private memberDAO() {}
	private static memberDAO msingleton;
	public static memberDAO getInstence() {
		if(msingleton == null) {
			msingleton = new memberDAO();
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
	
	public ArrayList<memberDTO> getList(String id) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<memberDTO> memberDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from member where id =?");
    	    //쿼리 수행단계
    		ppst.setString(1, id);
    		ppst.executeUpdate();
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			memberDTOList = new ArrayList<memberDTO>();
    			
    			do {
    				memberDTO dto = new memberDTO();
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
}
