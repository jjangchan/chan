package thread04_1;


public class Health1 {
	Cat1 cat[] = new Cat1[5];
	Health1(){
		thread();
	}
	
	public void  thread() {
		cat[0] = new Cat1();
		cat[0].getchk(this);
		Thread t1 = new Thread(cat[0]);
		t1.setName("����");
		
		cat[1] = new Cat1();
		cat[1].getchk(this);
		Thread t2 = new Thread(cat[1]);
		t2.setName("����ũ��");
		
		cat[2] = new Cat1();
		cat[2].getchk(this);
		Thread t3 = new Thread(cat[2]);
		t3.setName("��");
		
		cat[3] = new Cat1();
		cat[3].getchk(this);
		Thread t4 = new Thread(cat[3]);
		t4.setName("�ƽþ� ���");
		
		cat[4] = new Cat1();
		cat[4].getchk(this);
		Thread t5 = new Thread(cat[4]);
		t5.setName("�丣�þ�");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	public void setchk(String name, int cntH, int b) {
		System.out.println(name+" ����̴�  � Ƚ���� "+cntH+"�� �̰� �����Դ� "+b+"g");
	}
}
