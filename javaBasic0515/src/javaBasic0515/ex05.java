package javaBasic0515;

import java.util.Random;

public class ex05 {

	public static void main(String[] args) {
		Random r=new Random();
		int[]a=new int[7];
		for(int b=0;b<=4;b++) {
			for(int i=0;i<a.length;i++) {
				int lotto=r.nextInt(45)+1;
				a[i]=lotto;
			}
			for(int i=0;i<a.length;i++) {
				if(i<4) {
					System.out.print(a[i]);
					System.out.print("/");
				}
			}
			System.out.println(a[5]+"+"+a[6]);
		}
		

	}

}
