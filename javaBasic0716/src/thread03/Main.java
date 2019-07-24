package thread03;

public class Main {
	public static int rank =0;
	public static void main(String[] args) {
	
			 Horse h1 = new  Horse();
			 Thread t1 = new Thread(h1);
			 t1.setName("1 번말 : 하플링거");
			 t1.start();
			 
			 Horse h2 = new  Horse();
			 Thread t2 = new Thread(h2);
			 t2.setName("2 번말 : 애팔루사");
			 t2.start();
			 
			 Horse h3 = new  Horse();
			 Thread t3 = new Thread(h3);
			 t3.setName("3 번말 : 서러브레드");
			 t3.start();
			 
			 Horse h4 = new  Horse();
			 Thread t4 = new Thread(h4);
			 t4.setName("4 번말 : 리피잔");
			 t4.start();
			 
			 Horse h5 = new  Horse();
			 Thread t5 = new Thread(h5);
			 t5.setName("5 번말 : 조랑말");
			 t5.start();
			 
	}
	
	public static void setfinal(String name) {
		rank++;
		if(rank<=3) {
			System.out.println(name+" : "+rank+"등");
		}
	}
	
}
			 
			
		

