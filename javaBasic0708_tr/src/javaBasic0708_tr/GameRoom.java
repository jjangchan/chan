package javaBasic0708_tr;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRoom {
	ArrayList<OneGame> myGame = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	int finalPoint = 0;
	GameRoom() {
		menu();
		menu();
		menu();
		System.out.println(myGame.size());
		for(int i=0; i<myGame.size(); i++) {
			finalPoint = finalPoint + myGame.get(i).cal();
		}
		System.out.println(finalPoint);
	}

	public void menu() {

		int gameNum = myGame.size();
		System.out.println(gameNum + "번째 게임입니다.");

		OneGame o = new OneGame();
		System.out.println("점수입력 : ");
		int p = in.nextInt();
		in.nextLine();

		System.out.println("보너스 입력 <s, d, t >:");
		String b = in.nextLine();

		System.out.println("옵션 < * , # >:");
		String op = in.nextLine();
		
		if(gameNum > 0 && op.equals("*")) {
			myGame.get(gameNum-1).setAddOpion(op);
		}

		o.setPoint(p);
		o.setBouns(b);
		o.setAddOpion(op);
		myGame.add(o);

	}
}
