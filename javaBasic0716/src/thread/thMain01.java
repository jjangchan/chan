package thread;

public class thMain01 {

	public static void main(String[] args) {
		cnt c = new cnt();
		c.start(); //돌려야 할 대상은 run에있음
//		try {
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//c.run();
		
		System.out.println("main end");

	}

}
