package DAO;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		foodDAO dao = foodDAO.getInstance();
		
		foodDTO fooddto = new foodDTO();
		
		
		fooddto.setName(in.nextLine());
		fooddto.setPrice(in.nextInt());
		
		dao.insert(fooddto);
		
		
	}

}
