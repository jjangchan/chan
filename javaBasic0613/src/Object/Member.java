package Object;

import java.util.ArrayList;

public class Member {
	private String id = null;
	private String name = null;
	private ArrayList<Goods> mybasket = new ArrayList<>();

	
	
	public ArrayList<Goods> getMybasket() {
		return mybasket;
	}
	public void setMybasket(ArrayList<Goods> mybasket) {
		this.mybasket = mybasket;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
