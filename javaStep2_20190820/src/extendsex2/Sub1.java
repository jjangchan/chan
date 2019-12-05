package extendsex2;

public class Sub1 extends SuperCls{
	
	
	Sub1(String name, int e){
		super(name,e);
	}

	@Override
	public void attack() { //어노테이션(annotation),메소드를 재정의
		System.out.println("미사일 날림");
		
	}
	
}
