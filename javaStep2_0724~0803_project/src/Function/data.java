package Function;

import java.io.Serializable;
import java.util.ArrayList;

public class data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> broker;
	int[][] chart;

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
