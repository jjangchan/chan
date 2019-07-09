package main;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game  extends JFrame {
	
	
	JPanel main = new JPanel();
	public Game() {
		
		this.setSize(500, 400);
		this.setLocation(300, 100);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	
	public void Paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("2633B43653F8FD261E.jpg");
	}
	
}
