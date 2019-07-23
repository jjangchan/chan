package javaBasic0521;

public class java1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]a=new int[4][5];
		int num=1;
		//입력부
		for(int i=0; i<4;i++) {
			for(int j=4;j>=0;j--) {
				a[i][j]=num;
				num++;
			
			}
		}
	
		//츨력부
		for(int i=0; i<4;i++) {
			for(int j=0;j<5;j++) {
				//System.out.println(i+"/"+j);
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	
	}
}
