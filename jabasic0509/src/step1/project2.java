package step1;

import java.util.Random;
import java.util.Scanner;

public class project2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int mypoint=0;
		
		for(int i=0; i<3; i++) {
		
			int com = r.nextInt(4) + 1;
			int me = r.nextInt(4) + 1;
			int Dice = r.nextInt(4) + 1;
			System.out.println("1번을 누르고 엔터치세요");
			int a = in.nextInt();
			in.nextLine();
			
			
		

			
		
		}
		
		if(mypoint > 30) {
			System.out.println(mypoint+" / 최종적으로 내가 이김");
		}else {
			System.out.println(mypoint+" / 최종적으로 컴이 이김");
		}
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
