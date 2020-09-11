

public class Producer implements Runnable{
	Buffer buffer;

	//������
	public Producer(Buffer buffer2) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			buffer.put(i);
			
			try {
				Thread.sleep((long) (Math.random()*100));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
