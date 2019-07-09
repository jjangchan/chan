package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.LuckyDTO;

public class LuckyDAO {
	
	private static LuckyDAO lsingleton=null;
	public static LuckyDAO getinstence() {
		if(lsingleton == null) {
			lsingleton = new LuckyDAO();
		}
		return lsingleton;
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
	
	public ArrayList<LuckyDTO> getList(String mybt) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<LuckyDTO> LuckyDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from luck where birth=?");
    		ppst.setString(1, mybt);
			ppst.executeUpdate();
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			LuckyDTOList = new ArrayList<LuckyDTO>();
    			
    			do {
    				LuckyDTO dto = new LuckyDTO();
    				dto.setStudy(rs.getString("study"));
    				dto.setLove(rs.getString("love"));
    				
    				LuckyDTOList.add(dto);
    			
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
    	return LuckyDTOList;
    }
	
	public ArrayList<LuckyDTO> getList1() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<LuckyDTO> LuckyDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from luck where (study like '%좋은%' or study like '%결과%' or study like '%노력%')");
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			LuckyDTOList = new ArrayList<LuckyDTO>();
    			
    			do {
    				LuckyDTO dto = new LuckyDTO();
    				dto.setBirth(rs.getString("birth"));
    				
    				LuckyDTOList.add(dto);
    			
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
    	return LuckyDTOList;
    }


}
