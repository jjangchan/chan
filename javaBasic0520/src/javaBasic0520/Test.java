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
		
		float subGameHit =0;  // �ܾ� �Ѱ��� ���� ��Ʈ
		float subGameAvg =0;  // �ܾ� �Ѱ��� ���� ��Ȯ��
		
		for(int i=0; i< wordChk.length; i++) {
			int rNum = r.nextInt(maxSize); // word�� �ε����� ����
			//System.out.println(rNum+"�� �� �ܾ� ���");
			if(wordChk[rNum]==1) {
				//System.out.println(rNum+"���� �̹� ��µ�");
				i--;
			}else {
				//System.out.println(rNum+"�� �ܾ�� : "+word[rNum]);
				wordChk[rNum]=1;
				    
				String nowWord = word[rNum];
				String inWord = null;
				System.out.println("���þ� : "+nowWord);
				
			//	for(;;) {
					inWord = in.nextLine();
			//		if(nowWord.length() >= inWord.length()) {
			//			break;
			//		}else {
			//			System.out.println("���ڼ� ���!");
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
						subGameHit=0; // �� �ܾ��� ��Ʈ�� �ʱ�ȭ
					}
				// ��Ȯ�� ���
				//System.out.println(nowWord+"/"+inWord+"����");
				
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
				System.out.println("��Ȯ�� : "+subGameAvg +"/ ������� ��� :"+totalAvg);
				
			}
		}

	}

}
