package DTO;

import java.sql.Timestamp;

public class JobDTO {
	
	private String id;
	private String com;
	private String why;
	private String chal;
	private String adv;
	private Timestamp day;
	
	public void setDay(Timestamp day) {
		this.day = day;
	}
	public Timestamp getDay() {
		return day;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	public String getChal() {
		return chal;
	}
	public void setChal(String chal) {
		this.chal = chal;
	}
	public String getAdv() {
		return adv;
	}
	public void setAdv(String adv) {
		this.adv = adv;
	}
	
	

}
