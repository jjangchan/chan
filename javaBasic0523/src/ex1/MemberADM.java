package ex1;

import java.util.Scanner;

public class MemberADM {
		String[] userID=new String[5];
		String[] userPWD=new String[5];
		Scanner in=new Scanner(System.in);
		MemberADM(){ //������,�����ڴ� ȣ���� �Ұ����ϴ�
			boolean flag=true;
			while(flag) {
				menu();
				list();
				String selmenu=in.nextLine();
				switch(selmenu) {
				case "1":add();break;
				case "2":del();break;
				case "3":list();break;
				case "4":flag = false; break;
				default :System.out.println("�߸�������");
				}
				
			}
			
		}
		public void menu() {
			System.out.println("------------------");
			System.out.println("-      1.���            -");
			System.out.println("-      2.����            -");
			System.out.println("-      3.��ü����      -");
			System.out.println("-      4.����            -");
			System.out.println("------------------");		
		}
		public void add() {
			for(int i=0;i<userID.length;i++) {
				if(userID[i]==null) {
					boolean idflag=true;
					String id=null;
					while(idflag) {
						System.out.println("ID �Է� :");
						id=in.nextLine();
						for(int idf=0;idf<userID.length;idf++) {
							//if(userID[idf]==id
							if(userID[idf]!=null) {
								if(userID[idf].equals(id)) {
									idflag=true;
									break;
								}
								
							}
							idflag=false;
							}
							
					}
					
					// idflag =false >>�ȵ�
					if(idflag==false) {
						userID[i]=id;
					}
					
					System.out.println("PWD �Է� :");
					String pwd=in.nextLine();
					userPWD[i]=pwd;
					break;
				}
			}
		}
		public void del() {
			System.out.println("������ ���� ��ȣ�� �Է��ϼ���.");
			int delnum=in.nextInt();
			in.nextLine();
			userID[delnum]=null;
			userPWD[delnum]=null;
		}
		public void list() {
			for(int i=0;i<userID.length;i++) {
				if(userID[i]!=null) {
					System.out.println(i+"�� ��"+userID[i]+"/"+userPWD[i]);
				}
			}
		}
}
					
				
					
					
		
		
		
		
		
		
		
		
		
					
		//�޼���� �Է�,��ɼ���,���� 3����������ִ�.
		
		
				
	
