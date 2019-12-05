package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class FUCT extends JFrame implements ActionListener {
	ADM a;
	
	public FUCT(ADM a) {
		this.a = a;
		Function();

	}

	private void Function() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton button = new JButton("종목 보기");
		button.setBounds(154, 76, 97, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("잔고 내역");
		button_1.setBounds(154, 142, 97, 23);
		getContentPane().add(button_1);
		
		button.addActionListener(this);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String imsi = e.getActionCommand();
		if(imsi.equals("종목 보기")) {
			this.setVisible(false);
			a.sendC(imsi);
			
		}else {
			this.setVisible(false);
			a.sendC(imsi);
		}
	}
	
}
