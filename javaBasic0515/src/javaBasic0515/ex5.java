package javaBasic0515;

import java.util.Random;

public class ex5 {

	public static void main(String[] args) {
	Random r=new Random();
	int []a=new int[7];
	for(int i=0;i<a.length;i++) {
		int lotto=r.nextInt(7)+1;
			a[i]=lotto;
			for(int b=0;b<i;b++) {
				if(a[b]==lotto) {
					i--;
					break;
				}
			}
	}
	

	for(int i=0;i<a.length;i++) {
		if(i<4) {
			System.out.print(a[i]);
			System.out.print("/");
		}
	}
	System.out.print(a[5]+"+"+a[6]);
	
	
	
	
 }
}
