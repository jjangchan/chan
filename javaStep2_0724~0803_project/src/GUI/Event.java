package GUI;

import java.awt.Color;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Event extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private String event;
	private ArrayList<String> eventL = new ArrayList<>();
	private ArrayList<JLabel> labelT = new ArrayList<>();
	private ArrayList<Pevent> eventT; 
	ADM a;

	public Event(ADM a) {
		this.a = a;
		function();
		
	}
	

	public void function() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("종목             가격(현재가)                                       chg(원/%)    ");
		lblNewLabel.setBounds(57, 44, 395, 15);
		contentPane.add(lblNewLabel);
		
		label = new JLabel();
		label.setText("신성이엔지");
		label.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), null));
		label.setBounds(47, 69, 395, 32);
		contentPane.add(label);
		eventL.add(label.getText());
		labelT.add(label);
		
		label_1 = new JLabel("삼성전자");
		label_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), null));
		label_1.setBounds(47, 100, 395, 32);
		contentPane.add(label_1);
		eventL.add(label_1.getText());
		labelT.add(label_1);
		
		label_2 = new JLabel("SK하이닉스");
		label_2.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), null));
		label_2.setBounds(47, 131, 395, 32);
		contentPane.add(label_2);
		eventL.add(label_2.getText());
		labelT.add(label_2);
		
		label_3 = new JLabel("모나미");
		label_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), null));
		label_3.setBounds(47, 162, 395, 32);
		contentPane.add(label_3);
		eventL.add(label_3.getText());
		labelT.add(label_3);
		
		label_4 = new JLabel("셀트리온");
		label_4.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), null));
		label_4.setBounds(47, 193, 395, 32);
		contentPane.add(label_4);
		eventL.add(label_4.getText());
		labelT.add(label_4);
		
		JButton btnNewButton = new JButton("잔고 내역");
		btnNewButton.setBounds(106, 244, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.setBounds(306, 244, 97, 23);
		contentPane.add(btnNewButton_1);
	
		contentPane.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String taketT = ""+contentPane.getComponentAt(e.getX(), e.getY());
				event = taketT.substring(taketT.indexOf("text"));
				event = event.substring(5,event.indexOf(" "));
				System.out.println(event);
				//end();
				a.sendC(event);
			}

		
		});
		
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}
	private void end() {
		this.setVisible(false);
	}
	
	public void eventmsg(String msg) {
		synchronized (this) {
			StringTokenizer st = new StringTokenizer(msg, "*");
			while(st.hasMoreTokens()) {
				String taket = st.nextToken();
				String taket2 = null;
				int c = taket.indexOf("%");
				for(int i=c;i>0;i--) {
					char h = taket.charAt(i);
					if((h+"").equals(" ")) {
						taket2=taket.substring(i+1,c);
						break;
					}
				}
				String taket1 = taket.substring(2, taket.indexOf(" "));
				for(int i=0;i<eventL.size();i++) {
					if (taket1.equals(eventL.get(i))) {
						labelT.get(i).setText(taket.substring(2));
						if(taket2.indexOf("-")==-1) {
							if(!"0.0".equals(taket2)) {
								labelT.get(i).setForeground(Color.RED);
							}else {
								labelT.get(i).setForeground(Color.BLACK);
							}
						}else {
							labelT.get(i).setForeground(Color.BLUE);
						}
						break;
					} 
				}
//				if (taket1.equals("신성이엔지")) {
//					label.setText(taket.substring(2));
//					if(taket2.indexOf("-")==-1) {
//						if(!"0.0".equals(taket2)) {
//							label.setForeground(Color.RED);
//						}else {
//							label.setForeground(Color.BLACK);
//						}
//					}else {
//						label.setForeground(Color.BLUE);
//					}
//				} else if (taket1.equals("삼성전자")) {
//					label_1.setText(taket.substring(2));
//					if(taket2.indexOf("-")==-1) {
//						if(!"0.0".equals(taket2)) {
//							label_1.setForeground(Color.RED);
//						}else {
//							label_1.setForeground(Color.BLACK);
//						}
//					}else {
//						label_1.setForeground(Color.BLUE);
//					}
//				}
			}

		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String imsi = e.getActionCommand();
		if(imsi.equals("잔고 내역")) {
			end();
			a.sendC(imsi);
		}else {
			end();
			a.sendC(imsi+1);
		}
	}
}
