package java_191025;

import java.io.*;
import java.util.Scanner;

class Test{
	public void binaryFile() {
		FileOutputStream fos = null; //����Ʈ ���� ����
		BufferedOutputStream bos = null; //���� 
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("d:\\data.bin");
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			//40�� �������� �ϸ�
			dos.writeInt(40);
			
			int su=40;
			dos.writeInt(su);
			
			for(int i=0; i<su; i++) {
				//�й��� ���´�
				dos.writeInt(i+1);
				//����� 0
				dos.writeInt(0);
				//����� 256
				dos.writeInt(0xFF);
				//���м���
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
		FileReader fr = null; //���� ������ �о���� ��(�Է� ���ڽ�Ʈ��)
		BufferedReader br = null; //�� ����(����)
		FileWriter fw = null; //���� ����
		PrintWriter pw = null; //�ٴ��� ����
		
		
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
		//abc.txt�� FileReaderŬ������ �̿��� �����Ѵ�
		try {
			fr = new FileReader("d:\\abc.txt");
			//BufferedReader��ü�� �����Ѵ�
			br = new BufferedReader(fr);
			//Scanner ���ϳ���  ���ڵ����͸� ��ū ������ �о���� ���� Scanner��ü�� BufferReader ��ü�� �Ű������� ����Ͽ� ������
			s = new Scanner(br);
			
			//�迭 ����
			String[] index = new String[100];
			int count=0;
			int cnt = 0;
			while(s.hasNext()) {//���� ��ū�� �غ�Ǿ� ������ true ������ false
				if(cnt==2) {
					String a = s.next();
					double b = Double.parseDouble(a);
					System.out.println("�Ǽ�"+b);
					System.out.printf("�Ǽ�%f\n",b);
					System.out.printf("�Ǽ�%10.3f \n",b);
					System.out.printf("�Ǽ�"+"%10.3f" +"\n",b);
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
			System.out.println("���� ��������");
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
