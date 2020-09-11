package java_191028;

import java.io.*;

class BinaryFile{
	void readBinary() {
		//데이터를 읽기 위해 Input 
		DataInputStream dis;
		BufferedInputStream bis;
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("d://data.bin");
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			int i = dis.readInt();
			System.out.format("저장된 학생의 수"+"%d"+"\n",i);
			
			/*교수님 방식
			i = dis.readInt();
			System.out.format("학번"+"%d",i);
			
			String s = dis.readUTF();
			System.out.format("이름 : "+"%s",s);
			
			i = dis.readInt();
			System.out.format("점수"+"%d"+"\n",i);
			
			i = dis.readInt();
			System.out.format("학번"+"%d",i);
			
			String s1 = dis.readUTF();
			System.out.format("이름 : "+"%s",s1);
			
			i = dis.readInt();
			System.out.format("점수"+"%d"+"\n",i);
			*/
			
			//학번이 99번인 학생의 점수를 출력
			
			int hakbun, score;
			String name;
//		
//			for(int b=0; b<i; b++) {
//				hakbun = dis.readInt();
//				name = dis.readUTF();
//				score=dis.readInt();
//				if(hakbun==99) {
//					System.out.format("학번:" +"%d"+"이름: "+"%s" + " 점수: "+"%d"+"\n", hakbun, name, score);
//				}
//				
//				
//			}
			
			//학번이 홀수인 학생의 평균 점수를 구하시오(학생수, 총점수, 평균점수)
			int hap=0, count=0;
			double avg=0;
			System.out.printf("학번이 홀수인 학생의 평균 점수");
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
			System.out.format("학생 수" +"%d"+"총 점수: "+"%d" + " 평균점수: "+"%.2f"+"\n", count, hap, avg);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void test1(){
		//자료형 형태로 저장하기 위해 DataOutputStream 객체를 생성함
		DataOutputStream dos;
		BufferedOutputStream bos;
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream("d:\\data.bin");//파일의 바이트 단위
			bos = new BufferedOutputStream(fos);//바이트의 배열형태로 저장함 파일에
			dos = new DataOutputStream(bos); //데이터타입에 따라서 저장할 수 있는 메서드
			
			dos.writeInt(2);
			
			//학번
			dos.writeInt(1);
			//이름
			dos.writeUTF("내다");
			//국어점수
			dos.writeInt(10);
			
			/* 두번째 */
			dos.writeInt(2);
			//이름
			dos.writeUTF("My");
			//국어점수
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
