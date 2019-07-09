package javaBasic0510;




public class java4 {

	public static void main(String[] args) {
		//1부터 100까지 더하는 프로그램을 작성하시오. 조건1. 홀수만 더하시오
				int sum=0;
				
				int c=0;
				
				for(int a=0;a<=100;a++) {
					 
				 if(a%2==1) {
						c=a;
						int simi=sum;
						sum=sum+a;
						System.out.println(simi+"+"+c+"="+sum);	
						}
				}
				
						
				
					
				//1부터 100까지 더하는 프로그램을 작성하시오.조건1. 홀수만 더하시오.조건2. 홀수이면서 3의 배수인 경우는 빼기를 하시오.
				  
		
	
	}
}	


