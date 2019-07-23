package member;

public class member {
	String id=null; //id 저장 변수
	String pwd=null;//pwd 저장 변수
	
	public void input(String sid) {  //sid로 데이터 입력받아 id라는 변수에 저장
		id=sid;
	}
	public void prt() { //현재 객체가 저장하고 있는 id와pwd를 출력
		System.out.println(id+"/"+pwd);
	}

}
