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
import GUI.ADM;

public class SendServer {
	Socket s;
	private InputStream is;
	private OutputStream os;
	private ObjectInputStream ois;
	Scanner in = new Scanner(System.in);
	ADM a;
	String imsi;

	SendServer(Socket s) {
		this.s = s;
		a = ADM.getInstence();
		a.start(this);

		try {

			os = s.getOutputStream();
			is = s.getInputStream();
			receiveData();

//			sendData1();
//			receiveDataO();
//			sendData();
//			send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendData() {
		try {
			String imsi1 = null;
			imsi1 = "삼성전자";
			os.write(imsi1.getBytes());
			while (true) {
				imsi1 = in.nextLine();
				os.write(imsi1.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void send(String msg) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					os.write(msg.getBytes());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}

	private void receiveDataO(int port) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					Socket s1 = new Socket("10.0.0.51", port);
					InputStream i1 = s1.getInputStream();

					while (true) {
						ois = new ObjectInputStream(i1);
						data d = null;
						d = (data) ois.readObject();
						a.sendB(d);
						a.sendC(d);

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
						if ((imsi.charAt(0) + "").equals("@")) {
							String portS = imsi.substring(1);
							int port = Integer.parseInt(portS);
							receiveDataO(port);
						} else {
							a.sendG(imsi);
						}
					}

				} catch (SocketException e) {
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
