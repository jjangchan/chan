package GUI;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TEXT extends JFrame {

	private JPanel contentPane;
	private JScrollPane sc;
	TextArea textArea;
	int a= 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEXT frame = new TEXT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TEXT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea = new TextArea(null,1,MAXIMIZED_HORIZ,TextArea.SCROLLBARS_HORIZONTAL_ONLY) {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				System.out.println(a);
				g.fillRect(a, 0, 8, 14);
				g.drawLine(10, 20, 15, 20);
				g.drawLine(30, 20, 45, 20);
			}
			
		};
		textArea.getSelectedText();
		textArea.setEditable(false);
		textArea.setBounds(29, 22, 368, 206);
		contentPane.add(textArea);
		te();
		//sc = new JScrollPane(textArea);
		//sc.setBounds(33, 21, 368, 206);
		//this.getContentPane().add(sc);
	}
	
	
	
	private void te() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(10000);
						//sc.getHorizontalScrollBar().setValue(sc.getHorizontalScrollBar().getMaximum());
						textArea.append(a+"");
						textArea.repaint();
						a++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}
