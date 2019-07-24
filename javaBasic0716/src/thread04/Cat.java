package thread04;

import java.util.Random;

public class Cat implements Runnable {
	Health h = null;
	
	int m =0;
	int b = 5500;
	int[] chk = new int[10];
	Random r = new Random();
	
	public void setlog(Health h) {
		this.h = h;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		for(int i=0;i<10; i++) {
			m = r.nextInt(6)+1;
			
			
			//조건 몸무게
			if(m==3) {
				b = b-50;
			}else if(m==4) {
				b = b-70;
			}else if(m==5) {
				b = b-90;
			}else if(m==6) {
				b = b-100;
			}
			if(m==1) {
				chk[i]=1;
				if(i!=0) {
					if(chk[i-1]==1) {
					
						b = b+100;
					}
				}
			}
			if(m==2) {
				chk[i]=2;
				if(i!=0) {
					if(chk[i-1]==2) {
					  
						b = b+200;
					}
				}
			}
			
		}
		
		if(b<=5000) {
			
			name ="몸무게 : "+b+"g"+" / "+ name+" 고양이는 다이어트 성공  ";
			h.log(name);
		}else if(b>5000) {
			
			name = "몸무게 : "+b+"g"+" / "+ name+" 고양이는 다이어트 실패";
			h.log(name);
		}
		
	}

}
