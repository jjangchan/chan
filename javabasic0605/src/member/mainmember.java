package member;

public class mainmember {
	
	mainmember(){                              //생성자는 매개변수가 있을수 있다. 그러나 리턴은 불가능
		
	}
	
	public void input(){                      //매개변수가 없는 메서드,void는 리턴값이 없다
		
	}
	
	public void viewinfo(String id) {        //매개 변수를 활용한 메서드
		
	}
	
	public int checkLen(String id){          // 리턴이 있는 메서드,리턴값이 있는데 타입이 int형이다.
		int len=id.length();
		return len;
	}
	
	public String checkID(String id) {
		return null;
	}
	
	public String[] checkIDa(String id) {
		String[] a=new String[5];
		return a;
	}
}
