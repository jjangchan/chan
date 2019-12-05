package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Pevent extends JFrame implements ListSelectionListener , ActionListener{

	private static final int PLAIN_MESSAGE = 0;
	private JPanel contentPane;
	private TextArea textField;
	private JList<String> jlist;
	private int[][] chart;
	private ArrayList<String> broker;
	private int row;
	private ArrayList<Integer> centerP = new ArrayList<>();
	private String chartS = "";
	private mycanvas mc = new mycanvas();
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	String event;
	String taketprice="";
	public ArrayList<String> getBroker() {
		return broker;
	}

	public void setBroker(ArrayList<String> broker) {
		this.broker = broker;
	}

	public String getEvent() {
		return event;
	}

	public Pevent(String event) {
		this.event = event;
		p();
	}

	public void info(int[][] chart, int row, int c) {
		this.chart = chart;
		this.row = row;
		centerP.add(c);
		chart();
	}

	public Pevent() {

	}

	private void p() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(22, 10, 279, 30);
		contentPane.add(lblNewLabel);

		textField = new TextArea(null, MAXIMIZED_BOTH, MAXIMIZED_HORIZ, TextArea.SCROLLBARS_HORIZONTAL_ONLY) {
			private static final long serialVersionUID = 1L;
		};
		// textField.setBounds(22, 50, 518, 290);
		textField.setBounds(22, 290, 300, 22);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("매도");
		btnNewButton.setBounds(238, 350, 97, 30);
		contentPane.add(btnNewButton);

		button = new JButton("매수");
		button.setBounds(86, 350, 97, 30);
		contentPane.add(button);

		button_1 = new JButton("뒤로가기");
		button_1.setBounds(385, 350, 97, 30);
		contentPane.add(button_1);

		JPanel panel = new JPanel();
		panel.setBounds(22, 50, 300, 278);
		contentPane.add(panel);

		jlist = new JList<String>();
		jlist.setBounds(343, 50, 200, 240);
		contentPane.add(jlist);

		panel.add(mc);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addListSelectionListener((ListSelectionListener) this);
		btnNewButton.addActionListener(this);
		button_1.addActionListener(this);
		button.addActionListener(this);
	}
	


	public void chart() {
		for (int i = chart.length - 1; i > -1; i--) {
			for (int z = 0; z <= row; z++) {
				chartS = chartS + chart[i][z];
			}
			chartS = chartS + "\r\n";
		}
		textField.setText(chartS);
		chartS = textField.getText();
		mc.repaint();
	}

	public void jjlist(ArrayList<String> broker) {
		String[] newlist = new String[broker.size()];
		for (int i = 4; i < broker.size() - 4; i++) {
			newlist[i] = broker.get(i);
		}
		jlist.setListData(newlist);
	}

	class mycanvas extends Canvas {
		public mycanvas() {
			this.setSize(300, 260);
		}

		@Override
		public void paint(Graphics g) {
			// g.drawLine((x * 6) +3, y * 14, (x * 6) +3, (y * 14) + 14);
			// g.fillRect(x * 6, y * 14, 6, 14);
			int x = 0;
			int y = 130;
			try {

				System.out.println("-----------------------------");
				System.out.println(chartS);
				System.out.println("-----------------------------");
				int cal = row + 3;
				int[][] list = new int[row + 1][chart.length];
				int[] cnt = new int[row + 1];
				for (int i = 0; i < chartS.length(); i++) {
					int j = (int) chartS.charAt(i);
					if (j != 13 && j != 10) {
						switch (j) {
						case 49: // 1
							list[x][cnt[x]] = 1;
							cnt[x] = cnt[x] + 1;
							break;
						case 50: { // 2
							list[x][cnt[x]] = 2;
							cnt[x] = cnt[x] + 1;
							break;
						}
						case 51: { // 3
							list[x][cnt[x]] = 3;
							cnt[x] = cnt[x] + 1;
							break;
						}
						case 52: { // 4
							list[x][cnt[x]] = 4;
							cnt[x] = cnt[x] + 1;
							break;
						}
						}
						x++;
					}
					if (j == 10) {
						x = 0;
					}
				}
				boolean flag = true;
				boolean flag2 = true;
				for (int i = 0; i <= row; i++) {
					int lenb = 0;
					for (int j = 0; j < list[0].length; j++) {
						if (list[i][j] == 0) {
							if(lenb!=0) {
								g.setColor(Color.BLACK);
								g.drawLine((i * 6) +4, y, (i * 6) +4, y  + 10*lenb);
							}
							break;
						}
						switch (list[i][j]) {
						case 1:
							lenb++;
							break;
						case 2: {
							g.setColor(Color.RED);
							if (!flag2) {
								flag2 = true;
							} else {
								y = y - 10;
							}
							g.fillRect((i * 6) + 2, y, 6, 10);
							flag = false;
							break;
						}
						case 3:
							g.setColor(Color.BLUE);
							if (!flag) {
								flag = true;
							} else {
								y = y + 10;
							}
							g.fillRect((i * 6) + 2, y, 6, 10);
							flag2 = false;
							break;
						case 4:
							if(lenb!=0) {
								g.setColor(Color.BLACK);
								g.drawLine((i * 6) +4, y, (i * 6) +4, y  - 10*lenb);
								lenb=0;
							}
							if (!flag2) {
								flag2 = true;
								y = y + 10;
							}
							flag = false;
							g.setColor(Color.RED);
							g.drawLine((i * 6) + 2, y, (i * 6) + 6, y);
							break;
						}
					}
				}
				x = 0;
				chartS = "";
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) {
			String imsi = jlist.getSelectedValue();
			imsi = imsi.substring(5);
			StringTokenizer st = new StringTokenizer(imsi," ");
			taketprice = st.nextToken();
			System.out.println(taketprice);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("매수")) {
			JOptionPane.showInputDialog(null, taketprice+"원 매수 수량 입력",command,PLAIN_MESSAGE);
		}else if(command.equals("매도")) {
			JOptionPane.showInputDialog(null, taketprice+"원 매도 수량 입력",command,PLAIN_MESSAGE);
		}else if(command.equals("뒤로가기")) {
			
		}
		
	}
}
