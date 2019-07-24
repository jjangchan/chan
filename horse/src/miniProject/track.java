package miniProject;

public class track{
	
	horse[] h = new horse[5];
	int num = 0;
	
	track(){
		go();
	}
	
	
	public void setNum(String name) {
		synchronized (this) { //동기화를 보장해라(해당하는객체에) 프로세스가 자원 획득했을떄 자원을 보장해준다.
			this.num++;
			
			if (this.num<=3) {
				System.out.println(name+" goal!!!!!!!!!!!!!!!!"+this.num + "등");
			}
		}
	}

	
	public void go() {
		for (int i = 0; i < h.length; i++) {
			h[i] = new horse();
			h[i].setTrack(this);
			h[i].setName(i+"horse");
		}
		
		for (int i = 0; i < h.length; i++) {
			h[i].start();
		}
		
	}
}
