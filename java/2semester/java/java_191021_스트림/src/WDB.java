

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WDB {
	public static void pipe() {
		FileReader fr; //���ڴ��� ��Ʈ���� ó����
		BufferedReader br; //�ٴ����� ó��
		
		//������ ����
		try {
			fr = new FileReader("d://abc.txt");
			//���� ���ϰ� ����ϱ� ���� �ٴ��� ó�� Ŭ������ BufferedReader�� ���
			//�� Ŭ������ �Ű������� FIleReader��ü�� �޴´�
			br = new BufferedReader(fr);
			String s = br.readLine();
			System.out.println(s);
			
			String b = br.readLine();
			System.out.println(b);
			
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void characterStream() {
		FileReader in = null;
		FileWriter out = null;
		int i;
		try {
			in = new FileReader("d:\\abc.txt");
			out = new FileWriter("d:\\����.txt");
			int count=0;
			while( (i=in.read() )!=-1) {
				System.out.println(count + ":" + i);
				out.write(i+1);
				count ++;
			}
			
			i=in.read();
			System.out.println(i);
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void byteStream(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			//������ ����
			in = new FileInputStream("d:\\abc.txt");
			
			//�Ű������� �� ������ ������ �����ϰ� ������ ���� ����
			out = new FileOutputStream("d:\\zzz.txt");
			//read�ϸ� �� ����Ʈ �о�� 
			//������ �ݴ´�
			
			int i;
			int count=0;
			while( (i=in.read() )!=-1) {
				System.out.println(count + ":" + i);
				out.write(i+1);
				count ++;
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("������ Ȯ���ϼ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ �ݱ����");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		pipe();
	}

}
