package C;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cstart {
	
	Cstart(){
		
		try {
			Socket client = new Socket("10.0.0.57",8888); //서버 접속 
			new Withserver(client);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
