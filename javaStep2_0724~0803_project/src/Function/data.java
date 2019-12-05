package Function;

import java.io.Serializable;
import java.util.ArrayList;

public class data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> broker;
	private int[][] chart;
	private String event;
	private int row;
	private int centerP;
	
	
	public int getCenterP() {
		return centerP;
	}

	public void setCenterP(int centerP) {
		this.centerP = centerP;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getevent() {
		return event;
	}

	public void setevent(String event) {
		this.event = event;
	}

	public int[][] getChart() {
		return chart;
	}

	public void setChart(int[][] chart) {
		this.chart = chart;
	}

	public ArrayList<String> getBroker() {
		return broker;
	}

	public void setBroker(ArrayList<String> broker) {
		this.broker = broker;
	}
}
