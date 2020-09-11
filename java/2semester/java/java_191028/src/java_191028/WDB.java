package java_191028;

import java.io.*;

class BinaryFile{
	void readBinary() {
		//�����͸� �б� ���� Input 
		DataInputStream dis;
		BufferedInputStream bis;
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("d://data.bin");
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			int i = dis.readInt();
			System.out.format("����� �л��� ��"+"%d"+"\n",i);
			
			/*������ ���
			i = dis.readInt();
			System.out.format("�й�"+"%d",i);
			
			String s = dis.readUTF();
			System.out.format("�̸� : "+"%s",s);
			
			i = dis.readInt();
			System.out.format("����"+"%d"+"\n",i);
			
			i = dis.readInt();
			System.out.format("�й�"+"%d",i);
			
			String s1 = dis.readUTF();
			System.out.format("�̸� : "+"%s",s1);
			
			i = dis.readInt();
			System.out.format("����"+"%d"+"\n",i);
			*/
			
			//�й��� 99���� �л��� ������ ���
			
			int hakbun, score;
			String name;
//		
//			for(int b=0; b<i; b++) {
//				hakbun = dis.readInt();
//				name = dis.readUTF();
//				score=dis.readInt();
//				if(hakbun==99) {
//					System.out.format("�й�:" +"%d"+"�̸�: "+"%s" + " ����: "+"%d"+"\n", hakbun, name, score);
//				}
//				
//				
//			}
			
			//�й��� Ȧ���� �л��� ��� ������ ���Ͻÿ�(�л���, ������, �������)
			int hap=0, count=0;
			double avg=0;
			System.out.printf("�й��� Ȧ���� �л��� ��� ����");
			for(int b=0; b<i; b++) {
				hakbun = dis.readInt();
				name = dis.readUTF();
				score=dis.readInt();
				
				if(hakbun%2==1) {
					hap = hap+score;
						 count++;
					}
				}
			avg = (double)hap/count;
			System.out.format("�л� ��" +"%d"+"�� ����: "+"%d" + " �������: "+"%.2f"+"\n", count, hap, avg);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void test1(){
		//�ڷ��� ���·� �����ϱ� ���� DataOutputStream ��ü�� ������
		DataOutputStream dos;
		BufferedOutputStream bos;
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream("d:\\data.bin");//������ ����Ʈ ����
			bos = new BufferedOutputStream(fos);//����Ʈ�� �迭���·� ������ ���Ͽ�
			dos = new DataOutputStream(bos); //������Ÿ�Կ� ���� ������ �� �ִ� �޼���
			
			dos.writeInt(2);
			
			//�й�
			dos.writeInt(1);
			//�̸�
			dos.writeUTF("����");
			//��������
			dos.writeInt(10);
			
			/* �ι�° */
			dos.writeInt(2);
			//�̸�
			dos.writeUTF("My");
			//��������
			dos.writeInt(10);
			
			dos.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class WDB {
	public static void main(String[] args) {
		BinaryFile bf = new BinaryFile();
		bf.readBinary();
	}

}
