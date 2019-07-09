package javaBasic0513;

public class forEx7 {

	public static void main(String[] args) {
		int max = 7;
		int center = max / 2 + 1;

		for (int i = 1; i <= max; i++) {
			int gap = Math.abs(center - i);
			//if(gap < 0) gap = gap*-1;
			for (int j = 1; j <= max-gap; j++) {
				if (j <= gap) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();

	}

}
}                                                                              