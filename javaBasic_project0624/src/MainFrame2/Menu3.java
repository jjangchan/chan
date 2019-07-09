package MainFrame2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DAO.JobDAO;
import DTO.JobDTO;
import MainFrame.Menu1;

public class Menu3 extends JFrame implements ActionListener {
	List jobList = new List();
	JPanel  listP = new JPanel();
	
	JPanel  firP = new JPanel();
	JPanel secP = new JPanel();
	JPanel mainP = new JPanel();
	
	JPanel secP2 = new JPanel();
	JPanel mainP2 = new JPanel();
	
	
	JPanel butP = new JPanel();
	JLabel li = new JLabel("리스트");
	JButton mod = new JButton("이력서 보기(수정)");
	JButton del = new JButton("이력서 삭제");
	JButton back = new JButton("이전 메뉴로 가기");
	
	JLabel category = new JLabel("입사하고 싶은 회사 분야");
	String[] kinds = {"3D설계","HTML","UI 개발","DB 시스템","IT˙디자인˙컴퓨터","JAVA","게임개발","게임기획","네트워크 엔지니어","모바일 통신","서버 보안","서버 관리자","시스템 프로그래머"};
	
	JLabel oneL = new JLabel("입사 동기와 포부를 적어주세요. (1000자 제한)");
	JLabel twoL = new JLabel("일하는 데 필요한 역량과 그 이유, 그리고 그걸 위해 도전한 경험을 기술하시오.(1000자 제한)");
	JLabel threeL = new JLabel("성격의 장점과 단점을 기술한 이후, 장점이 입사 후 지원직무에 기여할 수 있는 점과 단점을 극복하기 위해 노력한 점을 기술하시오.");
	JTextArea oneT = new JTextArea();
	JTextArea twoT = new JTextArea();
	JTextArea threeT = new JTextArea();
	JLabel oneL2 = new JLabel("입사 동기와 포부를 적어주세요. (1000자 제한)");
	JLabel twoL2 = new JLabel("일하는 데 필요한 역량과 그 이유, 그리고 그걸 위해 도전한 경험을 기술하시오.(1000자 제한)");
	JLabel threeL2 = new JLabel("성격의 장점과 단점을 기술한 이후, 장점이 입사 후 지원직무에 기여할 수 있는 점과 단점을 극복하기 위해 노력한 점을 기술하시오.");
	JTextArea oneT2 = new JTextArea();
	JTextArea twoT2 = new JTextArea();
	JTextArea threeT2 = new JTextArea();
	JComboBox menu=null;
	ArrayList<JobDTO> listA;
	ArrayList<JobDTO> mylistA;
	JButton save = new JButton("저장");
	JButton exit = new JButton("리스트 보기");
	JButton save2 = new JButton("수정");
	JButton exit2 = new JButton("리스트");
	Timestamp myday;
	JPanel last = new JPanel();
	JPanel last2 = new JPanel();
	Menu1 sing = null;
	JobDAO jdao = null;
	String mybir;
	public void M3(){
		this.setSize(800, 500);
		this.setLocation(300, 100);
		seting();
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	private void init() {
		
		mainP.setLayout(new BorderLayout());
		
		mainP.add(secP,"Center");
		
        mainP2.setLayout(new BorderLayout());
		
		mainP2.add(secP2,"Center");
		
		
		firP.setLayout(new FlowLayout());
		firP.add(category);
		menu = new JComboBox(kinds);
		firP.add(menu);
		
		secP.setLayout(new GridLayout(8, 1));
		secP.add(firP);
		secP.add(oneL);
		secP.add(oneT);
		secP.add(twoL);
		secP.add(twoT);
		secP.add(threeL);
		secP.add(threeT);
	    oneT.setLineWrap(true);
		twoT.setLineWrap(true);
		threeT.setLineWrap(true);
		secP.add(last);
		
		secP2.setLayout(new GridLayout(8, 1));
		secP2.add(oneL2);
		secP2.add(oneT2);
		secP2.add(twoL2);
		secP2.add(twoT2);
		secP2.add(threeL2);
		secP2.add(threeT2);
		oneT2.setLineWrap(true);
		twoT2.setLineWrap(true);
		threeT2.setLineWrap(true);
		secP2.add(last2);
		
		
		listP.setLayout(new GridLayout(3,1));
		listP.add(li);
		listP.add(jobList);
		butP.setLayout(new FlowLayout());
		butP.add(mod);
		butP.add(del);
		butP.add(back);
		listP.add(butP);
		
		last.setLayout(new FlowLayout());
		last.add(save);
		last.add(exit);
		
		last2.setLayout(new FlowLayout());
		last2.add(save2);
		last2.add(exit2);
		
		
		jobList.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		del.addActionListener(this);
		mod.addActionListener(this);
		save2.addActionListener(this);
		exit2.addActionListener(this);
	    back.addActionListener(this);
		
		this.add(mainP);
		
	}
	
	private void seting() {
		sing = Menu1.getInstance();
		mybir = sing.getBir();
		jdao = JobDAO.getInstence();
		listupdate();
	}
	
	private void listupdate() {
		jobList.removeAll();
		if(jdao.getList(mybir) == null) {
			listA = new ArrayList();
		}else {
			listA = jdao.getList(mybir);
			for(int i=0;i<listA.size();i++) {
				JobDTO imsi = listA.get(i);
				jobList.add("ID :"+imsi.getId()+" / 생성날짜"+imsi.getDay());
			}
			
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btname = e.getActionCommand();
		Object a= menu.getSelectedItem();
		String texta = a.toString();
		
		if(btname.equals("저장")) {
			JobDTO imsi = new JobDTO();
			imsi.setId(mybir);
			imsi.setCom(texta);
			imsi.setWhy(oneT.getText());
			imsi.setChal(twoT.getText());
			imsi.setAdv(threeT.getText());
			jdao.insert(imsi);
			oneT.setText("");
			twoT.setText("");
			threeT.setText("");
		}else if(btname.equals("리스트 보기")) {
			listupdate();
			this.remove(mainP);
			this.add(listP);
			pack();
			this.setSize(400, 400);
			this.setVisible(true);
		}else if(btname.equals("이력서 삭제")) {
			int selnum = jobList.getSelectedIndex();
			JobDTO imsi = listA.get(selnum);
			jdao.delete(imsi.getDay());
			listupdate();
		}else if(btname.equals("리스트")) {
			
			this.remove(mainP2);
			this.add(listP);
			pack();
			this.setSize(400, 400);
			this.setVisible(true);
		}else if(btname.equals("이전 메뉴로 가기")) {
			this.remove(listP);
			this.add(mainP);
			pack();
			this.setSize(800, 500);
			this.setVisible(true);
		}else if(btname.equals("이력서 보기(수정)") ) {
			int selnum = jobList.getSelectedIndex();
			JobDTO imsi = listA.get(selnum);
			myday = listA.get(selnum).getDay();
			mylistA = jdao.myList(imsi.getDay());
			this.remove(listP);
			this.add(mainP2);
			pack();
			this.setSize(800, 500);
			oneT2.setText(mylistA.get(0).getWhy());
			twoT2.setText(mylistA.get(0).getChal());
			threeT2.setText(mylistA.get(0).getAdv());
			mylistA = null;
			this.setVisible(true);
		}else if(btname.equals("수정")) {
			
			JobDTO imsi2 = new JobDTO();
			imsi2.setDay(myday);
			imsi2.setWhy(oneT2.getText());
			imsi2.setChal(twoT2.getText());
			imsi2.setAdv(threeT2.getText());
			jdao.update(imsi2);
			oneT2.setText("");
			twoT2.setText("");
			threeT2.setText("");
			listupdate();
	}
		
	}
}
