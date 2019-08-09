package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

import Function.data;

public class SendServer {
	Socket s;
	private InputStream is;
	private OutputStream os;
	private ObjectInputStream ois;
	Scanner in = new Scanner(System.in);
	String imsi;

	SendServer(Socket s) {
		this.s = s;

		try {
			
			os = s.getOutputStream();
			is = s.getInputStream();
		    receiveData();
//			sendData1();
//			receiveDataO();
			sendData();
//			send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendData() {
		try {
			String imsi1 = null;
			imsi1 = "신성이엔지";
			os.write(imsi1.getBytes());
			receiveDataO(true);
			send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void send() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						
						imsi = in.nextLine();
						os.write(imsi.getBytes());
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	private void receiveDataO(boolean frag) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				
				try {
					Socket s1 = new Socket("10.0.0.51",8881);
					InputStream i1 = s1.getInputStream();
				
					while(frag) {
						ois = new ObjectInputStream(i1);
						data d = null;
						d = (data) ois.readObject();
						ArrayList<String> broker = new ArrayList<>();
						int[][]chart;
						if((ArrayList<String>) d.getBroker()!=null) {
							broker = (ArrayList<String>) d.getBroker();
						System.out.println("============================");
						for (int i = 0; i < broker.size(); i++) {
							System.out.println(broker.get(i));
						}
						System.out.println("============================");
						}else {
							chart=(int[][])d.getChart();
							for (int i = chart.length - 1; i > -1; i--) {
								for (int z = 0; z <= 287; z++) {
									System.out.print(chart[i][z]);
								}
								System.out.println();
							}
						}
						
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	private void receiveData() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						byte[] buff = new byte[1024];
						is.read(buff);
						imsi = new String(buff).trim();
						System.out.println(imsi);
					}
				} catch(SocketException e) {
					closeall();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();

	}
	
	private void closeall() {
		try {
			System.out.println("close");
			os.close();
			is.close();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
