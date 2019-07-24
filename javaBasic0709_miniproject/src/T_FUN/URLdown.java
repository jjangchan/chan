package T_FUN;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import T_DB.DAO;
import T_DB.DTO;

public class URLdown {
	String taketurl = "http://www.human.or.kr:80";
	ArrayList<DTO> ulradm = new ArrayList<>();
	ArrayList<String> name = new ArrayList<>();
	DTO dto;
	DAO dao = DAO.getInstence();
	
 	public URLdown(){
		try {
			URL url = new URL(taketurl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String serchword = "jpg";
			String imsi = "";
			String imsi2 = "";
		
		
			int cnt = 1;
			
			while((imsi = br.readLine())!=null) {
				DTO adm = new DTO();
				cnt++;
				int fi = 0;
				int fi2 = 0;
				int k = imsi.indexOf(serchword);
//				System.out.println(cnt + ":"+imsi);
				if(k != -1) {
					
					for(int i=k;0<i; i--) {
						if(imsi.charAt(i)==':') {
							fi = i+1;
							break;
						}
					}
					adm.setUlradm(imsi.substring(fi-5,k+3));
					ulradm.add(adm);
					dao.insert(adm);
					imsi2 = imsi.substring(fi-5,k+3);
					int ii = imsi2.indexOf(serchword);
					for(int i=ii;0<i;i--) {
						if(imsi2.charAt(i)=='/') {
							fi2 =i+1;
							break;
						}
					}
					name.add(imsi2.substring(fi2));

					while(k != -1) {
						imsi = imsi.substring(k+4);
						k = imsi.indexOf(serchword);
						if(k!=-1) {
							for(int i=k;0<i; i--) {
								if(imsi.charAt(i)==':') {
									fi = i+1;
									break;
								}
							}
							adm.setUlradm(imsi.substring(fi-5,k+3));
							dao.insert(adm);
							ulradm.add(adm);
							imsi2 = imsi.substring(fi-5,k+3);
							ii = imsi2.indexOf(serchword);
							for(int i=ii;0<i;i--) {
								if(imsi2.charAt(i)=='/') {
									fi2 =i+1;
									break;
								}
							}
							name.add(imsi2.substring(fi2));
						}
					}
				}
			}
			
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i=0;i<ulradm.size();i++) {
//			System.out.println(ulradm.get(i).getUlradm());
//		}
//		for(int i=0;i<name.size();i++) {
//			System.out.println(name.get(i));
//		}
		down();
 	}
 	
 	public void down() {
 		for(int i=0;i<name.size();i++) {
 			try {
				URL url = new URL(ulradm.get(i).getUlradm());
				InputStream in = url.openStream();
				BufferedInputStream bi = new BufferedInputStream(in);
				
				FileOutputStream fo = new FileOutputStream(name.get(i));
				byte buff[]  = new byte[1024];
				int imgdata = 0;
				int cnt = 0;
				
				//이미지 정보 가져오기
				URLConnection conn = url.openConnection();
				int size = conn.getContentLength();
				System.out.println("image size :" +size);
				
				//이미지 다운로드 후 하드디스크 저장
				while((imgdata = bi.read(buff))!=-1) {
					fo.write(buff,0,imgdata); //사이즈에 맞게 맞춰서 0~번쨰에서 읽어온 만큼
					cnt += imgdata;
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
 	
 	
}

					


