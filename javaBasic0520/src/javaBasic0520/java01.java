package javaBasic0520;

import java.util.Random;
import java.util.Scanner;

public class java01 {

	public static void main(String[] args) {
		String word[]=new String[] {"aaa","bbb","ccc"};
		int maxSize=word.length;
		int[] wordchk=new int[maxSize];
		Random r=new Random();
		Scanner in=new Scanner(System.in);
		
		float totalavg=0;
		
		float subGamehit=0;   //단어 한개에 대한 히트
		float subGameavg=0;   //단어 한개에 대한 정확도
		
		for(int i=0; i<maxSize;i++) {
			int rNum=r.nextInt(maxSize);//word의 인덱스가 범위
			if(wordchk[rNum]==1) {
				i--;
			}else {
				wordchk[rNum]=1;
				subGamehit=0; //각 단어의 히트를 초기화
				String nowword=word[rNum];
				String inword= null; //먼저 선언하자!
				System.out.println("제시어 :"+nowword);
				//글자수 제한 for문
//				for(;;) {
					inword=in.nextLine();
//					if(nowword.length() >=inword.length()) {
//						break;
//				    }else {
//				    	System.out.println("글자수 길다!");
//				    	
//				    }
//				}
					if(inword.equals("x")||inword.equals("X")) {
						break;
					}
						subGamehit=nowword.length()-inword.length();
						
					
					
					
			 	//정확도 계산
				
				for(int j=0;j<nowword.length();j++) {
					if(j<inword.length()) {
						char nowCut=nowword.charAt(j);
						char inCut=inword.charAt(j);
						
						if(nowCut==inCut) {
							subGamehit++;
					}
				    }
				}
				if(subGamehit<0) {
					subGamehit=0;
				}
				subGameavg=subGamehit/nowword.length()*100;
				System.out.println("정확도 :"+subGameavg);
				totalavg=(totalavg+subGameavg)/(i+1);
				System.out.println("정확도"+subGameavg+"/현재까지 평균"+totalavg);
				
				
				
			}
			
			
		}
	
	
	
	
	
	
	}

}
