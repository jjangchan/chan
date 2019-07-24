package javaIO_Byre;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		FileInputStream fi = null; //byte 방식으로 jvm에서  외부로 input하는 객체변수
		FileOutputStream fo = null;
		Scanner in = new Scanner(System.in);
		
//		String targetFile = "test.txt";
//		try {
//		fo = new FileOutputStream(targetFile);
//		while(true) {
//			String memo = in.nextLine()+"\r\n";
//			if(memo.equals("x")) break;
//			fo.write(memo.getBytes());
//			fo.flush();
//			
//		}
//	} catch(Exception e) {
//		
//	}finally {
//		try {
//			if(fo != null) fo.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		try {
			fi = new FileInputStream("test1.txt");
			ArrayList<String> imsi1 = new ArrayList<>();
			ArrayList<String> imsi2 = new ArrayList<>();
		
			int k = 0;
			int i = 0;
		
			String id = "";
			byte[] readM = new byte[1023];
			
			while((k = fi.read(readM)) != -1) {
				
				id = new String(readM).trim();
			}
			System.out.println(id);
			
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

			
		
			
			
			
			
			


			
				
				
