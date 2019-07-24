package Step1;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {
	int sumS=0;
	int sumD=0;
	int sumT=0;
	
	private ArrayList<OneGame> gamelist;
	private ArrayList<String> totallist = new ArrayList<>();
	ArrayList<String> myOption;
	private Scanner in = new Scanner(System.in);
	private static Function fsingleton;
	public static Function getInstence() {
		if(fsingleton == null) {
			fsingleton = new Function();
		}
		return fsingleton;
	}
	
	private Function(){}
	
	private void cal() {
		
		String sumST = "";
		for(int i=0; i<gamelist.size();i++) {
			sumST = sumST+gamelist.get(i).getPoint() + gamelist.get(i).getBouns()+gamelist.get(i).getMyOption().get(0);
		}
		for(int i=0;i<gamelist.size();i++) {
			if("S".equals(gamelist.get(i).getBouns())) {
				sumS = gamelist.get(i).getPoint();
				sumS = (int)Math.pow(sumS, 1);
				gamelist.get(i).setPoint(sumS);
			}if("D".equals(gamelist.get(i).getBouns())){
				sumD = gamelist.get(i).getPoint();
				sumD = (int)Math.pow(sumD, 2);
				gamelist.get(i).setPoint(sumD);
			}if("T".equals(gamelist.get(i).getBouns())) {
				sumT = gamelist.get(i).getPoint();
				sumT = (int)Math.pow(sumT, 3);
				gamelist.get(i).setPoint(sumT);
			}
		}
		
		for(int i=0;i<gamelist.size();i++) {
			if("*".equals(gamelist.get(0).getMyOption().get(0)) && gamelist.get(i) == gamelist.get(0) ) {
				System.out.println(i);
				gamelist.get(0).setPoint(gamelist.get(0).getPoint()*2);
			}if("#".equals(gamelist.get(i).getMyOption().get(i))) {
				gamelist.get(i).setPoint(gamelist.get(i).getPoint()*-1);
			}if(gamelist.get(i) != gamelist.get(0)) {
				if("*".equals(gamelist.get(i).getMyOption().get(i))) {
					
					gamelist.get(i).setPoint(gamelist.get(i).getPoint()*2);
					gamelist.get(i-1).setPoint(gamelist.get(i-1).getPoint()*2);
				}
			}
		}
		int mypoint = gamelist.get(0).getPoint()+gamelist.get(1).getPoint()+gamelist.get(2).getPoint();
		

		
		totallist.add("다트 문자열 :" + sumST+"/ 다트 점수 총 합 :"+mypoint);
		
	}
	
	public void list() {
		for(int i=0;i<totallist.size();i++) {
			System.out.println(i+"회");
			System.out.println(totallist.get(i));
		}
	}
	
					
	public void add() {
		gamelist = new ArrayList<>();
		myOption = new ArrayList<>();
		int point;
		String bouns;
		String Option;
		
		for(int i=0; i<3;i++) {
			OneGame og = new OneGame();
			System.out.println("해당 점수 입력");
			point = in.nextInt();
			in.nextLine();
			og.setPoint(point);
			System.out.println("해당 보너스 입력");
			bouns = in.nextLine();
			og.setBouns(bouns);
			System.out.println("해당 옵션 입력");
			Option = in.nextLine();
			myOption.add(Option);
			og.setMyOption(myOption);
			gamelist.add(og);
		}
		
		cal();
		
	}


}
