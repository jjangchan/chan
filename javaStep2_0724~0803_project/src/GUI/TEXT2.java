package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JPanel;
import javax.swing.JTextField;


import javax.swing.JScrollBar;

public class TEXT2 {
	private JPanel panel;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEXT2 window = new TEXT2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TEXT2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			int a = 0;
			public void paint(Graphics g) {
				//g.fillRect(a, 0, 100, 100);
				a= a+5;
			}
		};
		panel.setBounds(32, 10, 370, 216);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 370, 216);
		panel.add(scrollPane);
		
		
		re();
	}

	private void re() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						textField = new JTextField();
						textField.setBounds(32, 10, 370, 216);
						frame.getContentPane().add(textField);
						textField.setColumns(10);
						panel.add(textField);
						System.out.println(panel.getComponentCount());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
}
