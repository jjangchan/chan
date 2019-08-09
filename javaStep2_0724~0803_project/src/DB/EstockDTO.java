package DB;

import java.sql.Timestamp;

public class EstockDTO {
	private String name;
	private int price;
	private int priceS;
	private int priceL;
	private int priceH;
	private Timestamp day;
	
	
	public int getPriceS() {
		return priceS;
	}
	public void setPriceS(int priceS) {
		this.priceS = priceS;
	}
	public int getPriceL() {
		return priceL;
	}
	public void setPriceL(int priceL) {
		this.priceL = priceL;
	}
	public int getPriceH() {
		return priceH;
	}
	public void setPriceH(int priceH) {
		this.priceH = priceH;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getDay() {
		return day;
	}
	public void setDay(Timestamp day) {
		this.day = day;
	}
}
