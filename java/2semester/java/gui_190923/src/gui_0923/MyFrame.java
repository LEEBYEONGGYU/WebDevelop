package gui_0923;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
//이벤트 처리
//1. 이벤트 리스너 클래스를 작성한다(이벤트가 발생했을 때 처리하는 메소드(ActionPerformed를 정의하는 부분)
//추상메서드는 바디를 만들어줘야한다
class MyListener implements ActionListener{
	int cnt=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트 객체로 부터 어떤 버튼이 눌러졌는지 알아온다.
		
		Object o = e.getSource();
		JButton button = (JButton)o;//강제 형 변환
		
		cnt++;
		//버튼의 텍스트를 바꾼다
		//button.setText("X");
		
		int a = cnt%2;
		//클릭횟수로 ㄱㄱ
		if(a==1) {
			button.setText("X");


		}else{
			button.setText("O");
		}
		
	}
}
*/
//2. 이벤트 리스너를 이벤트 소스에 등록한다
public class MyFrame extends JFrame {
	private JButton button;
	public MyFrame() {
		setSize(300, 200);
		setTitle("이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		button = new JButton("O");
		JLabel label = new JLabel();
		
		//이벤트에 연결해주는 작업은~
		//외부클래스 button.addActionListener(new MyListenerin());
		//내부클래스button.addActionListener(new MyListenerin());
		
		add(button);
		add(label);
		
		setVisible(true);
	}
	
	//이벤트 리스너 클래스르 내부 클래스로 정의하는 방법
	//MyFrame클래스의 멤버 변수를 편리하게 접근 할 수 있다. 
	class MyListenerin implements ActionListener{
		int cnt=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			//이벤트 객체로 부터 어떤 버튼이 눌러졌는지 알아온다.
			
			Object o = e.getSource();
			JButton button = (JButton)o;//강제 형 변환
			
			cnt++;
			//버튼의 텍스트를 바꾼다
			//button.setText("X");
			
			int a = cnt%2;
			//클릭횟수로 ㄱㄱ
			if(a==1) {
				button.setText("X");


			}else{
				button.setText("O");
			}
			
		}
	}
}
