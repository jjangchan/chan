package javaBasic0516;

import java.util.Random;
import java.util.Scanner;

public class project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in); 
		Random r=new Random();
		String[]word=new String[]{"ȣ��","���˸��帮��","�ٸ����γ�","�ޱ���"}; //��ǻ�Ͱ� �������� ������ �ܾ��
	    float sum1=0;// ���� �Է��� ����=�������� ���¼� �� ��
		float sum2=0;//Ʋ�� ����
	    float ct1=0; // ��Ȯ�� 
	    int[]fa=new int[word.length];
	    int total=0;
	    
		
	    for(int i=0;i<word.length;i++) {
	        int rd=r.nextInt(word.length);
	        if(fa[rd]==1) {
	        	i--;
	        	continue;
	        }
	        fa[rd]=1;
	    	String com=word[rd];
	    	String me=null;
	        
	        System.out.println(word[rd]); //������ ���� ���Ͽ� ��ǻ�Ͱ� ���� �ܾ�
	    	me=in.nextLine();      //���� �Է��� �ܾ�
	    	sum1=0;
	    	
		    for(int a=0;a<word[rd].length();a++) { 
		    	total++; 
		    	char imsi1=word[rd].charAt(a);
			     for(int b=0;b<me.length();b++) {
		         char imsi2=me.charAt(b);
			     if(imsi1==imsi2) {
			    	sum1++;
			        break;//ī����
		            }
			     
			     }
		    }
		    System.out.println(sum1);
		    if(me.equals("x")||me.equals("X")) {
		    	break;
		    }
		
		    ct1=sum1;
		}
	    System.out.println("��Ȯ��:"+ct1);//��Ȯ�� ��ġ
		System.out.println("Ʋ�� ���� :"+(total));
	    System.out.println("���� ����");
		
		
		

	
	
	}

}
