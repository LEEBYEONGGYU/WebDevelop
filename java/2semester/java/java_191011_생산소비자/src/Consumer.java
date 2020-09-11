

public class Consumer implements Runnable{

	Buffer buffer;

	public Consumer(Buffer buffer1) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer1;
	}

	@Override
	public void run() {
		int data;
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			data = buffer.get();
		}
	}
}
