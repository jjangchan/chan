package javaBasic0521;

public class java2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][]i=new int[4][5];
	int num1=1;

	//입력부
	for(int b=0;b<5;b++) {
       for(int a=0;a<4;a++) {
			i[a][b]=num1;
			num1++;
			   		
		}
	}
	
	
	
	//출력부
      for(int a=0;a<4;a++) {
	     for(int b=0;b<5;b++) {
	 	   System.out.print(i[a][b]+"\t");
		}
		   System.out.println();
		}
	
	}
}
