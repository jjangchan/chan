package MenuFrame1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DTO.JobDTO;
import DTO.LuckyDTO;
import MainFrame.Menu1;
import MainFrame2.Menu3;

public class Menu2 extends JFrame implements ActionListener {
	
	List wordList = new List();
	JLabel north = new JLabel("오늘의 운세 ");
	JLabel south = new JLabel("2019년 6월 25일 ",JLabel.CENTER);
	ImageIcon image1 = new ImageIcon("heart01.png");
	ImageIcon image2 = new ImageIcon("book01.png");
	JButton ll = new JButton("애정",image1);
	JButton ls = new JButton("학업,성적",image2);
	JButton back = new JButton("이전 메뉴");
	JButton back2 = new JButton("(학업,성적)뒤로가기");
	JButton back_2 = new JButton("(학업,성적)2뒤로가기");
	JButton back3 = new JButton("(애정)뒤로가기");
	
	JButton addB = new JButton("자소서 쓰기");
	
	JPanel mainP= new JPanel();
	JPanel northP= new JPanel();
	JPanel southP= new JPanel();
	JPanel centP= new JPanel();
	JPanel lP= new JPanel();
	JPanel sP= new JPanel();
	JPanel sP2= new JPanel();
	JPanel bP2= new JPanel();
	Menu1 m = null;
	
	JTextArea lTA = new JTextArea(12,43);
	JTextArea sTA = new JTextArea(12,43);
	JTextArea tTA = new JTextArea(12,43);
	private ArrayList<LuckyDTO> tl=null;
	private ArrayList<LuckyDTO> t2=null;
    private ArrayList<LuckyDTO> t3=null;
	private String b;
	
	public void menuadm() {
		this.setBounds(200, 200, 600, 350);
		seting();
		init(); 
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	private void seting() {
		m = Menu1.getInstance();
		
		tl = m.getLove();
		t2 = m.getStudy();
		t3 = m.getBirA();
		b = m.getBir();
	}
	
	
	
	
	
	private void init() {
		mainP.setLayout(new BorderLayout());
		southP.setLayout(new BorderLayout());
		lP.setLayout(new BorderLayout());
		sP.setLayout(new BorderLayout());
		sP2.setLayout(new BorderLayout());
	
		ll.setBorderPainted(false);
		ll.setFocusPainted(false);
		ll.setBackground(Color.white);
		ls.setOpaque(false);
		ls.setBorderPainted(false);
		ls.setFocusPainted(false);
		ls.setBackground(Color.white);
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
//		back2.setOpaque(false);
//		back2.setBorderPainted(false);
//		back2.setFocusPainted(false);
		
		ll.setBackground(new Color(010,007,033));
		ls.setBackground(new Color(010,007,033));
		back.setBackground(new Color(010,007,033));
		mainP.setBackground(new Color(010,007,033));
		centP.setBackground(new Color(010,007,033));
		southP.setBackground(new Color(010,007,033));
		northP.setBackground(new Color(010,007,033));
		north.setForeground(Color.white);
		south.setForeground(Color.white);
		north.setForeground(Color.white);
		ll.setForeground(Color.white);
		ls.setForeground(Color.white);
		back.setForeground(Color.white);
		northP.add(north,"North");
		centP.add(ll,"Center");
		centP.add(ls,"Center");
		southP.add(south,"South");
		southP.add(back,"North");
		mainP.add(centP,"Center");
		mainP.add(northP,"North");
		mainP.add(southP,"South");
		lTA.setEditable(false);
		sTA.setEditable(false);
		tTA.setEditable(false);
		bP2.add(back_2);
		bP2.add(addB);
	
		lP.add(lTA,"North");
		lP.add(back3,"South");
		sP.add(sTA,"North");
		sP.add(back2,"South");
		sP2.add(tTA,"North");
		sP2.add(bP2,"South");
	
		ll.addActionListener(this);
		ls.addActionListener(this);
		back.addActionListener(this);
		back2.addActionListener(this);
		back_2.addActionListener(this);
		back3.addActionListener(this);
		addB.addActionListener(this);
	
		lTA.setLineWrap(true);
		sTA.setLineWrap(true);
		tTA.setLineWrap(true);
		lTA.setOpaque(false);
		sTA.setOpaque(false);
		tTA.setOpaque(false);
		this.add(mainP);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btname = e.getActionCommand();
		Menu3 m3 = new Menu3();
		
		if(btname.equals("애정")) {
			
			this.remove(mainP);
			lTA.setText(tl.get(0).getLove());
			this.add(lP);
			pack();
			this.setBounds(200, 200, 600, 350);
			this.setVisible(true);
			
			
		}else if(btname.equals("학업,성적")) {
			boolean frag = true;
			this.remove(mainP);
			
			
		    while(frag) {
				for(int i=0; i<t3.size(); i++) {
					if(t3.get(i).getBirth().equals(b)) {
						tTA.setText(t2.get(0).getStudy()+"\r"+" /운세가 좋습니다 . 자소서를 쓰시겠습니까?");
				
						this.add(sP2);
						pack();
						this.setBounds(200, 200, 600, 350);
						this.setVisible(true);
						frag = false;
						break;
					}
				}
				if (frag) {
					sTA.setText(t2.get(0).getStudy());
					this.add(sP);
					pack();
					this.setBounds(200, 200, 600, 350);
					this.setVisible(true);
					frag = false;
				}
				
			}
		}else if(btname.equals("이전 메뉴")) {
            tl = null;
			t2 = null;
			t3 = null;
			b = null;
			this.setVisible(false);
			m.mp();
		}else if(btname.equals("(학업,성적)뒤로가기")) {
            this.remove(sP);
			this.add(mainP);
			pack();
			this.setBounds(200, 200, 600, 350);
			this.setVisible(true);
		}else if(btname.equals("(애정)뒤로가기")) {
            this.remove(lP);
			this.add(mainP);
			pack();
			this.setBounds(200, 200, 600, 350);
			this.setVisible(true);
		}else if(btname.equals("(학업,성적)2뒤로가기")) {
            this.remove(sP2);
			this.add(mainP);
			pack();
			this.setBounds(200, 200, 600, 350);
			this.setVisible(true);
		}else if(btname.equals("자소서 쓰기")) {
            m3.M3();
			this.setVisible(false);
		}
	}
	
}
	
		
		
		
		
		
		
		
	
	
	
	
	
