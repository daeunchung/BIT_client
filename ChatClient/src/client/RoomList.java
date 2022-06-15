package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RoomList extends JFrame implements ActionListener {

	private JTextField txtname = new JTextField();
	private JButton makeRoom = new JButton();
	private JButton btnconn = new JButton();
	private JTextField portRoomNumberTA = new JTextField();
	private JScrollPane jScrollPane1 = new JScrollPane();
	private JTextField txtsend = new JTextField();
	private JButton btnok = new JButton();
	private JLabel lblinwon = new JLabel();
	private JRadioButton radio1 = new JRadioButton();
	private JRadioButton radio2 = new JRadioButton();
	private JButton btnclose = new JButton();
	private List list = new List();
	private JButton btnchange = new JButton();
	private BufferedReader in;
	private OutputStream out;
	private Socket soc;
	int count = 0;// 생성된 방의 수

	JLabel[] jLabelArr = new JLabel[5]; // 5를 나중에 size 로 변경
	JButton[] jBtnArr = new JButton[5];

	public RoomList() {

		try {
			Init();
			addListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addListener() {
		txtname.addActionListener(this);
		txtsend.addActionListener(this);
		btnok.addActionListener(this);
		btnconn.addActionListener(this);
		btnclose.addActionListener(this);
		btnchange.addActionListener(this);
	}

	public void Init() throws Exception {

		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(700, 410));
		this.setTitle("채팅방 목록");
		this.setBackground(new Color(0, 222, 0));

//		JLabel[] jLabelArr = new JLabel[5]; // 5를 나중에 size 로 변경
//		JButton[] jBtnArr = new JButton[5];

		for (int i = 0; i < 5; i++) {
			jLabelArr[i] = new JLabel("방 이름과 서버 주소 : ");
			jLabelArr[i].setBounds(new Rectangle(50, (i + 1) * 30, 400, 30));

			jBtnArr[i] = new JButton("방 입장");
			jBtnArr[i].setBounds(new Rectangle(400, (i + 1) * 30, 100, 30));

			this.getContentPane().add(jLabelArr[i], null);
			this.getContentPane().add(jBtnArr[i], null);
		}

		makeRoom.setText("방 만들기");
		makeRoom.setBounds(new Rectangle(200, 200, 100, 30));
		this.getContentPane().add(makeRoom, null);

		txtname.setBounds(new Rectangle(50, 200, 150, 30));
		this.getContentPane().add(txtname, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 포트번호 넣고 방 만들기 실행시에
		if (e.getSource() == portRoomNumberTA || e.getSource() == makeRoom) {

			int portNum = Integer.parseInt(portRoomNumberTA.getText());

			try {
				soc = new Socket("192.168.0.129", portNum);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream(), "euk-kr"));
				out = soc.getOutputStream();
				out.write((portRoomNumberTA.getText() + "\n").getBytes("euk-kr"));
			} catch (Exception e1) {
				e1.printStackTrace();

			}
		}

		// 1번방 입장 버튼 누르면
		else if (e.getSource() == jBtnArr[1]) {
			try {
				soc = new Socket("192.168.0.129", 9001);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream(), "euk-kr"));
				out = soc.getOutputStream();
				out.write((txtname.getText() + "\n").getBytes("euk-kr"));
				ChatClient cc = new ChatClient();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 2번방 입장 버튼 누르면
		} else if (e.getSource() == jBtnArr[2]) {
			try {
				soc = new Socket("192.168.0.129", 9002);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream(), "euk-kr"));
				out = soc.getOutputStream();
				out.write((txtname.getText() + "\n").getBytes("euk-kr"));
				ChatClient cc = new ChatClient();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 3번방 입장 버튼 누르면
		} else if (e.getSource() == jBtnArr[3]) {
			try {
				soc = new Socket("192.168.0.129", 9003);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream(), "euk-kr"));
				out = soc.getOutputStream();
				out.write((txtname.getText() + "\n").getBytes("euk-kr"));
				ChatClient cc = new ChatClient();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 4번방 입장 버튼 누르면
		} else if (e.getSource() == jBtnArr[4]) {
			try {
				soc = new Socket("192.168.0.129", 9004);
				in = new BufferedReader(new InputStreamReader(soc.getInputStream(), "euk-kr"));
				out = soc.getOutputStream();
				out.write((txtname.getText() + "\n").getBytes("euk-kr"));
				ChatClient cc = new ChatClient();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		RoomList rl = new RoomList();

		rl.getPreferredSize();
		rl.setLocation(200, 200);
		rl.setVisible(true);
		rl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
