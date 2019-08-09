package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	client(){
		try {
			Socket client = new Socket("10.0.0.51",8888);
			new SendServer(client);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
