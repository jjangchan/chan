package fishs;

import java.awt.Image;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

public class FishCenter {
	
	
	private Image myfish = null;
	
	private int x = 0;
	private int y = 0;
	private int speed = 10;
	private int width = 0;
	private int height = 0;
	private int RL = -1;
	private int score = 0;
	private int lv = 1;
	
	String imgName1 = null;
	String imgName2 = null;
	
	private boolean endflag = false;

	FishCenter(int x, int y, String name,int speed,int score, int lv ) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
		this.lv = lv;
		StringTokenizer st = new StringTokenizer(name,"@");
		imgName1 = st.nextToken();
		imgName2 = st.nextToken();

		myfish = new ImageIcon(imgName1).getImage();
		this.width = myfish.getWidth(null);
		this.height = myfish.getHeight(null);

	}
	
	

	public boolean isEndflag() {
		return endflag;
	}

	public void setEndflag(boolean endflag) {
		this.endflag = endflag;
	}

	public int getLv() {
		return lv;
	}




	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getRL() {
		return RL;
	}


	public void setRL(int rL) {
		RL = rL;
	}


	public Image getMyfish() {
		if(RL==2) {
			myfish = new ImageIcon(imgName2).getImage();
			return myfish;

		}else {
			myfish = new ImageIcon(imgName1).getImage();
			return myfish;
			
		}
	}
	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
