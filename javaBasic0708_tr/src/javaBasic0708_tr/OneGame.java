package javaBasic0708_tr;

import java.util.ArrayList;
import java.util.Scanner;

public class OneGame {
	Scanner in = new Scanner(System.in);
	private int point;
	private String bouns;
	private ArrayList<String> option = new ArrayList<>();
	private int mytotalpoint;
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getBouns() {
		return bouns;
	}
	public void setBouns(String bouns) {
		this.bouns = bouns;
	}
	public void setAddOpion(String op) {
		option.add(op);
	}
	
	public int cal() {
		switch(bouns) {
			case "s" :
			case "S" :mytotalpoint = (int)Math.pow(point, 1); break;
			case "d" :
			case "D" :mytotalpoint = (int)Math.pow(point, 2); break;
			case "t" :
			case "T" :mytotalpoint = (int)Math.pow(point, 3); break;
		}
		
		for(int i=0;i<option.size();i++) {
			switch(option.get(i)) {
			case "*" : mytotalpoint*=2;break;
			case "#" : mytotalpoint*=-1;break;
			}
		}
		return mytotalpoint;
	}
}
