package thread02;

public class t2MaIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		cnt c = new cnt();
//		Thread t1 = new Thread(c);
//		t1.setName("haha");
//		
//		t1.start();
//		
//		Thread t2 = new Thread(c);
//		t2.setName("hoho");
//		
//		t2.start();
		//c라는 1개의 객체가 2개의 thread 에 들어간다

		for(int i=0; i<2; i++) {
			cnt c = new cnt();
			Thread t1 = new Thread(c);
			t1.setName("ha"+1);
			t1.start();
		}
		
	}

}
