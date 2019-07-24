package LottoC;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LottoStartC {
	Socket client = null;
	LottoStartC() {
	
		try {
			client = new Socket("10.0.0.54", 8888);
			new WithServerLottoC(client);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}

}
