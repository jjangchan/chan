package Table;

public class Onemenuinfo {
	private int oneMenuFlag = -1;
	private String menuName = null;
	private int cnt = 0;
	private int menuPrice = 0;
	
	public void prt() {
		System.out.println("�ֹ��Ͻ� �޴� ��ȣ :"+oneMenuFlag);
		System.out.println("�ֹ��Ͻ� �޴� �̸� :"+menuName);
		System.out.println("�ֹ��Ͻ� �޴� ���� :"+menuPrice);
		System.out.println("�ֹ��Ͻ� �޴� ���� :"+cnt);
	}
	
	public int getOneMenuFlag() {
		return oneMenuFlag;
	}
	public void setOneMenuFlag(int oneMenuFlag) {
		this.oneMenuFlag = oneMenuFlag;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

}
