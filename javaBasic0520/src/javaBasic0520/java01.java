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
		
		float subGamehit=0;   //�ܾ� �Ѱ��� ���� ��Ʈ
		float subGameavg=0;   //�ܾ� �Ѱ��� ���� ��Ȯ��
		
		for(int i=0; i<maxSize;i++) {
			int rNum=r.nextInt(maxSize);//word�� �ε����� ����
			if(wordchk[rNum]==1) {
				i--;
			}else {
				wordchk[rNum]=1;
				subGamehit=0; //�� �ܾ��� ��Ʈ�� �ʱ�ȭ
				String nowword=word[rNum];
				String inword= null; //���� ��������!
				System.out.println("���þ� :"+nowword);
				//���ڼ� ���� for��
//				for(;;) {
					inword=in.nextLine();
//					if(nowword.length() >=inword.length()) {
//						break;
//				    }else {
//				    	System.out.println("���ڼ� ���!");
//				    	
//				    }
//				}
					if(inword.equals("x")||inword.equals("X")) {
						break;
					}
						subGamehit=nowword.length()-inword.length();
						
					
					
					
			 	//��Ȯ�� ���
				
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
				System.out.println("��Ȯ�� :"+subGameavg);
				totalavg=(totalavg+subGameavg)/(i+1);
				System.out.println("��Ȯ��"+subGameavg+"/������� ���"+totalavg);
				
				
				
			}
			
			
		}
	
	
	
	
	
	
	}

}
