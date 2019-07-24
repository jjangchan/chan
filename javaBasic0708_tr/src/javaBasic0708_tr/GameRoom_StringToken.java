package javaBasic0708_tr;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameRoom_StringToken {
	ArrayList<OneGame> myGame = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	int finalPoint = 0;
	String bonus = "sSdDtT";
	String option = "*#";

	GameRoom_StringToken() {
		menu();
		menu();
		menu();

		for (int i = 0; i < myGame.size(); i++) {
			finalPoint = finalPoint + myGame.get(i).cal();
		}
		System.out.println(finalPoint);
	}

	public int anaString(String a) {
		for (int i = 0; i < option.length(); i++) {
			String nowO = String.valueOf(option.charAt(i));
			if (nowO.equals(a)) {
				return 1;
			}
		}
		for (int i = 0; i < bonus.length(); i++) {
			String nowO = String.valueOf(bonus.charAt(i));
			if (nowO.equals(a)) {
				return 2;
			}
		}
		return 3;
	}

	public void menu() {

		int gameNum = myGame.size();
		System.out.println(gameNum + "번째 게임입니다.");

		OneGame o = new OneGame();
		System.out.println("점수입력 : ");
		String sample = in.nextLine();
		StringTokenizer s = new StringTokenizer(sample, "sdt*#", true);

		while (s.hasMoreTokens()) {
			String nowToken = s.nextToken();
			switch (anaString(nowToken)) {
			case 1:
				o.setAddOpion(nowToken);
				if (gameNum > 0 && nowToken.equals("*")) {
					myGame.get(gameNum - 1).setAddOpion(nowToken);
				}
				break;
			case 2:
				o.setBouns(nowToken);
				break;
			case 3:
				o.setPoint(Integer.valueOf(nowToken));
				break;
			}
		}

		myGame.add(o);

	}
}
