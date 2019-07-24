package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.wordDTO;


public class wordDAO {
	Scanner in=new Scanner(System.in);
	private static wordDAO daoInstance;
	
	private wordDAO(){
		
		
	};
	public static wordDAO getInstance() {
		if(daoInstance == null) {
			daoInstance = new wordDAO();
		}
		return daoInstance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","system","1111");
			//jdm ��� : DriverManager,forname
		
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println("Connetion Faile");
		}
		
		return conn;
	}
	
	public void insert(wordDTO wordDTO) {
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
		
			ppst = conn.prepareStatement("insert into word values(?, ?)");
			
			ppst.setString(1, wordDTO.getKor());
			ppst.setString(2, wordDTO.getEng());
		
			
			
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
	
    public void update(wordDTO wordDTO2) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    
    	
    	try {
    		ppst = conn.prepareStatement("update word set kor=? where eng=?");
    	
    		ppst.setString(1, wordDTO2.getKor());
    		ppst.setString(2, wordDTO2.getEng());
    		
    	
    	
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
    
    public void delete(String delw) {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    
    	
    	try {
    		ppst = conn.prepareStatement("delete from word where eng=?");
    		ppst.setString(1, delw);
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
    
    public ArrayList<wordDTO> getList() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<wordDTO> wordDTOList = null;
    
    	
    	try {
    		//���� �ۼ��ܰ�
    		ppst = conn.prepareStatement("select * from word");
    	    //���� ����ܰ�
    		rs = ppst.executeQuery();
    		
    		//���� ����� �ִ°�?
    		if(rs.next()) {
    			wordDTOList = new ArrayList<wordDTO>();
    			
    			do {
    				wordDTO dto = new wordDTO();
    				dto.setKor(rs.getString("kor"));
    				dto.setEng(rs.getString("eng"));
    				
    				wordDTOList.add(dto);
    			
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
    	return wordDTOList;
    }
}
