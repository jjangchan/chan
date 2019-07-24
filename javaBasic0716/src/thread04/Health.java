package thread04;

public class Health {
	Cat cat[] = new Cat[5];
	String chk = null;
	
	Health(){
		go();
	}
	
	public void go() {
		cat[0] = new Cat();
		cat[0].setlog(this);
		Thread t1 = new Thread(cat[0]);
		t1.setName("벵골");
		
		cat[1] = new Cat();
		cat[1].setlog(this);
		Thread t2 = new Thread(cat[1]);
		t2.setName("스핑크스");
		
		cat[2] = new Cat();
		cat[2].setlog(this);
		Thread t3 = new Thread(cat[2]);
		t3.setName("샴");
		
		cat[3] = new Cat();
		cat[3].setlog(this);
		Thread t4 = new Thread(cat[3]);
		t4.setName("아시안 블루");
		
		cat[4] = new Cat();
		cat[4].setlog(this);
		Thread t5 = new Thread(cat[4]);
		t5.setName("페르시안");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	public void log(String chk) {
		synchronized(this) {
			this.chk = chk;
			System.out.println(chk);
		}
	}
	
}
