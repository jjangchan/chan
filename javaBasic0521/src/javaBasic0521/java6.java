package javaBasic0521;

public class java6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][]i=new int[4][5];
	int num=1;
	int num2=12;
	int row_min=0;
	int row_max=3;
	int col_min=0;
	int col_max=4;
	
	//입력부
	for(int col=col_min;col<=col_max;col++) {
		i[row_min][col]=num++;
	}
	row_min++;
	for(int row=row_min;row<=row_max;row++) {
		i[row][col_max]=num;
		num++;
	}
	col_max--;
	for(int col=col_max;col>=col_min;col--) {
		i[row_max][col]=num;
		num++;
	}
	row_max--;
	for(int row=row_max;row>=row_min;row-- ) {
		i[row][col_min]=num++;
	}
	
	
	
//	for() {
//		
//	}

		
	
	
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
