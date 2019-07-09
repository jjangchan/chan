package javaBasic0513;

public class forEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		for(int a=1; a<5;a++) {
			for(int b=4; b>0;b--) {
				if(b>a) {
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
				
			}
			
			for(int c=2; c<5; c++) {
				if(c>a) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
			}
		for(int a=1;a<4;a++) {
			for(int b=1;b<5;b++) {
				if(a<b) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
            for(int c=3;c>0;c--) {
            	if(c>a) {
            		System.out.print("*");
            	}else {
            		System.out.print(" ");
            	}
            }
            System.out.println();
		}

		
		
		
	
		
		
 
	
	
	
	}
}	


	
	
	
	
	

