package p190711;

import java.util.Random;

public class project_190711 {

	static class Student {
		public String name;
		char 성별;
		int 나이;

		public int kor;
		public int eng;
		public int math;

		public void print성적() {
			System.out.print(kor + " ");
			System.out.print(eng + " ");
			System.out.print(math + " ");
		}

		public int sum;
		public double avg;

		public void 합계() {
			sum = kor + eng + math;
			System.out.print("합계 " + sum + " ");

		}

		public void 평균() {
			avg = sum / 3.0;
			System.out.printf("%6.2f \n", avg);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		// Student 객체 100개를 저장할 배열 생성
		Student[] array = new Student[100];
		// 변수초기화
		int kavg = 0, eavg = 0, mavg = 0;

		// 2배열의 객체를 저장함
		for (int i = 0; i < 100; i++) {
			Student object = new Student();
			array[i] = object;
			
			object.name="이병규"+i+" ";// 이름에다가 +i
			int age = random.nextInt(2);

			switch (age) {
			case 0:
				object.성별 = '남';
				break;
			case 1:
				object.성별 = '여';
				break;
			}
			
			object.나이 = random.nextInt(31)+20;
			System.out.print(object.name + object.성별 + " " + object.나이 +"\n");
			
		}
	}
}



/*
 * //2.1 student객체에 국어 영어 수학 성적 입력 
 * 
 * object.name="이병규"+i+" ";//이름에다가 +i
 * object.kor= random.nextInt(101);
 *  object.eng= random.nextInt(101);;
 * object.math= random.nextInt(101);
 * 
 * //student객체 배열 저장 
 * //평균구하는 친구들
 *  kavg = kavg+array[i].kor; eavg = eavg+array[i].eng; mavg =
 * mavg+array[i].math; } 
 * 
 * for(int j=0; j<array.length; j++) { array[j].이름();
 * array[j].print성적();
 *  array[j].합계(); array[j].평균();
 * 
 * }
 * System.out.println("국어평균 "+kavg/100.0+" 영어평균 "+eavg/100.0+" 수학평균 "+mavg/100.0
 * );
 */

// 이름 : 홍길동 0~99 성별 : random으로 0과 1 나이는 20~50

 
