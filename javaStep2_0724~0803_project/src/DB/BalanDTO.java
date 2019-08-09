package DB;

public class BalanDTO {
	private String id;
	private String event;
	private int totalM;
	private String totalC;
	private String yield;
	private int sell;
	private double buying;
	
	public double getBuying() {
		return buying;
	}
	public void setBuying(double buying) {
		this.buying = buying;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getTotalM() {
		return totalM;
	}
	public void setTotalM(int totalM) {
		this.totalM = totalM;
	}
	public String getTotalC() {
		return totalC;
	}
	public void setTotalC(String totalC) {
		this.totalC = totalC;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	
}
