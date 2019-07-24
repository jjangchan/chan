package thread04_1;

import java.util.Random;

public class Cat1 implements Runnable {
	Random r = new Random();
	Health1 h;
	int rnum=0;
	int b = 6000;
	int cntH = 0;
	int[] chk = new int[10000];
	public void getchk(Health1 h) {
		this.h = h;
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		boolean frag = true;
		while(frag) {
			cntH++;
			rnum = r.nextInt(6)+1;
			switch(rnum) {
				case 1 :if(cntH !=0) {
						if(chk[cntH]==1) {
						if(chk[cntH-1]==1) {
							b = b+100;
						}
						}
				}break;
				case 2 : if(cntH !=0) {
					if(chk[cntH]==1) {
						if(chk[cntH-1]==1) {
							b = b+100;
						}
					}
				}break;
				case 3 : b = b-50; break;
				case 4 : b = b-70; break;
				case 5 : b = b-90; break;
				case 6 : b = b-100; break;
			}
			if(b>=5000 && b<=5500) {
				frag = false;
			}
		}
		
		h.setchk(name, cntH, b);
		
	}
}
					
				
