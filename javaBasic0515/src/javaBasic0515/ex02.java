package javaBasic0515;

import java.util.Random;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a=new int[7];
		Random r=new Random();
		
		//�迭 �Էº�
		
		for(int i=0; i<a.length;i++) {
			int lottoNum=r.nextInt(45)+1;
			a[i]=lottoNum;
		}
		//�迭 ��º�
		for(int i=0; i<a.length;i++) {
			System.out.println(i+"�� ��ȣ:"+a[i]);
		}

	}

}
