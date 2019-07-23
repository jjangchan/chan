package javaBasic0521;

public class java5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][]i=new int[4][5];
	
	int num2=1;
	//입력부
	for(int a=0;a<1;a++) {
		for(int b=0;b<5;b++) {
			i[a][b]=num2;
			num2++;
		}
	}
	
	for(int b=4;b<5;b++) {
		for(int a=0;a<4;a++) {
			i[a][b]=num2-1;
			num2++;
		}
	}
	
	for(int a=3;a<4;a++) {
		for(int b=3;b>=0;b--) {
			i[a][b]=num2-1;
			num2++;
		}
	}
	
	for(int b=0;b<1;b++) {
		for(int a=2;a>=1;a--) {
			i[a][b]=num2-1;
			num2++;
		}
	}
	
	for(int a=1;a<3;a++) {
		if(a==1) {
			for(int b=1;b<4;b++) {
				i[a][b]=num2-1;
				num2++;
			}
		}else {
			for(int b=3;b>=1;b--) {
				i[a][b]=num2-1;
				num2++;
			}
		}
	}
	
		
	
	
	//출력부
	for(int a=0; a<4;a++) {
		for(int b=0;b<5;b++) {
			//System.out.println(i+"/"+j);
			System.out.print(i[a][b]+"\t");
		}
		System.out.println();
	}

	}
}
