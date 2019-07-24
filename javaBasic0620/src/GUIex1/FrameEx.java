package GUIex1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameEx extends JFrame implements ActionListener{
	//borderlayout 동서남북 
	//flowrayout 순서대로
	//액션을 취하고 싶으면 listener 을 만들어져야한다
	JButton j1, j2;
	JPanel jp1 = new JPanel(); //기본값이 flowrayout
	JPanel centerP = new JPanel();
	JPanel centerP_up = new JPanel();
	JTextField t1, t2;
	JTextArea jt;
	JLabel l1, l2;
	
	FrameEx(){
		this.setSize(300, 400);
		this.setLocation(100, 200);
		this.setLayout(new BorderLayout());
		
		init();
		
		//this.setBackground(Color.red);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	private void init() {
		j1 = new JButton("사용자추가");
//		this.add(j1,"North");
		j2 = new JButton("사용자삭제");
//		this.add(j2,"Center");
				
		jp1.add(j1);
		jp1.add(j2);
		this.add(jp1,"North");
		
		j1.addActionListener(this);
		centerP.setLayout(new BorderLayout());
		
		l1 = new JLabel("검색어");
		centerP_up.add(l1);
		t1 = new JTextField(10);
		centerP_up.add(t1);
		
		t1.addActionListener(this);
		jt = new JTextArea(10, 30);
		
		centerP.add(centerP_up,"North");
		centerP.add(jt,"Center");
		this.add(centerP, "Center");
		
		l1 = new JLabel("단어장 v1.0", JLabel.CENTER);
		this.add(l1,"South");
		
	}

	@Override //재정의
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text=t1.getText();
		l1.setText(text);
		t1.setText("");
		jt.append(text+"\n");
	}

}
