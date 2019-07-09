package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.JobDTO;
import DTO.JobDTO;
import DTO.JobDTO;

public class JobDAO {
	private static JobDAO jsingleton;
	public static JobDAO getInstence() {
		if(jsingleton == null) {
			jsingleton = new JobDAO();
		}
		return jsingleton;
	}
	private JobDAO() {}
	
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
	
	public void insert(JobDTO JobDTO) {
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
		
			ppst = conn.prepareStatement("insert into resume values(?, ?, ?, ?,?,sysdate)");
			
			ppst.setString(1, JobDTO.getId());
			ppst.setString(2, JobDTO.getCom());
			ppst.setString(3, JobDTO.getWhy());
			ppst.setString(4, JobDTO.getChal());
			ppst.setString(5, JobDTO.getAdv());
			
			
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
	
	public ArrayList<JobDTO> getList(String mybir) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<JobDTO> JobDTOList = null;
    
    	
    	try {
    		//쿼리 작성단계
    		ppst = conn.prepareStatement("select * from resume where id=?");
    		ppst.setString(1, mybir);
			ppst.executeUpdate();
    		rs = ppst.executeQuery();
    		
    		//쿼리 결과가 있는가?
    		if(rs.next()) {
    			JobDTOList = new ArrayList<JobDTO>();
    			
    			do {
    				JobDTO dto = new JobDTO();
    				dto.setId(rs.getString("id"));
    				dto.setDay((rs.getTimestamp("day")));
    				
    				JobDTOList.add(dto);
    			
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
    	return JobDTOList;
    }
	
	   public void delete(Timestamp delw) {
	    	Connection conn = getConnection();
	    	PreparedStatement ppst = null;
	        try {
	    		ppst = conn.prepareStatement("delete from resume where day=?");
	    		ppst.setTimestamp(1, delw);
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
	   
	   public ArrayList<JobDTO> myList(Timestamp myday) {
	    	Connection conn = getConnection();
	    	PreparedStatement ppst = null;
	    	ResultSet rs = null;
	    	ArrayList<JobDTO> JobDTOList = null;
	    
	    	
	    	try {
	    		//쿼리 작성단계
	    		ppst = conn.prepareStatement("select * from resume where day=?");
	    		ppst.setTimestamp(1, myday);
				ppst.executeUpdate();
	    		rs = ppst.executeQuery();
	    		
	    		//쿼리 결과가 있는가?
	    		if(rs.next()) {
	    			JobDTOList = new ArrayList<JobDTO>();
	    			
	    			do {
	    				JobDTO dto = new JobDTO();
	    				dto.setWhy(rs.getString("why"));
	    				dto.setChal(rs.getString("chel"));
	    				dto.setAdv(rs.getString("adv"));
	    				
	    				JobDTOList.add(dto);
	    			
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
	    	return JobDTOList;
	    }
	   
	   public void update(JobDTO JobDTO2) {
	    	Connection conn = getConnection();
	    	PreparedStatement ppst = null;
	    
	    	
	    	try {
	    		ppst = conn.prepareStatement("update resume set why=?,chel=?,adv=? where day=?");
	    	
	    		ppst.setString(1, JobDTO2.getWhy());
	    		ppst.setString(2, JobDTO2.getChal());
	    		ppst.setString(3, JobDTO2.getAdv());
	    		ppst.setTimestamp(4, JobDTO2.getDay());
	    		
	    		
	    	
	    	
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
	    	
	    		
	    	
	    	
	    		
	    		
