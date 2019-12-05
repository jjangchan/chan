package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class DAO {
	private DAO() {}
	private static DAO dsingleton;
	public static DAO getInstence() {
		if(dsingleton == null) {
			dsingleton = new DAO();
		}
		return dsingleton;
	}
	
	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1111");

		} catch (Exception e) {
			e.getStackTrace();
			//System.out.println("Connection Faile / " + e);
		}

		return conn;
	}
	
	public boolean insertS(StockDTO dto) { //리턴 값(boolean) 줘서 순차적으로 넣어주기 
		Connection conn = getConnection();

		PreparedStatement ppst = null;
		
		boolean ret = true;
		try {
			// 荑쇰━ �옉�꽦�떒怨�
			ppst = conn.prepareStatement("insert into stock values(?,?,?)");
			ppst.setString(1, dto.getNameS());
		    ppst.setInt(2, dto.getPrice());
		    ppst.setInt(3, dto.getCnt());
			
			System.out.println("insert-End");
			ppst.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL Error");
			ret = false;
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
				ret = false;
			}
		}
		return ret;
	}
	
	public void insertE(EstockDTO DTO) {

		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {
			System.out.println(conn);
			ppst = conn.prepareStatement("insert into eachstock values(?, ?, ?, ?, ? , trunc(sysdate,'dd'))");

			ppst.setString(1, DTO.getName());
			ppst.setInt(2, DTO.getPrice());
			ppst.setInt(3, DTO.getPriceS());
			ppst.setInt(4, DTO.getPriceL());
			ppst.setInt(5, DTO.getPriceH());

			
			ppst.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}

	}
	
	public void insertM(MemberDTO DTO) {

		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {
			System.out.println(conn);
			ppst = conn.prepareStatement("insert into member values(?, ?, ?, ?)");

			ppst.setString(1, DTO.getId());
			ppst.setString(2, DTO.getPwd());
			ppst.setString(3, DTO.getName());
			ppst.setString(4, DTO.getAddr());

			
			ppst.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}

	}
	
	public void insertB(BalanDTO dto) {

		Connection conn = getConnection();
		PreparedStatement ppst = null;
		
		try {

			ppst = conn.prepareCall("insert into balance values(?,?,?,?,?,trunc(sysdate,'dd'),?,?) ");
			// 쿼리 수행단계
			ppst.setString(1, dto.getId());
			ppst.setString(2, dto.getEvent());
			ppst.setInt(3, dto.getTotalM());
			ppst.setString(4, dto.getTotalC());
			ppst.setString(5, dto.getYield());
			ppst.setInt(6, dto.getSell());
			ppst.setDouble(7, dto.getBuying());

			
			ppst.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}

	}
	
	public void updateB(BalanDTO dto) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {
			ppst = conn.prepareStatement("update balance set totalM=?,totalC=?,yield=?,sell=?,buying=? where id=? and event=?");

			ppst.setInt(1, dto.getTotalM());
			ppst.setString(2, dto.getTotalC());
			ppst.setString(3, dto.getYield());
			ppst.setInt(4, dto.getSell());
			ppst.setDouble(5, dto.getBuying());
			ppst.setString(6, dto.getId());
			ppst.setString(7, dto.getEvent());

			ppst.executeUpdate();

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}

	}

	
	public void updateE(EstockDTO DTO) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {
			ppst = conn.prepareStatement("update eachstock set price=?,priceS=?,priceL=?,priceH=?,day=trunc(sysdate,'dd') where name=?");

			ppst.setInt(1, DTO.getPrice());
			ppst.setInt(2, DTO.getPriceS());
			ppst.setInt(3, DTO.getPriceL());
			ppst.setInt(4, DTO.getPriceH());
			ppst.setString(5, DTO.getName());

			ppst.executeUpdate();

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}

	}
	
	public boolean updateS(StockDTO DTO) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;

		try {
			ppst = conn.prepareStatement("update stock set cnt=? where nameS=? and price=?");

			ppst.setInt(1, DTO.getCnt());
			ppst.setString(2, DTO.getNameS());
			ppst.setInt(3, DTO.getPrice());
			

			ppst.executeUpdate();

		} catch (Exception e) {
			System.out.println("SQL Error11");
			return false;
		} finally {
			try {
				if (ppst != null)
					ppst.close();

				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
				return false;
			}
		}
		return true;

	}
	
	public int serchE(String chk) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		int price = 0;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from eachstock where name =?");
			// 쿼리 수행단계
			ppst.setString(1, chk);
			ppst.executeUpdate();
			rs = ppst.executeQuery();

			// 쿼리 결과가 있는가?
			if (rs.next()) {
				price = 0;
				do {
					price = rs.getInt("price");
				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
		return price;
	}
	
	public int serchS(int price,String name) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		int cnt = -2;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from stock where price =? and nameS=?");
			// 쿼리 수행단계
			ppst.setInt(1, price);
			ppst.setString(2, name);
			ppst.executeUpdate();
			rs = ppst.executeQuery();

			// 쿼리 결과가 있는가?
			if (rs.next()) {

				do {
					cnt = rs.getInt("cnt");
				} while (rs.next());

			}

		} catch (Exception e) {
//			System.out.println("SQL Error");
			return -1;
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
//				System.out.println("connection close error");
				return -1;
			}
		}
		return cnt;
	}
	
	public String serchM(String chk,int sing) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		String id = null;
		String pwd = null;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from member where id =?");
			// 쿼리 수행단계
			ppst.setString(1, chk);
			ppst.executeUpdate();
			rs = ppst.executeQuery();

			// 쿼리 결과가 있는가?
			if (rs.next()) {
				do {
					id= rs.getString("id");
					pwd = rs.getString("pwd");
				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
		if(sing==1) {
			return id;
		}else {
			return pwd;
		}
	}
	

	public String serchBI(String id,String event) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		String chk = null;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from balance where id =? and event =?");
			// 쿼리 수행단계
			ppst.setString(1, id);
			ppst.setString(2, event);
			ppst.executeUpdate();
			rs = ppst.executeQuery();

			// 쿼리 결과가 있는가?
			if (rs.next()) {
				do {
					chk = rs.getString("event");
				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("SQL Error");
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
		return chk;
	}
	
	public int serchB(String id,String event,int chk) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		int buysum = 0;

		try {
			// 쿼리 작성단계
			ppst = conn.prepareStatement("select * from balance where id =? and event=?");
			// 쿼리 수행단계
			ppst.setString(1, id);
			ppst.setString(2, event);
			ppst.executeUpdate();
			rs = ppst.executeQuery();

			// 쿼리 결과가 있는가?
			if(chk==1) {
				if (rs.next()) {
					do {
						buysum = rs.getInt("buying");
					} while (rs.next());
					
				}
			}else {
				if (rs.next()) {
					do {
						buysum = rs.getInt("totalM");
					} while (rs.next());
					
				}
			}

		} catch (Exception e) {
			System.out.println("SQL Error / serchB");
			return -1;
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
			}
		}
		return buysum;
	}
	
    public ArrayList<BalanDTO> getListB() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<BalanDTO> BalanDTOList = null;
    
    	
    	try {
    		//���� �ۼ��ܰ�
    		ppst = conn.prepareStatement("select * from balance");
    	    //���� ����ܰ�
    		rs = ppst.executeQuery();
    		
    		//���� ����� �ִ°�?
    		if(rs.next()) {
    			BalanDTOList = new ArrayList<BalanDTO>();
    			
    			do {
    				BalanDTO dto = new BalanDTO();
    				dto.setId(rs.getString("id"));
    				dto.setBuying(rs.getInt("buying"));
    				dto.setSell(rs.getInt("totalM"));
    				dto.setTotalC(rs.getString("totalC"));
    				dto.setYield(rs.getString("yield"));
    				dto.setEvent(rs.getString("event"));
    				BalanDTOList.add(dto);
    				return BalanDTOList;
    			}while(rs.next());
    		}
    		
    	}catch(Exception e) {
    		System.out.println("SQL Error");
    		BalanDTOList = new ArrayList<BalanDTO>();
    		BalanDTO dto = new BalanDTO();
    		dto.setId("error");
    		BalanDTOList.add(dto);
    	
    	}finally {
    		try {
    			if(ppst != null) ppst.close();
    			if(rs != null  ) rs.close();
    			if(conn != null) conn.close();
    		} catch(Exception e) {
    			System.out.println("connection close error");
    		}
    	}
    	return BalanDTOList;
    }
    
    public ArrayList<serverDTO> getListS() {
    	Connection conn = getConnection();
    	PreparedStatement ppst = null;
    	ResultSet rs = null;
    	ArrayList<serverDTO> serverDTOList = null;
    	System.out.println("dsads");
    	
    	try {
    		//���� �ۼ��ܰ�
    		ppst = conn.prepareStatement("select * from server");
    	    //���� ����ܰ�
    		rs = ppst.executeQuery();
    		
    		//���� ����� �ִ°�?
    		if(rs.next()) {
    			serverDTOList = new ArrayList<serverDTO>();
    			
    			do {
    				serverDTO dto = new serverDTO();
    				dto.setEvent(rs.getString("event"));
    				dto.setPort(rs.getInt("port"));
    			
    				serverDTOList.add(dto);
    			}while(rs.next());
    		}
    		
    	}catch(Exception e) {
    		System.out.println("SQL Error123123123");
    	
    	}finally {
    		try {
    			if(ppst != null) ppst.close();
    			if(rs != null  ) rs.close();
    			if(conn != null) conn.close();
    		} catch(Exception e) {
    			System.out.println("connection close error");
    		}
    	}
    	return serverDTOList;
    }
    
    
	public boolean procS(StockDTO dto) {
		Connection conn = getConnection();
		CallableStatement cs3 = null;
		

		try {
			// 쿼리 작성단계
			cs3 = conn.prepareCall("call stock_proc(?,?,?) ");
			// 쿼리 수행단계
			cs3.setString(1, dto.getNameS());
			cs3.setInt(2, dto.getPrice());
			cs3.setInt(3, dto.getCnt());
			cs3.executeUpdate();
	

			// 쿼리 결과가 있는가?

		} catch (Exception e) {
			System.out.println("SQL Error");
			return false;
		} finally {
			try {
				if (cs3 != null)
					cs3.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
				return false;
			}
		}
		return true;
	}
	

	public boolean procB(BalanDTO dto) {
		Connection conn = getConnection();
		CallableStatement cs3 = null;
		

		try {
			// 쿼리 작성단계
			cs3 = conn.prepareCall("call balance_proc(?,?,?,?,?,trunc(sysdate,'dd'),?,?) ");
			// 쿼리 수행단계
			cs3.setString(1, dto.getId());
			cs3.setString(2, dto.getEvent());
			cs3.setInt(3, dto.getTotalM());
			cs3.setString(4, dto.getTotalC());
			cs3.setString(5, dto.getYield());
			cs3.setInt(6, dto.getSell());
			cs3.setDouble(7, dto.getBuying());
			cs3.executeUpdate();
	

			// 쿼리 결과가 있는가?

		} catch (Exception e) {
			System.out.println("SQL Error / procB");
			return false;
		} finally {
			try {
				if (cs3 != null)
					cs3.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("connection close error");
				return false;
			}
		}
		return true;
	}
	
}
    				
    				
    			 
