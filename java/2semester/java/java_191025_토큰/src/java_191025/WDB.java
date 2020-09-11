package java_191025;

import java.io.*;
import java.util.Scanner;

class Test{
	public void binaryFile() {
		FileOutputStream fos = null; //바이트 단위 저장
		BufferedOutputStream bos = null; //버퍼 
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("d:\\data.bin");
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			//40을 적으려고 하면
			dos.writeInt(40);
			
			int su=40;
			dos.writeInt(su);
			
			for(int i=0; i<su; i++) {
				//학번을 적는다
				dos.writeInt(i+1);
				//국어성적 0
				dos.writeInt(0);
				//영어성적 256
				dos.writeInt(0xFF);
				//수학성적
				dos.writeInt(0XF0F0);
			}
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void token() {
		Scanner s = null;
		FileReader fr = null; //문자 단위로 읽어오는 것(입력 문자스트림)
		BufferedReader br = null; //줄 단위(버퍼)
		FileWriter fw = null; //파일 쓰기
		PrintWriter pw = null; //줄단위 적음
		
		
	try {
		fw = new FileWriter("d:\\abcout.txt");
		pw = new PrintWriter(fw);
		fr = new FileReader("d:\\abc.txt");
		br = new BufferedReader(fr);
		s = new Scanner(br);
		
		
	} catch(FileNotFoundException e) {
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		//abc.txt를 FileReader클래스를 이용해 오픈한다
		try {
			fr = new FileReader("d:\\abc.txt");
			//BufferedReader객체를 생성한다
			br = new BufferedReader(fr);
			//Scanner 파일내의  문자데이터를 토큰 단위로 읽어오기 위해 Scanner객체를 BufferReader 객체를 매개변수로 사용하여 생성함
			s = new Scanner(br);
			
			//배열 생성
			String[] index = new String[100];
			int count=0;
			int cnt = 0;
			while(s.hasNext()) {//다음 토큰이 준비되어 있으면 true 없으면 false
				if(cnt==2) {
					String a = s.next();
					double b = Double.parseDouble(a);
					System.out.println("실수"+b);
					System.out.printf("실수%f\n",b);
					System.out.printf("실수%10.3f \n",b);
					System.out.printf("실수"+"%10.3f" +"\n",b);
				}else {
					
				
				String a = s.next();
				String e = "";
				System.out.println(a);
				index[count] = a;
				count++;
			}
				cnt++;
			}
			
			for(int i=0; i<count; i++) {
				pw.println(index[count-i-1]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못열었덩");
			e.printStackTrace();
		}
	}
}
public class WDB {
	public static void main(String[] args) {
		Test t= new Test();
		//t.token();
		t.binaryFile();
	}

}
