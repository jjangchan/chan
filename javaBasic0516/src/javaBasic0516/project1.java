package javaBasic0516;

import java.util.Random;
import java.util.Scanner;

public class project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in); 
		Random r=new Random();
		String[]word=new String[]{"호우","레알마드리드","바르셀로나","메구토"}; //컴퓨터가 랜덤으로 나오는 단어수
	    float sum1=0;// 내가 입력한 글자=랜덤으로 나온수 의 값
		float sum2=0;//틀린 갯수
	    float ct1=0; // 정확도 
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
	        
	        System.out.println(word[rd]); //랜덤의 수로 인하여 컴퓨터가 나온 단어
	    	me=in.nextLine();      //내가 입력한 단어
	    	sum1=0;
	    	
		    for(int a=0;a<word[rd].length();a++) { 
		    	total++; 
		    	char imsi1=word[rd].charAt(a);
			     for(int b=0;b<me.length();b++) {
		         char imsi2=me.charAt(b);
			     if(imsi1==imsi2) {
			    	sum1++;
			        break;//카운터
		            }
			     
			     }
		    }
		    System.out.println(sum1);
		    if(me.equals("x")||me.equals("X")) {
		    	break;
		    }
		
		    ct1=sum1;
		}
	    System.out.println("정확도:"+ct1);//정확도 수치
		System.out.println("틀린 갯수 :"+(total));
	    System.out.println("게임 종류");
		
		
		

	
	
	}

}
