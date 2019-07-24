package SampleCode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLex {

	public static void main(String[] args) {
		String testUrl = "http://www.human.or.kr:80";
		//프로토콜(protocal), hostname(호스트 이름), 포토번호(portnumber)
		//서비스 방식                                                                        서비스번호
		
		try {
			URL url = new URL(testUrl);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			
			InputStream ins = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ins));
			
			String str ="";
			int cnt=1;
			while((str = br.readLine()) != null) {
				System.out.println(cnt + " :"+str);
				cnt++;
			}
			br.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
