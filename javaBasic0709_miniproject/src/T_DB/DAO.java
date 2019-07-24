package T_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DAO {
	private DAO() {}
	private static DAO usingleton;
	public static DAO getInstence() {
		if(usingleton == null) {
			usingleton = new DAO();
		}
		return usingleton;
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
	
	public void insert(DTO DTO) {
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
		
			ppst = conn.prepareStatement("insert into url values(no.nextVal, ?)");
			
			ppst.setString(1, DTO.getUlradm());
			
			
			
			
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
}
