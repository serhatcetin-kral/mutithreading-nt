package multiThreadingNt;

import java.util.concurrent.ArrayBlockingQueue;

public class BockQueue {

	
	
    static public int count=1; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
		
		Producer producer=new Producer(queue);
		
		Thread th1=new Thread(producer,"th1");
		th1.start();
		
		Consumer consumer=new Consumer(queue);
		Thread th2=new Thread(consumer,"th2");
		th2.start();
		
	}

}



class Producer implements Runnable{

	
	private ArrayBlockingQueue<Integer> queue;
	
	public Producer(ArrayBlockingQueue<Integer> queue) {
		
		this.queue = queue;
	}
	
	
	@Override
	public void run() {
	
		
		
		while(true){
			
			try {
				Thread.sleep(1000);
				queue.put(BockQueue.count);
				System.out.println("currently adding message order  "+BockQueue.count);
				BockQueue.count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}
	
}


class Consumer implements Runnable{
	private ArrayBlockingQueue<Integer> queue;
	

	public Consumer(ArrayBlockingQueue<Integer> queue) {
	
		this.queue = queue;
	}
	
	@Override
	public void run() {
while(true){
			
			try {
				Thread.sleep(2000);
				queue.put(BockQueue.count);
				BockQueue.count--;
				System.out.println(" message removed "+BockQueue.count);
				
			} catch (InterruptedException e) {
				System.out.println("consumer not working");
			}
			
			
			
			
		}
		
	}



	
	
	
	
	
	
	
	
	
	
	
}
