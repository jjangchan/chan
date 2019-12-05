package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Balance extends JFrame implements ActionListener {
	ADM a;
	private JPanel contentPane;
	private JTextArea textArea;
	private JScrollPane sp;
	private JButton btnNewButton;
	int test = 0;

	public Balance(ADM a) {
		this.a = a;
		bl();
	}

	public void bl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("종목       현재가             매수단가              수량         수익률(%)          수익(원)");
		lblNewLabel.setBounds(12, 21, 458, 24);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setBounds(33, 46, 429, 166);
		contentPane.add(textArea);

		btnNewButton = new JButton("뒤로 가기");
		btnNewButton.setBounds(193, 233, 97, 23);
		contentPane.add(btnNewButton);


		textArea.setEditable(false);
		sp = new JScrollPane(textArea);
		sp.setBounds(12, 55, 458, 168);
		this.getContentPane().add(sp);
		btnNewButton.addActionListener(this);
	}

	public void info(String info) {
		synchronized (this) {
//			System.out.println(info);
//			String getTA = textArea.getText();
//			StringTokenizer tokensTA = new StringTokenizer(getTA, "*\r\n");
//			StringTokenizer tokensINFO = new StringTokenizer(info);
//			String updateN = tokensINFO.nextToken();
//			
//			String updateTA = "";
//			
//			if (getTA.indexOf(updateN)==-1) {
//				textArea.setText(getTA + info + "\r\n");
//			} else {
//				
//				while (tokensTA.hasMoreTokens()) {
//					StringTokenizer thisTarget = new StringTokenizer(tokensTA.nextToken());
//					String targetN = thisTarget.nextToken();
//					if (updateN.equals(targetN)) {
//						updateTA += info;
//					} else {
//						updateTA += tokensTA + "*\r\n";
//					}
//				}
//				textArea.setText(updateTA);
//			}
			String update = "";
			String getTA = textArea.getText();
			StringTokenizer tokensINFO = new StringTokenizer(info);
			StringTokenizer tokensINFO2 = new StringTokenizer(info,"*");
			
			String updateN = tokensINFO.nextToken();
			while(tokensINFO2.hasMoreTokens()) {
				String updateN2 =  tokensINFO2.nextToken();
				
				if (getTA.indexOf(updateN)==-1) {
					textArea.setText(getTA + updateN2 + "\r\n");
				} else {
					StringTokenizer st = new StringTokenizer(textArea.getText(), "\r\n");
					while (st.hasMoreTokens()) {
						String updateST = st.nextToken();
						String taket = updateST.substring(0,updateST.indexOf(" "));
						if (taket.equals(info.substring(0, info.indexOf(" ")))) {
							update = update+(updateN2+"\r\n");
						}else {
							update = update+(updateST+"\r\n");
						}
					}
					textArea.setText(update);
					
				}
				
			}
		}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String imsi = e.getActionCommand();
		if (imsi.equals("뒤로 가기")) {
			a.sendC(imsi + 2);
			this.setVisible(false);
		}
	}

}
