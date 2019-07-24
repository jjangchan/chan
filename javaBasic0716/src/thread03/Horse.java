package thread03;

import java.util.Random;

public class Horse implements Runnable {
	Random r = new Random();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		int m=0;
		
		boolean frag = true;
		while(frag) {
			int rnum = r.nextInt(5)+1;
			m = m+rnum;
//			System.out.println(name+" / "+m+"m 달림");
			if(m>=100) {
				frag = false;
			}
		}
		Main.setfinal(name);
	}
	
}
				
