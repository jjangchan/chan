package Test1;

import java.util.Random;
import java.util.Scanner;

public class a1112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		Random r = new Random();  //ctrl + shift + ¾ËÆÄºªo
		int com=r.nextInt(3)+1;
		//System.out.println(com);
		System.out.println("1:°¡À§, 2:¹ÙÀ§, 3:º¸ ¼±ÅÃÇÏ¼¼¿ä>");
		int a = in.nextInt();
		
		System.out.println("com:"+com+"/³ª:"+a);
		//Á¶°Ç ==    >=    <=  >  <   !=
		//¼ö¸¹Àº ¹æ¹ýÀÌ ÀÖ´Ù.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(a==1) {
		    if(com==2) {
				System.out.println("Áü");
			}else {
				if(com==1) {
					System.out.println("ºñ±è");
				}else {
					System.out.println("ÀÌ±è");
				}
			}
		}
		if(a==2) {
			if(com==2) {
				System.out.println("ºñ±è");
			}else {
				if(com==3) {
					System.out.println("Áü");
				}else {
					System.out.println("ÀÌ±è");
				}
			}
		}
		if(a==3) {
			if(com==3) {
				System.out.println("ºñ±è");
			}else {
				if(com==2) {
					System.out.println("ÀÌ±è");
				}else {
					System.out.println("Áü");
				}
			}
		}
				
 
	
	
	
	
	
	}
}
