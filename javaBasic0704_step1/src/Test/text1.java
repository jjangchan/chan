package Test;

public class text1 {

	public static void main(String[] args) {
		/* 메세지 분석
		 * 
		 * String a = "/to abc : hi~!!!"
		 * String a = "/all  hi~!!"
		 */
		
		String checkword1 = " ";
		
		
		String a = "/to abc : hi~!!!";
//		String a = "/all hi~!!";
		
		int cnt=0;
		int k = a.indexOf(checkword1);
		
		for(int i=0; i<a.length();i++) {
			if(a.charAt(i)!=' ') {
				cnt++;
			}else {
				break;
			}
		}
		System.out.println(a.substring(0,cnt));
		System.out.println(a.substring(k+1,a.length()));
	}
	
}
		
		
