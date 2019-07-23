package book;

import java.sql.Timestamp;

public class MemberDTO {
	private int ISBN;
	private String name;
	private String author;
	private Timestamp reg_date;
	private String rent_id;

	public int getISBN() {
		return ISBN;
	}
	
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Timestamp getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getRent_id() {
		return rent_id;
	}
	
	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}
	
}