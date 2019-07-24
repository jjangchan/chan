package Test;

import java.util.ArrayList;

public class ex1 {
	

	public static void main(String[] args) {
		int cnt1 = 0;
		int cnt2 = 0;
		int b = 2;
		
		
//		while(cnt1<400) {
//			for(int i=0;i<10;i++) {
//				cnt2=cnt1+i;
//				for(int j=0;j<10;j++) {
//					System.out.println(cnt2);
//					cnt2=cnt2+2;
//				}
//				cnt1=cnt1+10;
//				cnt2=0;
//			}
//			cnt1++;
//		}
//		tr
		
		int result = 0;
		int[] a = new int[5001];
		char imsi='0';
		for(int i=1; i <= 5000; i++) {
			int nowNum = i;
			int sum=i;
			while(nowNum > 0) {
				sum = sum + nowNum%10;
				nowNum = nowNum/10;
			}
			if(sum <= 5000) {
				a[sum]=1;
			}
		}
		for(int i=1; i < a.length; i++) {
			if(a[i]!=1) {
				result = result + i;
			}
		}
		System.out.println(result);

	}

}
