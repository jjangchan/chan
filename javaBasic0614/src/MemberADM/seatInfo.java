package MemberADM;

import java.util.Scanner;

import Info.MADM;
import Object.Seat;


public class seatInfo {
	private static seatInfo ssingleton = null;
	seatInfo(){}
	Scanner in = new Scanner(System.in);
	Seat[]sN = new Seat[10];
	int mynum;
	String myn;
	private MADM mp = null;
	private Seat ps = new Seat();
	
	
	public static seatInfo getInstence() {
		if(ssingleton == null) {
			ssingleton = new seatInfo();
		}
		return ssingleton;
	}
	
	public void Sadd() {
		boolean chk = true;
		while(chk) {
			System.out.println("�ɰ� ���� 0�� �ڸ�~9�� �ڸ� �� �����ϼ���.");
			mynum = in.nextInt();
			in.nextLine();
			if(mynum<=9) {
				if(sN[mynum] == null) {
					sN[mynum] = new Seat();
	                ps.setSeatI(mynum);			
					System.out.println("������ �Է����ּ���");
					myn = in.nextLine();
					ps.setSeatN(myn);
					
					chk = false;
				}else {
					System.out.println("�̹� �ִ� �ڸ��Դϴ�.");
				}
			}else {
				System.out.println("0~9�� �� �������ּ���");
			}
		}
    }
	
	public void Sout() {
		System.out.println("��� �� ���̺� ��ȣ�� �Է����ּ���.");
		mynum = in.nextInt();
		for(int i=0;i<sN.length;i++) {
			if(sN[i] != null) {
				System.out.println(sN[i].getSeatI()+" / "+sN[i].getSeatN());
			}else {
				System.out.println("���� �Ͻ� ���̺��� ����ִ� �ڸ��Դϴ�.");
				break;
			}
		}
		sN[mynum] = null;
	}
	
	private void Slist() {
		for(int i=0;i<sN.length;i++) {
			if(sN[i] != null) {
				System.out.println(sN[i].getSeatI()+" / "+sN[i].getSeatN());
			}
		}
	}
	
	public void Smy() {
	    Slist();
		System.out.println("�ֹ� �� �¼��� �������ּ���");
		mynum = in.nextInt();
		in.nextLine();
		sN[mynum] = mp.Mprocess();
	}
	
			
	
	
				
	
			

}
