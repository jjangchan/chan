package javaIO_Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileInputStream fi = null; //byte 방식으로 jvm에서  외부로 input하는 객체변수
		FileOutputStream fo = null;
		
		String targetFile = "test.txt";
		Scanner in = new Scanner(System.in);
		ArrayList<String> imsi = new ArrayList<>();
		//파일저장
//		try {
//			fo = new FileOutputStream(targetFile);
//			while(true) {
//				String memo = in.nextLine()+"\r\n";
//				if(memo.equals("x")) break;
//				fo.write(memo.getBytes());
//				fo.flush();
//				
//			}
//		} catch(Exception e) {
//			
//		}finally {
//			try {
//				if(fo != null) fo.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//파일 읽어오기 
		try {
			fi = new FileInputStream("test1.txt");
			
			int i = 0;
			int k = 0;
			
			char a;
			
			String b = "";
			String c = "";
			
			while((k = fi.read()) != -1) {
				i++;
				a = (char) k;
//				if(i<=5) {
//					b = b + a;
//				}
//				if(i>7 && i<13 ) {
//					c = c + a;
//				}
				
				b = b+a;
				if(k==49 ) {
					imsi.add(b);
				}else if(k==10) {
					b="";
				}
				System.out.println(k);

			
				
				
			}
			
//			imsi.add(b);
//			imsi.add(c);
			System.out.println(imsi.get(0));
			System.out.println(imsi.get(1));
			System.out.println(imsi.size());
			
			System.out.println(i + "번 읽었습니다. 총 :"+i+"byte");
		
		}catch(Exception e) {
			
		}finally {
			try {
				if(fo != null) fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
