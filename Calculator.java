import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{

	private JTextField txt;
	private JPanel panel;
	
	private String value1, value2; //첫번째 입력되는 수와 두 번째 입력되는 수를 저장할 변수
	private String op; //연산자 저장할 변수
	private double result;//연산 결과를 저장할 변수
	
	public Calculator() {
		txt = new JTextField(20); //숫자를 출력할 텍스트필드
		add(txt, BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		add(panel,BorderLayout.CENTER);
		for(int i = 1; i<=9;i++) {
			JButton btn = new JButton(""+i);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(100,100));
			panel.add(btn);//1-9까지 숫자패널 생성
		}
		
		//사칙연산과 delete, 등호 키 넣을 패널 추가
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,1)); //6행1열
		add(panel,BorderLayout.EAST); //동쪽

	    //setBounds(400, 400, 700, 800); // 프레임의 크기 지정
		//setDefaultCloseOperation(EXIT_ON_CLOSE); // X버튼을 누르면 닫히는 설정
		//setVisible(true); // 프레임이 보이도록 설정
		
		//delete키
		JButton btn1 = new JButton("delete"); //버튼생성
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1 = txt.getText().toString();//첫번째 입력된 숫자의 값을 텍스트 필드에 보여줌
				txt.setText("");
			}
		}); //무명클래스사용
		
		//등호
		JButton btn2 = new JButton("=");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value2 = txt.getText().toString(); //두번째 입력된 숫자 저장
				if(op == "+") {
					result = Integer.parseInt(value1)+Integer.parseInt(value2);//랩퍼클래스 사용해서 문자열을 수치 값으로 바꿔줌
					txt.setText(result+""); //연산 결과를 텍스트필드에 출력
				}
				else if(op =="-") {
					result = Integer.parseInt(value1)-Integer.parseInt(value2);
					txt.setText(result+"");
				}
				else if(op =="*") {
					result = Integer.parseInt(value1)*Integer.parseInt(value2);
					txt.setText(result+"");
				}
				else {
					result = Double.parseDouble(value1)/Double.parseDouble(value2);
					txt.setText(result+"");
				}
			}
		});
		
		JButton btn3 = new JButton("+");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1 = txt.getText().toString();//첫번째 숫자 저장
				txt.setText("");
				op = "+";//연산자+지정
			}
		});
		
		JButton btn4 = new JButton("-");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1 = txt.getText().toString();
				txt.setText("");
				op = "-";
			}
		});
		
		JButton btn5 = new JButton("*");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1 = txt.getText().toString();
				txt.setText("");
				op = "*";
			}
		});
		
		JButton btn6 = new JButton("/");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value1 = txt.getText().toString();
				txt.setText("");
				op = "/";
			}
		});
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Calculator");
	}
	

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		txt.setText(txt.getText()+actionCommand);
	}
	public static void main(String[] args) {
		new Calculator();
	}

}
