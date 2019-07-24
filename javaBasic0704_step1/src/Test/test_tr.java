package Test;

public class test_tr {

	public static void main(String[] args) {
		
		String searchWord ="jpg";
		String a="Love is 'c:abc:a.jpg' i love you";
		int k = a.indexOf(searchWord);
		int sp=0;
		
		for(int j = k; j >0 ;j--) {
			if(a.charAt(j)=='\'') {
				sp=j+1;
				break;
			}
		}
		System.out.println(k);
		System.out.println(a.substring(1,3));
		System.out.println(a.substring(sp, k+3));
		

	}

}
