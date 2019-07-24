package SampleCode;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDown {

	public static void main(String[] args) {
		String t="http://www.human.or.kr/theme/basic/img/human/qm_counsel.png";
		
		try {
			URL url = new URL(t);
			InputStream in = url.openStream();
			BufferedInputStream bi = new BufferedInputStream(in);
			
			FileOutputStream fo = new FileOutputStream("my.jpg");
			byte buff[] = new byte[1024];
			int imgData=0;
			int cnt=0;
			
			//이미지 정보 가져오기
			URLConnection conn = url.openConnection();
			int size = conn.getContentLength();
			System.out.println("image size :" +size);
			
			//이미지 다운로드 후 하드디스크 저장
			while((imgData = bi.read(buff))!=-1) {
				fo.write(buff,0,imgData); //사이즈에 맞게 맞춰서 0~번쨰에서 읽어온 만큼
				cnt += imgData;
				System.out.println(((cnt*100)/size)+"%");
				fo.flush();
			}
			in.close();
			bi.close();
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
