package goods;

import java.util.ArrayList;

public class goods2 {
	ArrayList<String> glist=new ArrayList<String>();
	private static goods2 gSingleton=null;
	public static goods2 getinstance() {
		if(gSingleton==null) {
			gSingleton=new goods2();
		}
		return gSingleton;
	}
	
	
	private goods2(){
		init();
	}
	public ArrayList<String> getGlist() {
		return glist;
	}
	
	private void init() {
		glist.add("banana");
		glist.add("apple");
		glist.add("aaa");
	}

}
