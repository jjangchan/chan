package chan;

import java.util.Scanner;

public class Stockevent {
	String[]event=new String[5];
	String[][]detail=new String[5][6];
	Scanner in=new Scanner(System.in);
	
	Stockevent(){
		date1();
		boolean flag=true;
		while(flag) {
			menu1();
			list();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":add();break;
			case "2":del();break;
			case "3":flag= false;break;
			case "00":info1();break;
			case "01":info2();break;
			case "02":info3();break;
			case "03":info4();break;
			case "04":info5();break;
			default :System.out.println("�߸�������");
			
			}
		}
	}
		
	public void info1() {
		date2();
		date3();
		date4();
		date5();
		date6();
		
		boolean flag=true;
		while(flag) {
			menu2();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":info01();break;
			case "2":info06();break;
			case "3":info11();break;
			case "4":flag= false;break;
			default :System.out.println("�߸�������");
			
			}
			
		}
	}
			
	public void info2() {
		date2();
		date3();
		date4();
		date5();
		date6();
		
		boolean flag=true;
		while(flag) {
			menu2();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":info02();break;
			case "2":info07();break;
			case "3":info12();break;
			case "4":flag= false;break;
			default :System.out.println("�߸�������");
			
			}
			
		}
	}
	
	public void info3() {
		date2();
		date3();
		date4();
		date5();
		date6();
		
		boolean flag=true;
		while(flag) {
			menu2();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":info03();break;
			case "2":info08();break;
			case "3":info13();break;
			case "4":flag= false;break;
			default :System.out.println("�߸�������");
			
			}
			
		}
	}
	
	public void info4() {
		date2();
		date3();
		date4();
		date5();
		date6();
		
		boolean flag=true;
		while(flag) {
			menu2();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":info04();break;
			case "2":info09();break;
			case "3":info14();break;
			case "4":flag= false;break;
			default :System.out.println("�߸�������");
			
			}
			
		}
	}
	
	public void info5() {
		date2();
		date3();
		date4();
		date5();
		date6();
		
		boolean flag=true;
		while(flag) {
			menu2();
			String selnum=in.nextLine();
			switch(selnum) {
			case "1":info05();break;
			case "2":info10();break;
			case "3":info15();break;
			case "4":flag= false;break;
			default :System.out.println("�߸�������");
			
			}
			
		}
	}
    public void info01() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[0].equals(detail[j][0])) {
    				for(int k=0;k<4;k++) {
    					System.out.println(detail[j][k]);
    				}
    				
    			}
    		}
    	}
    }
    
    public void info02() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[1].equals(detail[j][0])) {
    				for(int k=0;k<4;k++) {
    					System.out.println(detail[j][k]);
    				}
    				
    			}
    		}
    	}
    }
    
    public void info03() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[2].equals(detail[j][0])) {
    				for(int k=0;k<4;k++) {
    					System.out.println(detail[j][k]);
    				}
    				
    			}
    		}
    	}
    }
    
    public void info04() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[3].equals(detail[j][0])) {
    				for(int k=0;k<4;k++) {
    					System.out.println(detail[j][k]);
    				}
    				
    			}
    		}
    	}
    }	
    
    public void info05() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[4].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    
    				
    				
    				
    public void info06() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[0].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    				
    				
    				
    	
    public void info07() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[1].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    				
    public void info08() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[2].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    	
    public void info09() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[3].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    		
    public void info10() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[4].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info11() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[0].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info12() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[1].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info13() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[2].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info14() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[3].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info15() {
    	System.out.println("���� ������Ʈ : 2019�� 5�� 23��");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[4].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    				
    				
    				
    public void menu1() {
    	System.out.println("----------------------");
    	System.out.println("1.���     2.����      3.â�ݱ�   |");
    	System.out.println("----------------------");
    	System.out.println("---------��������--------");	
    }
    public void menu2() {
    	System.out.println("-------------------------------------");
    	System.out.println("1.�ְ�����    2.������ �� �ŷ� ����   3.����  4.â�ݱ� |");
    	System.out.println("-------------------------------------");
    }
    
    public void add() {
    	for(int i=0;i<event.length;i++) {
    		if(event[i]==null) {
    			boolean frag=true;
    			String mye=null;
    			while(frag){
    				System.out.println("������ �Է����ּ���.");
    				mye=in.nextLine();
    				for(int come=0;come<detail.length;come++) {
    					if(detail[come][0].equals(mye)) {
    						for(int def=0;def<event.length;def++) {
    							if(event[def]!=null) {
    								if(event[def].equals(mye)) {
    									System.out.println("�̹� ��ϵ� �����Դϴ�.");
    									frag=true;
    									break;
    								}
    							}
    							frag=false;
    							
    						}
    					}
    					
    				}
    			}
    			if(frag==false) {
    				event[i]=mye;
    				break;
    			}
    		}
    		
    	}
    }
    
    public void del() {
    	System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
    	int del=in.nextInt();
    	in.nextLine();
    	event[del]=null;
    	
    }
    public void list(){
    	for(int i=0;i<event.length;i++) {
    		if(event[i]!=null) {
    			System.out.println(i+"�� ���� :"+event[i]+"/"+"���� ����� "+0+i+"�� �����ּ���.");
    			
    		}
    	}
    }
    
    public void date1() {
    	detail[0][0]="�Ｚ����";
    	detail[1][0]="����Ǽ�";
    	detail[2][0]="���ѹ���";
    	detail[3][0]="��Ʈ����";
    	detail[4][0]="�������ɹ�Į";
    }
    public void date2() {
    	detail[0][1]="���� �ְ� :43,850 ";
    	detail[1][1]="���� �ְ� :50,700	";
    	detail[2][1]="���� �ְ� :20,650 ";
    	detail[3][1]="���� �ְ� :180,500 ";
    	detail[4][1]="���� �ְ� :52,300 ";
    }
    public void date3() {
    	detail[0][2]="����� :+0.80%";
    	detail[1][2]="����� :+1.20%";
    	detail[2][2]="����� :0.00%";
    	detail[3][2]="����� :-2.17%";
    	detail[4][2]="����� :+3.16% ";
    }
    public void date4() {
    	detail[0][3]="�ŷ��� :12,259,006";
    	detail[1][3]="�ŷ��� :436,365";
    	detail[2][3]="�ŷ��� :552,247";
    	detail[3][3]="�ŷ��� :180,500 ";
    	detail[4][3]="�ŷ��� :357,339 ";
    }
    public void date5() {
    	detail[0][4]="|     ���               |                 �ܱ���                                                       |\r\n" + 
    			"---------------------------------------------------------------\r\n"+
    			"|   ���Ÿŷ�             |     ���Ÿŷ�        |      �����ּ�               |   ������           |\r\n"+
    			"---------------------------------------------------------------\r\n"+ 
    			"|  -1,816,229  |  +3,264,084  |  3,416,252,764   |   57.23%   |\r\n"+
    			"---------------------------------------------------------------\r\n";
    	detail[1][4]="|     ���        |                 �ܱ���                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   ���Ÿŷ�      |  ���Ÿŷ�        |    �����ּ�           |   ������           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +77,929  |  -13,002  |  28,173,297  |   25.30%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[2][4]="|     ���        |                 �ܱ���                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   ���Ÿŷ�      |  ���Ÿŷ�        |    �����ּ�           |   ������           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +121,702 |    -8     |    49,984    |   0.94%    |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[3][4]="|     ���        |                 �ܱ���                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   ���Ÿŷ�      |  ���Ÿŷ�        |    �����ּ�           |   ������           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  -93,596  |  -78,139  |  25,571,303  |   19.93%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[4][4]="|     ���        |                 �ܱ���                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   ���Ÿŷ�      |  ���Ÿŷ�        |    �����ּ�           |   ������           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +61,293  |  +49,331  |  6,099,362   |   10.00%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    }
    public void date6() {
    	detail[0][5]="���� :ڸ `ȭ���� ����`�����Ｚ���� �̼ҡ����̴н� ����./ ���� ���� ��ũ:https://www.mk.co.kr/news/stock/view/2019/05/335194/ ";
    	detail[1][5]="���� :����Ǽ�, �̶�ũ 3�� �ؼ��÷�Ʈ ����./ ���� ���� ��ũ:https://www.mk.co.kr/news/realestate/view/2019/05/339463/"; 
    	detail[2][5]="���� :���ѹ���, �ڻ��� 300�� �����ż��� `���Ѱ�'./ ���� ���� ��ũ:https://www.mk.co.kr/news/stock/view/2019/05/339424/ ";
    	detail[3][5]="���� :100���� '���̿� ������'����� �ž� ���㰡 �ӵ� ���δ�./ ���� ���� ��ũ:https://www.mk.co.kr/news/economy/view/2019/05/339472/ ";
    	detail[4][5]="���� :�߱� �̾ ������ ģȯ�� ��å!������ �ô� ���������./ ���� ���� ��ũ:https://www.mk.co.kr/news/stock/view/2019/05/339428/ ";
    	
    }
}
    
    
    
    
    
    
    
    				
    	
    		
    				
    	
    	
    		
    		
        	
    	
    			
    			
    				
    
	
			
