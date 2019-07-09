package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.LuckyDAO;
import DTO.LuckyDTO;
import MenuFrame1.Menu2;

public class Menu1 extends JFrame implements ActionListener {
	
	
	String[] luna = {"¾ç·Â","À½·Â"};
	String[] sex = {"³²ÀÚ","¿©ÀÚ"};
	String[] si = {"¸ð¸§","í­(ÀÚ) : 23~01","õä(Ãà) : 01~03","ìÙ(ÀÎ) : 03~05","ÙÖ(¹¦) : 05~07","òã(Áø) : 07~09","ÞÓ(»ç) : 09~11","çí(¿À) : 11~13","Ú±(¹Ì) : 13~15","ãé(½Å) : 15~17","ë·(À¯) : 17~19","âù(¼ú) : 19~21","ú¤(ÇØ) : 21~23"};
	String bir;
	private ArrayList<LuckyDTO> love;
	private ArrayList<LuckyDTO> study;
	private ArrayList<LuckyDTO> birA;
	private LuckyDAO dao = null;
	

	JPanel centerP1= new JPanel();
	JPanel centerP2= new JPanel();
	JPanel centerTP= new JPanel();
	JPanel southP= new JPanel();
	JPanel northP= new JPanel();
	JPanel mainP= new JPanel();
	Label cetL1 = new Label("»ý³â¿ùÀÏ");
	JTextField cetT1 = new JTextField(5);
	Label cetL2 = new Label("¾ç/À½");
	
	Label cetL3 = new Label("¼ºº°");
	
	Label cetL4 = new Label("½Ã°£");
	JTextField cetT4 = new JTextField(5);
	private Menu2 pr = new Menu2();
	private static Menu1 getMenu1 = null;
	public static Menu1 getInstance() {
		if (getMenu1==null) {
			getMenu1 = new Menu1();
		}
		return getMenu1;
	}




	
	public void mp() {
		this.setVisible(true);
	}

	
	
	public Menu1(){
		this.setSize(500, 400);
		this.setLocation(300, 100);
		seting();
		init();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	private void init() {
		mainP.setLayout(new BorderLayout());
		centerTP.setLayout(new BorderLayout());
		
		ImageIcon image2 = new ImageIcon("85772_115108_426.jpg");
		ImageIcon image1 = new ImageIcon("794xN.jpg");
		ImageIcon image3 = new ImageIcon("dog.png");
		JButton bt = new JButton(image3);
//		JLabel Li1 = new JLabel(image1);
		JLabel norL = new JLabel(image2);	
		bt.setBackground(new Color(010,007,033));
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
//		mainP.add(Li1,"South");
		mainP.setBackground(new Color(010,007,033));
		centerTP.setBackground(new Color(010,007,033));
		centerP1.setBackground(new Color(010,007,033));
		centerP2.setBackground(new Color(010,007,033));
		northP.setBackground(new Color(010,007,033));
		cetL1.setForeground(Color.white);
		cetL2.setForeground(Color.white);
		cetL3.setForeground(Color.white);
		cetL4.setForeground(Color.white);
		northP.add(norL);
		mainP.add(northP, "North" );
		JComboBox l = new JComboBox(luna);
		JComboBox s = new JComboBox(sex);
		JComboBox i = new JComboBox(si);
		
		centerP1.add(cetL1);
		centerP1.add(cetT1);
		centerP1.add(l);
//		centerP1.add(cetT2);
		centerP1.add(s);
//		centerP1.add(cetT3);
		centerP1.add(cetL4);
		centerP1.add(i);
		centerP2.add(bt);
		centerTP.add(centerP1, "North");
		centerTP.add(centerP2, "South");
		mainP.add(centerTP, "Center");
		
        
		bt.addActionListener(this);
		cetT1.addActionListener(this);
		this.add(mainP);
	}
	
	private void seting() {
		dao=LuckyDAO.getinstence();
		birA = dao.getList1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    bir = cetT1.getText();
		love =dao.getList(bir);
		study = dao.getList(bir);
		
		
		if(bir.length()==8 ) {
			pr.menuadm();
            this.setVisible(false);
		}else {
			System.out.println("»ý³â¿ùÀÏ 8±ÛÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		}
		
	}

	public ArrayList<LuckyDTO> getLove() {
		
		return love;
	}

	public ArrayList<LuckyDTO> getStudy() {
		return study;
	}

	public String getBir() {
		
		return bir;
	}

    public ArrayList<LuckyDTO> getBirA() {
		return birA;
	}



	
	
	
	
	
}









	

	

	
