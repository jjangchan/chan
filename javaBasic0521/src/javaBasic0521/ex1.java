package javaBasic0521;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int b1=0;
		
		for(int a=1;a<20;) {
			sum=sum+a;
			int imsi=a;
			a=imsi+b1;
			b1=imsi;
			System.out.println(a);
		}
		System.out.println(sum);
	
	}

}
