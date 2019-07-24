package Test;

public class test {

	public static void main(String[] args) {
		String serchword = "jpg";
		String a = "human 'c:date:a.jpg' i love you";
		String b = "'";
	    String e = "abc";
		char imsi2 = b.charAt(0);
//		int cnt1 = 0;
//		int cnt2 = 1;
//		int cnt3 = 0;
//	
		int c = a.indexOf(serchword);
		String d  = "humanabjklljkljkljd 'c:date:a.jpg' i love you 'c:date:a.jpg' good dsadasdasd 'c:date:a.jpg''c:date:a.jpg'";
		
		int c1 = d.indexOf(serchword);//������ ���ڿ�  index ��ȣ 
		
		while(c1 != -1) {
			c1 = d.indexOf(serchword);
			int cnt1 = 0;
			int cnt2 = 1;
			int cnt3 = 0;
			for(int i=0; i<d.length();i++) {
				char imsi = d.charAt(i);
				if(imsi==imsi2 ) {
					cnt1++;
				}else if(cnt1==1) {
					cnt3++;
					
				}else if(cnt1==0) {
					cnt2++;
				}
			}
			if(c1>-1) {
				System.out.println(d.substring(cnt2, cnt2+cnt3));
				d = d.substring(c1+4,d.length());
			}
		}
		
			
		
			
	
		
		
		
			
		
		
		
		
			
	
		
//		if(c != -1) {
//			for(int i=0; i<d.length();i++) {
//				char imsi = d.charAt(i);
//				if(imsi==imsi2 ) {
//					cnt1++;
//				}else if(cnt1==1) {
//					cnt3++;
//				}else if(cnt1==0) {
//					cnt2++;
//				}
//			}
//		}
//		System.out.println(d.substring(cnt2, cnt2+cnt3));
	
		
					
		


	}

}
