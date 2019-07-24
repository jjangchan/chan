package thread02;
//구현
//implements 기능 제공 
public class cnt implements Runnable {
	
	int cnt=0;
	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		for(int i=0;i<5;i++) {
			cnt++;
			System.out.println("name :"+name+" / "+cnt);
		}
		
	}
	
}
