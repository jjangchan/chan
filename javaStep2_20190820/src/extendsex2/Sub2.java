package extendsex2;

public class Sub2 extends SuperCls{

	
	Sub2(String name, int e){
		super(name,e);
	}
	
	@Override
	public void attack() {
		System.out.println("화살 날림");
	}
}
