package miniProject;

import java.util.Random;

public class horse extends Thread {
	track mytrack = null;

	public void setTrack(track t) {
		this.mytrack = t;
	}

	@Override
	public void run() {
		int dis = 0;
		Random r = new Random();
		String name = Thread.currentThread().getName();
		while (dis < 100) {
			dis += r.nextInt(5) + 1;
		}
		mytrack.setNum(name);
	}	
}
