package javaBasic0516;

import java.util.Random;
import java.util.Scanner;

public class project2 {

	public static void main(String[] args) {
		String fpn[] = { "�츮��!", "�н������ʹ�?", "�˸��ٹٿ� 40���� ����", "�Ƿ輿�� �����ִ�", "������ ���� �װս�" };
        String fp[] = { "ȣ����", "�˷м�", "�˶��", "��������", "ī�ٴ�" }; // �迭�� ��

		Scanner sc = new Scanner(System.in);

		Random r = new Random(); // ������

		int fp1[] = new int[5]; // �迭�� �Է��ϴ� �� ����

		int no = 0; // ��Ȯ�� ��ġ(Ʋ�� ���� ����)

		int cyc = 0; // �ܾ� ���� ���� �� ���� ���� �������� �����ִ� ����

		System.out.println("�౸�������� ������ ���� �̸� ���߽ÿ�! \n");

		for (int i = 0; i < fp.length; i++) {

			int fp2 = r.nextInt(fp.length);

			// �ߺ��� ����

			if (fp1[fp2] == 1) { // ������ �ߺ��� �ȳ����� �ϴ� ��.

				i--;

				continue;// �ߺ��� ������ �ٽ� ���ư���.

			} else { // �ߺ��� �ƴϸ� ���� ����

				fp1[fp2] = 1;

			}

			System.out.println(fpn[fp2]); // �����ϰ� ������ ���� �ڵ�

			String in = sc.nextLine(); // �Է��� �� ���� ��

			cyc = in.length();

			// x�� ������ ���α׷� ����

			if (in.equals("x")) { // x��� �Է��ϸ�

				System.out.println("����");

				break; // ��

				// ���� ����

			} else if (fp[fp2].length() < cyc) {

				cyc = fp[fp2].length();

			}

			// ���� ����, ���� �Ǻ�

			if (fp[fp2].equals(in)) { // �Է��� ���� ���ϰ� �Ǵ�

				System.out.println("���� \n"); // ������ o

			} else {

				System.out.println("���� \n"); // Ʋ���� x

			}

			// ������ �ܾ� Ʋ�� ����

			for (int j = 0; j < cyc; j++) {

				if (fp[fp2].charAt(j) != in.charAt(j)) { // ���ڿ��� �ϳ��� ��� �˻�

					no++;

				}

			}

			no = no + Math.abs(in.length() - fp[fp2].length()); // ������ ���� ����

			// Math.abs = ���밪���� ���� ��.

		}

		System.out.println("���� Ʋ��  ���� : " + no + "\n");

		System.out.println("�������ϴ�!");

	}

}
