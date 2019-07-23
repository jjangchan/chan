package javaBasic0521;

public class java4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][]i=new int[4][5];
	int num1=1;
	


	//입력부
	for(int a=0;a<4;a++) {
		if(a%2==0) {
			for(int b=0;b<5;b++) {
				i[a][b]=num1;
				num1++;
			}
		}else {
			for(int b=4;b>=0;b--) {
				i[a][b]=num1;
				num1++;
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
