package extendsex;

import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Sub1> sub1unit = new ArrayList<>();
		
		for(int i=0;i<3;i++) {
			Sub1 s1 = new Sub1("DDD",20);
			sub1unit.add(s1);
		}
		
		//유닛 공격 실행
		for(int i=0; i<sub1unit.size();i++) {
			sub1unit.get(i).attact();
		}
		
	}
	
}
			
