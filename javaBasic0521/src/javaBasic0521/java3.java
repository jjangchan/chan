package javaBasic0521;

public class java3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][]i=new int[4][5];
	int num=1;
	int num1=10;
	int num2=11;
	int num3=20;

	//입력부
	for(int a=0;a<4;a++) {
		for(int b=0;b<5;b++) {
			if(a==0) {
				i[a][b]=num;
				num++;
			}
			if(a==1) {
				i[a][b]=num1;
				num1--;
	        }
			if(a==2) {
				i[a][b]=num2;
				num2++;
	        }
			if(a==3) {
				i[a][b]=num3;
				num3--;
	        }
			
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
