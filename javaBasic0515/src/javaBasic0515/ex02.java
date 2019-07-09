package javaBasic0515;

import java.util.Random;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a=new int[7];
		Random r=new Random();
		
		//배열 입력부
		
		for(int i=0; i<a.length;i++) {
			int lottoNum=r.nextInt(45)+1;
			a[i]=lottoNum;
		}
		//배열 출력부
		for(int i=0; i<a.length;i++) {
			System.out.println(i+"번 번호:"+a[i]);
		}

	}

}
