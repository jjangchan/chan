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
			default :System.out.println("잘못선택함");
			
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
			default :System.out.println("잘못선택함");
			
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
			default :System.out.println("잘못선택함");
			
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
			default :System.out.println("잘못선택함");
			
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
			default :System.out.println("잘못선택함");
			
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
			default :System.out.println("잘못선택함");
			
			}
			
		}
	}
    public void info01() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
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
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
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
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
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
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
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
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[4].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    
    				
    				
    				
    public void info06() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[0].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    				
    				
    				
    	
    public void info07() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[1].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    				
    public void info08() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[2].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    	
    public void info09() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[3].equals(detail[j][0])) {
    				System.out.println(detail[j][4]);
    			}
    		}
    	}
    }	
    		
    public void info10() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[4].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info11() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[0].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info12() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[1].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info13() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[2].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info14() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
    	if(event!=null&&detail!=null) {
    		for(int j=0;j<detail.length;j++) {
    			if(event[3].equals(detail[j][0])) {
    				System.out.println(detail[j][5]);
    			}
    		}
    	}
    }	
    
    public void info15() {
    	System.out.println("최종 업데이트 : 2019년 5월 23일");
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
    	System.out.println("1.등록     2.삭제      3.창닫기   |");
    	System.out.println("----------------------");
    	System.out.println("---------관심종목--------");	
    }
    public void menu2() {
    	System.out.println("-------------------------------------");
    	System.out.println("1.주가정보    2.투자자 별 거래 동향   3.뉴스  4.창닫기 |");
    	System.out.println("-------------------------------------");
    }
    
    public void add() {
    	for(int i=0;i<event.length;i++) {
    		if(event[i]==null) {
    			boolean frag=true;
    			String mye=null;
    			while(frag){
    				System.out.println("종목을 입력해주세요.");
    				mye=in.nextLine();
    				for(int come=0;come<detail.length;come++) {
    					if(detail[come][0].equals(mye)) {
    						for(int def=0;def<event.length;def++) {
    							if(event[def]!=null) {
    								if(event[def].equals(mye)) {
    									System.out.println("이미 등록된 종목입니다.");
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
    	System.out.println("삭제할 종목의 번호를 입력하세요.");
    	int del=in.nextInt();
    	in.nextLine();
    	event[del]=null;
    	
    }
    public void list(){
    	for(int i=0;i<event.length;i++) {
    		if(event[i]!=null) {
    			System.out.println(i+"번 종목 :"+event[i]+"/"+"정보 보기는 "+0+i+"를 눌러주세요.");
    			
    		}
    	}
    }
    
    public void date1() {
    	detail[0][0]="삼성전자";
    	detail[1][0]="현대건설";
    	detail[2][0]="대한방직";
    	detail[3][0]="셀트리온";
    	detail[4][0]="포스코케미칼";
    }
    public void date2() {
    	detail[0][1]="현재 주가 :43,850 ";
    	detail[1][1]="현재 주가 :50,700	";
    	detail[2][1]="현재 주가 :20,650 ";
    	detail[3][1]="현재 주가 :180,500 ";
    	detail[4][1]="현재 주가 :52,300 ";
    }
    public void date3() {
    	detail[0][2]="등락률 :+0.80%";
    	detail[1][2]="등락률 :+1.20%";
    	detail[2][2]="등락률 :0.00%";
    	detail[3][2]="등락률 :-2.17%";
    	detail[4][2]="등락률 :+3.16% ";
    }
    public void date4() {
    	detail[0][3]="거래량 :12,259,006";
    	detail[1][3]="거래량 :436,365";
    	detail[2][3]="거래량 :552,247";
    	detail[3][3]="거래량 :180,500 ";
    	detail[4][3]="거래량 :357,339 ";
    }
    public void date5() {
    	detail[0][4]="|     기관               |                 외국인                                                       |\r\n" + 
    			"---------------------------------------------------------------\r\n"+
    			"|   순매매량             |     순매매량        |      보유주수               |   보유율           |\r\n"+
    			"---------------------------------------------------------------\r\n"+ 
    			"|  -1,816,229  |  +3,264,084  |  3,416,252,764   |   57.23%   |\r\n"+
    			"---------------------------------------------------------------\r\n";
    	detail[1][4]="|     기관        |                 외국인                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   순매매량      |  순매매량        |    보유주수           |   보유율           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +77,929  |  -13,002  |  28,173,297  |   25.30%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[2][4]="|     기관        |                 외국인                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   순매매량      |  순매매량        |    보유주수           |   보유율           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +121,702 |    -8     |    49,984    |   0.94%    |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[3][4]="|     기관        |                 외국인                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   순매매량      |  순매매량        |    보유주수           |   보유율           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  -93,596  |  -78,139  |  25,571,303  |   19.93%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    	detail[4][4]="|     기관        |                 외국인                                        |\r\n" + 
    			"-----------------------------------------------------\r\n"+
    			"|   순매매량      |  순매매량        |    보유주수           |   보유율           |\r\n"+
    			"-----------------------------------------------------\r\n"+ 
    			"|  +61,293  |  +49,331  |  6,099,362   |   10.00%   |\r\n"+
    			"-----------------------------------------------------\r\n";
    }
    public void date6() {
    	detail[0][5]="뉴스 :美 `화웨이 제재`에…삼성전자 미소·하이닉스 긴장./ 관련 뉴스 링크:https://www.mk.co.kr/news/stock/view/2019/05/335194/ ";
    	detail[1][5]="뉴스 :현대건설, 이라크 3조 해수플랜트 수주./ 관련 뉴스 링크:https://www.mk.co.kr/news/realestate/view/2019/05/339463/"; 
    	detail[2][5]="뉴스 :대한방직, 자사주 300억 공개매수에 `상한가'./ 관련 뉴스 링크:https://www.mk.co.kr/news/stock/view/2019/05/339424/ ";
    	detail[3][5]="뉴스 :100만명 '바이오 빅데이터'만들고 신약 인허가 속도 높인다./ 관련 뉴스 링크:https://www.mk.co.kr/news/economy/view/2019/05/339472/ ";
    	detail[4][5]="뉴스 :중국 이어서 유럽도 친환경 정책!전기차 시대 만들어진다./ 관련 뉴스 링크:https://www.mk.co.kr/news/stock/view/2019/05/339428/ ";
    	
    }
}
    
    
    
    
    
    
    
    				
    	
    		
    				
    	
    	
    		
    		
        	
    	
    			
    			
    				
    
	
			
