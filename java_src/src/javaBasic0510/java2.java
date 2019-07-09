package javaBasic0510;

import java.util.Random;
import java.util.Scanner;

public class java2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건문
		//조건에따라 true->
		//          false->
		//if(조건){
		//   
		//}
		Scanner in=new Scanner(System.in);
		Random r=new Random();
		int a=0;
		System.out.println("1~45번중 한개를 선택하고 엔터치세요.");
	    int player=in.nextInt();
	    in.nextLine();
	    for(int i=0; i<1000;i++) {
	    	int ranhum=r.nextInt(45)+1;
	    	if(player==ranhum) {
	    		a++;
	    	}
	    	
	    }
	    System.out.println(a+"번 나왔어요.로또하실건가요");
	    
	    
		
		
			

		
		
	}

}
