package MenuFrame;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.wordDAO;
import DTO.wordDTO;

public class MenuFrame extends JFrame implements ItemListener,ActionListener{
	
	List wordList = new List();
	JLabel wordListLabel = new JLabel("리스트", JLabel.CENTER);
	
	JPanel listP = new JPanel();
	JPanel menuP = new JPanel();
	JButton addB = new JButton("추가");
	JButton delB = new JButton("삭제");
	JButton modB = new JButton("수정");
	JButton listB = new JButton("보기");
	
	JPanel northmainP = new JPanel();
	JPanel northmainP_up = new JPanel();
	JPanel northmainP_center = new JPanel();
	
	Label endlabel = new Label("영어단어");
	TextArea endTA = new TextArea(2,25);
	
	Label korlabel = new Label("한글단어");
	TextArea korTA = new TextArea(2,25);
	JLabel programInfo = new JLabel("단어장 프로그램 v1.0",JLabel.CENTER);
	
	JPanel inputP = new JPanel();
	Label iendlabel = new Label("영어단어");
	TextArea iendTA = new TextArea(2,20);
	
	Label ikorlabel = new Label("한글단어");
	TextArea ikorTA = new TextArea(2,20);
	
	JPanel inputP_n = new JPanel();
	JPanel inputP_c = new JPanel();
	
	
	JButton saveB = new JButton("저장");
	wordDAO wdao = null;
	ArrayList<wordDTO> wlist = null;
	
	public MenuFrame() {
		this.setBounds(100, 100, 300, 330);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		init();
		setDB();
		
	}

	private void init() {
		listP.setLayout(new BorderLayout());
		listP.add(wordListLabel,"North");
		listP.add(wordList,"Center");
		
		this.add(listP,"Center");
		
		menuP.setLayout(new BoxLayout(menuP, BoxLayout.Y_AXIS));
		menuP.add(addB);
		menuP.add(delB);
		menuP.add(modB);
		menuP.add(listB);
		
		this.add(menuP,"West");
		
		endTA.setEditable(false);
		
		northmainP_up.add(endlabel);
		northmainP_up.add(endTA);
		northmainP_center.add(korlabel);
		northmainP_center.add(korTA);
		northmainP.setLayout(new BorderLayout());
		northmainP.add(northmainP_up,"North");
		northmainP.add(northmainP_center,"Center");
		northmainP.add(programInfo,"South");
		this.add(northmainP,"South");
		
		inputP_n.add(iendlabel);
		inputP_n.add(iendTA);
		
		inputP_c.add(ikorlabel);
		inputP_c.add(ikorTA);
		
		inputP.setLayout(new BorderLayout());
		inputP.add(inputP_n,"North");
		inputP.add(inputP_c,"Center");
		inputP.add(saveB,"South");
		
		
		
		wordList.addItemListener(this);
		delB.addActionListener(this);
		modB.addActionListener(this);
		addB.addActionListener(this);
		saveB.addActionListener(this);
	}
	
	public void setDB() {
		
		wdao = wordDAO.getInstance();
		wlist = wdao.getList();
		listupdate();
	}

	private void listupdate() {
		wordDTO imsi = null;
		wordList.removeAll();
		if(wlist != null) {
			for(int i=0; i<wlist.size();i++) {
				imsi = wlist.get(i);
				wordList.add(imsi.getEng()+" : "+imsi.getKor());
			}
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int selnum = wordList.getSelectedIndex();
		wordDTO imsi = wlist.get(selnum);
		
		endTA.setText("");
		korTA.setText("");
		endTA.append(imsi.getEng());
		korTA.append(imsi.getKor());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String btnName = e.getActionCommand();
		
		
		if(btnName.equals("삭제")) {
			int selnum = wordList.getSelectedIndex();
			wordDTO imsi = wlist.get(selnum);
			wdao.delete(imsi.getEng());
			setDB();
		}else if(btnName.equals("수정")) {
			int selnum = wordList.getSelectedIndex();
			wordDTO imsi = wlist.get(selnum);
			imsi.setKor(korTA.getText());
			wdao.update(imsi);
			setDB();
		}else if(btnName.equals("추가")) {
			
			this.remove(listP);
			this.add(inputP,"Center");
			this.setVisible(true);
		}else if(btnName.equals("저장")) {
			int selnum = wordList.getSelectedIndex();
			wordDTO imsi = wlist.get(selnum);
			imsi.setEng(iendTA.getText());
			imsi.setKor(ikorTA.getText());
			wdao.insert(imsi);
		}
	}
	
	


}
