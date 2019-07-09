package javaBasic0516;

import java.util.Random;
import java.util.Scanner;

public class project2 {

	public static void main(String[] args) {
		String fpn[] = { "우리형!", "패스마스터는?", "알리바바와 40인의 도적", "실룩셀룩 웃고있는", "나폴리 떄의 닝겐신" };
        String fp[] = { "호날두", "알론소", "알라바", "마르셀루", "카바니" }; // 배열의 값

		Scanner sc = new Scanner(System.in);

		Random r = new Random(); // 랜덤값

		int fp1[] = new int[5]; // 배열의 입력하는 걸 저장

		int no = 0; // 정확도 수치(틀린 문제 개수)

		int cyc = 0; // 단어 글자 수가 더 작은 것을 기준으로 비교해주는 변수

		System.out.println("축구선수들의 별명을 보고 이름 맞추시오! \n");

		for (int i = 0; i < fp.length; i++) {

			int fp2 = r.nextInt(fp.length);

			// 중복을 제거

			if (fp1[fp2] == 1) { // 문제가 중복이 안나오게 하는 것.

				i--;

				continue;// 중복이 나오면 다시 돌아간다.

			} else { // 중복이 아니면 값이 나옴

				fp1[fp2] = 1;

			}

			System.out.println(fpn[fp2]); // 랜덤하게 문제를 내는 코드

			String in = sc.nextLine(); // 입력한 걸 저장 값

			cyc = in.length();

			// x를 누르면 프로그램 종료

			if (in.equals("x")) { // x라고 입력하면

				System.out.println("종료");

				break; // 끝

				// 문자 길이

			} else if (fp[fp2].length() < cyc) {

				cyc = fp[fp2].length();

			}

			// 문제 정답, 오답 판별

			if (fp[fp2].equals(in)) { // 입력한 값을 비교하고 판단

				System.out.println("정답 \n"); // 맞으면 o

			} else {

				System.out.println("오답 \n"); // 틀리면 x

			}

			// 문제의 단어 틀린 개수

			for (int j = 0; j < cyc; j++) {

				if (fp[fp2].charAt(j) != in.charAt(j)) { // 문자열을 하나씩 끊어서 검사

					no++;

				}

			}

			no = no + Math.abs(in.length() - fp[fp2].length()); // 문자의 정답 길이

			// Math.abs = 절대값에서 빼는 것.

		}

		System.out.println("문자 틀린  개수 : " + no + "\n");

		System.out.println("끝났습니다!");

	}

}
