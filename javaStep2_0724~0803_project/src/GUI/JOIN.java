package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOIN extends JFrame implements ActionListener {
	ADM a;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public JOIN(ADM a) {
		this.a = a;
		jonn();
	}
	
	private void jonn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(95, 39, 57, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 36, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setBounds(95, 80, 57, 15);
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPwd);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(95, 120, 57, 15);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblName);
		
		JLabel lblAddr = new JLabel("ADDR");
		lblAddr.setBounds(95, 161, 57, 15);
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddr);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 77, 116, 21);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 117, 116, 21);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 158, 116, 21);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
	
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setBounds(315, 35, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입신청");
		btnNewButton_1.setBounds(173, 207, 116, 23);
		contentPane.add(btnNewButton_1);
		textField.addActionListener(this);
		textField_1.addActionListener(this);
		textField_2.addActionListener(this);
		textField_3.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}
	
	public void mb(String nc) {
		JOptionPane.showMessageDialog(null, nc);
	}
					

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg.equals("회원가입신청")) {
			msg = textField_1.getText()+"/"+textField_2.getText()+"/"+textField_3.getText();
			a.getSs().send(msg);
		}else if(msg.equals("중복확인")) {
			msg = msg + "@" + textField.getText();
			a.sendC(msg);

		}
		
	}
}
