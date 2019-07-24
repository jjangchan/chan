package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_ex1 {

	public static void main(String[] args) {
		String src = "img/a.png";
		String target = "img/b.png";
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		
	    BufferedInputStream bfi = null;
	    BufferedOutputStream bfo = null;
	    
	    int n = 0;
	    int cnt = 0;
	    int tot = 0;
	    
	    try {
			fi = new FileInputStream(src);
			fo = new FileOutputStream(target);
			bfi = new BufferedInputStream(fi);
			bfo = new BufferedOutputStream(fo);
			
			byte buff[] = new byte[1024];
			
		
				while((n=bfi.read(buff)) != -1) {
					bfo.write(buff,0,n);
					bfo.flush();
					tot = tot+n;
					System.out.println(">>"+tot);
				}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}finally {
			try {
				if(bfi != null) bfi = null;
				if(bfo != null) bfo = null;
				if(fi != null) fi = null;
				if(fo != null) fo = null;
			} catch(Exception e) {
			      
			  }
		}

	}

}
