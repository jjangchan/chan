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
	JLabel li = new JLabel("����Ʈ");
	JButton mod = new JButton("�̷¼� ����(����)");
	JButton del = new JButton("�̷¼� ����");
	JButton back = new JButton("���� �޴��� ����");
	
	JLabel category = new JLabel("�Ի��ϰ� ���� ȸ�� �о�");
	String[] kinds = {"3D����","HTML","UI ����","DB �ý���","IT�������΢���ǻ��","JAVA","���Ӱ���","���ӱ�ȹ","��Ʈ��ũ �����Ͼ�","����� ���","���� ����","���� ������","�ý��� ���α׷���"};
	
	JLabel oneL = new JLabel("�Ի� ����� ���θ� �����ּ���. (1000�� ����)");
	JLabel twoL = new JLabel("���ϴ� �� �ʿ��� ������ �� ����, �׸��� �װ� ���� ������ ������ ����Ͻÿ�.(1000�� ����)");
	JLabel threeL = new JLabel("������ ������ ������ ����� ����, ������ �Ի� �� ���������� �⿩�� �� �ִ� ���� ������ �غ��ϱ� ���� ����� ���� ����Ͻÿ�.");
	JTextArea oneT = new JTextArea();
	JTextArea twoT = new JTextArea();
	JTextArea threeT = new JTextArea();
	JLabel oneL2 = new JLabel("�Ի� ����� ���θ� �����ּ���. (1000�� ����)");
	JLabel twoL2 = new JLabel("���ϴ� �� �ʿ��� ������ �� ����, �׸��� �װ� ���� ������ ������ ����Ͻÿ�.(1000�� ����)");
	JLabel threeL2 = new JLabel("������ ������ ������ ����� ����, ������ �Ի� �� ���������� �⿩�� �� �ִ� ���� ������ �غ��ϱ� ���� ����� ���� ����Ͻÿ�.");
	JTextArea oneT2 = new JTextArea();
	JTextArea twoT2 = new JTextArea();
	JTextArea threeT2 = new JTextArea();
	JComboBox menu=null;
	ArrayList<JobDTO> listA;
	ArrayList<JobDTO> mylistA;
	JButton save = new JButton("����");
	JButton exit = new JButton("����Ʈ ����");
	JButton save2 = new JButton("����");
	JButton exit2 = new JButton("����Ʈ");
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
				jobList.add("ID :"+imsi.getId()+" / ������¥"+imsi.getDay());
			}
			
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btname = e.getActionCommand();
		Object a= menu.getSelectedItem();
		String texta = a.toString();
		
		if(btname.equals("����")) {
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
		}else if(btname.equals("����Ʈ ����")) {
			listupdate();
			this.remove(mainP);
			this.add(listP);
			pack();
			this.setSize(400, 400);
			this.setVisible(true);
		}else if(btname.equals("�̷¼� ����")) {
			int selnum = jobList.getSelectedIndex();
			JobDTO imsi = listA.get(selnum);
			jdao.delete(imsi.getDay());
			listupdate();
		}else if(btname.equals("����Ʈ")) {
			
			this.remove(mainP2);
			this.add(listP);
			pack();
			this.setSize(400, 400);
			this.setVisible(true);
		}else if(btname.equals("���� �޴��� ����")) {
			this.remove(listP);
			this.add(mainP);
			pack();
			this.setSize(800, 500);
			this.setVisible(true);
		}else if(btname.equals("�̷¼� ����(����)") ) {
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
		}else if(btname.equals("����")) {
			
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
