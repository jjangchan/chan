package javaBasic0515;

import java.util.Random;

public class ex03 {

	public static void main(String[] args) {
		Random r=new Random();
		int[]a=new int[7];
		
		for(int i=0;i<a.length;i++) {
			int lotto=r.nextInt(45)+1;
			if(lotto%2==0) {
				a[i]=lotto*10;
			}else {
				a[i]=lotto;
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(i+"¹ø ¹øÈ£ :"+a[i]);
		}

	}

}
