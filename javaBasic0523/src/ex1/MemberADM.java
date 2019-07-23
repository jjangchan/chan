package ex1;

import java.util.Scanner;

public class MemberADM {
		String[] userID=new String[5];
		String[] userPWD=new String[5];
		Scanner in=new Scanner(System.in);
		MemberADM(){ //생성자,생성자는 호출이 불가능하다
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
				default :System.out.println("잘못선택함");
				}
				
			}
			
		}
		public void menu() {
			System.out.println("------------------");
			System.out.println("-      1.등록            -");
			System.out.println("-      2.삭제            -");
			System.out.println("-      3.전체보기      -");
			System.out.println("-      4.종류            -");
			System.out.println("------------------");		
		}
		public void add() {
			for(int i=0;i<userID.length;i++) {
				if(userID[i]==null) {
					boolean idflag=true;
					String id=null;
					while(idflag) {
						System.out.println("ID 입력 :");
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
					
					// idflag =false >>안됨
					if(idflag==false) {
						userID[i]=id;
					}
					
					System.out.println("PWD 입력 :");
					String pwd=in.nextLine();
					userPWD[i]=pwd;
					break;
				}
			}
		}
		public void del() {
			System.out.println("삭제할 고객의 번호를 입력하세요.");
			int delnum=in.nextInt();
			in.nextLine();
			userID[delnum]=null;
			userPWD[delnum]=null;
		}
		public void list() {
			for(int i=0;i<userID.length;i++) {
				if(userID[i]!=null) {
					System.out.println(i+"번 고객"+userID[i]+"/"+userPWD[i]);
				}
			}
		}
}
					
				
					
					
		
		
		
		
		
		
		
		
		
					
		//메서드는 입력,기능수행,리턴 3가지기능이있다.
		
		
				
	
