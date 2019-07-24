package thread;
// 상속 thread 처리
public class cnt extends Thread {

	int cnt=0;
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(cnt);
			
			cnt++;
		}
	}
	/***
	 * 스레드를 구현 하는 방법
	 * 1. 상속 extends
	 * 2. 구현 implements
	 * 3. 익명
	 */
}
