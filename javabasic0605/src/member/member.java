package member;

public class member {
	String id=null; //id ���� ����
	String pwd=null;//pwd ���� ����
	
	public void input(String sid) {  //sid�� ������ �Է¹޾� id��� ������ ����
		id=sid;
	}
	public void prt() { //���� ��ü�� �����ϰ� �ִ� id��pwd�� ���
		System.out.println(id+"/"+pwd);
	}

}
