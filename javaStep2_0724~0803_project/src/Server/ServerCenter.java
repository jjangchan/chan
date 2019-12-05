package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DB.DAO;
import DB.serverDTO;

public class ServerCenter {
	private ServerSocket server = null;
	private ArrayList<ServerSocket> serverT = new ArrayList<>();
	private ArrayList<Integer> portT = new ArrayList();
	private ArrayList<String> sT = new ArrayList<>();
	private ArrayList<serverDTO> listS = new ArrayList<>();
	private DAO dao = DAO.getInstence();
	private Socket socket = null;
	
	
	
	public ArrayList<Integer> getPortT() {
		return portT;
	}

	public ArrayList<ServerSocket> getServerT() {
		return serverT;
	}

	public ArrayList<String> getsT() {
		return sT;
	}

	public ServerCenter(){
		try {
			listS = dao.getListS();
			System.out.println(	listS.size());
			server = new ServerSocket();
			server.bind(new InetSocketAddress("10.0.0.51",8888));
			
			for(int i =0; i<listS.size();i++) {
				ServerSocket server1 = new ServerSocket();
				server1.bind(new InetSocketAddress("10.0.0.51",listS.get(i).getPort()));
				serverT.add(server1);
				sT.add(server1+"*"+listS.get(i).getEvent());
				portT.add(listS.get(i).getPort());
				System.out.println(sT.get(i)+"/"+portT.get(i));
			}
			net();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void net() {
		while(true) {
			try {
				System.out.println("서버 대기중");
				socket = server.accept();
				System.out.println("클라이언트 입장");
				SendClient sc = new SendClient(socket,this);
				sc.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
