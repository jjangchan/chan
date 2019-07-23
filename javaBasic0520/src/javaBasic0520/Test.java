package javaBasic0520;

import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] word= new String[] {"aaa","bbb","ccc"};
		int maxSize=word.length;
		int[] wordChk=new int[maxSize];  // { 1 , 0, 0 }
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		float totalAvg=0;
		
		float subGameHit =0;  // 단어 한개에 대한 히트
		float subGameAvg =0;  // 단어 한개에 대한 정확도
		
		for(int i=0; i< wordChk.length; i++) {
			int rNum = r.nextInt(maxSize); // word의 인덱스가 범위
			//System.out.println(rNum+"번 방 단어 출력");
			if(wordChk[rNum]==1) {
				//System.out.println(rNum+"번은 이미 출력됨");
				i--;
			}else {
				//System.out.println(rNum+"번 단어는 : "+word[rNum]);
				wordChk[rNum]=1;
				    
				String nowWord = word[rNum];
				String inWord = null;
				System.out.println("제시어 : "+nowWord);
				
			//	for(;;) {
					inWord = in.nextLine();
			//		if(nowWord.length() >= inWord.length()) {
			//			break;
			//		}else {
			//			System.out.println("글자수 길다!");
			//		}
			//	}
				if(inWord.equals("x") || inWord.equals("X")) {
					break;
				}
	//			if(inWord.charAt(0)=='x') {
	//				break;
	//			}
				if(inWord.length()>nowWord.length()) {
					subGameHit = nowWord.length() - inWord.length(); 	
					}else {
						subGameHit=0; // 각 단어의 히트를 초기화
					}
				// 정확도 계산
				//System.out.println(nowWord+"/"+inWord+"비교중");
				
				for(int j=0; j < nowWord.length() ; j++) {
					if(j<inWord.length()) {
						char nowCut = nowWord.charAt(j);
						char inCut = inWord.charAt(j);
						
						if(nowCut == inCut) {
							subGameHit++;
						}
					}
				}
				if(subGameHit < 0) {
					subGameHit=0;
				}
				subGameAvg = (subGameHit/nowWord.length())*100;
				totalAvg = (totalAvg+subGameAvg)/(i+1);           
				System.out.println("정확도 : "+subGameAvg +"/ 현재까지 평균 :"+totalAvg);
				
			}
		}

	}

}
