package javaBasic0510;

import java.util.Random;
import java.util.Scanner;

public class java2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ǹ�
		//���ǿ����� true->
		//          false->
		//if(����){
		//   
		//}
		Scanner in=new Scanner(System.in);
		Random r=new Random();
		int a=0;
		System.out.println("1~45���� �Ѱ��� �����ϰ� ����ġ����.");
	    int player=in.nextInt();
	    in.nextLine();
	    for(int i=0; i<1000;i++) {
	    	int ranhum=r.nextInt(45)+1;
	    	if(player==ranhum) {
	    		a++;
	    	}
	    	
	    }
	    System.out.println(a+"�� ���Ծ��.�ζ��Ͻǰǰ���");
	    
	    
		
		
			

		
		
	}

}
