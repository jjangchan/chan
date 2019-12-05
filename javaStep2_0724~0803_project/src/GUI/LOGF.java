package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Client.SendServer;

public class LOGF extends JFrame implements ActionListener {
	ADM a;
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LOGF frame = new LOGF();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LOGF(ADM a) {
		this.a = a;
		logchk();
	}
	
	private void logchk() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 49, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 46, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setForeground(new Color(128, 0, 128));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(109, 101, 57, 15);
		contentPane.add(lblPwd);
		
		textField = new JPasswordField();
		textField.setColumns(10);
		textField.setBounds(201, 98, 116, 21);
		contentPane.add(textField);
		
		JButton button = new JButton("로그인");
		button.setBounds(164, 166, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("회원가입");
		button_1.setBounds(164, 214, 97, 23);
		contentPane.add(button_1);
		

		textField.setEchoChar('*');
		textField.addActionListener(this);
		textField_1.addActionListener(this);
		button_1.addActionListener(this);
		button.addActionListener(this); 
		
		
	}
	
	public void mb(String nc) {
		if(nc.equals("로그인 되었습니다.")) {
			a.sendC(nc);
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, nc);
		}
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg.equals("회원가입")) {
			this.setVisible(false);
			a.sendC(msg);
		}else if(msg.equals("로그인")) {
			char[] pwdC = textField.getPassword();
			String pwd ="";
			for(int i=0;i<pwdC.length;i++) {
				pwd = pwd+pwdC[i];
			}
			msg = msg+"/"+textField_1.getText()+"/"+pwd;
			SendServer ss = a.getSs();
			ss.send(msg);
		}
	}
}
