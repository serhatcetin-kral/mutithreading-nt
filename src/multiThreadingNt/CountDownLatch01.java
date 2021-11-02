package multiThreadingNt;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDownLatch latch=new CountDownLatch(6);
		
		ThreadCreator2 thread1=new ThreadCreator2(latch);
		ThreadCreator2 thread2=new ThreadCreator2(latch);
		ThreadCreator2 thread3=new ThreadCreator2(latch);
		ThreadCreator2 thread4=new ThreadCreator2(latch);
		ThreadCreator2 thread5=new ThreadCreator2(latch);
		ThreadCreator2 thread6=new ThreadCreator2(latch);
		ThreadCreator2 thread7=new ThreadCreator2(latch);
//		ThreadCreator2 thread8=new ThreadCreator2(latch);
//		ThreadCreator2 thread9=new ThreadCreator2(latch);
//		ThreadCreator2 thread10=new ThreadCreator2(latch);
		
		//thread1.setName("thread1");
		thread1.start();
		//thread2.setName("thread2");
		thread2.start();
		//thread3.setName("thread3");
		thread3.start();
		//thread4.setName("thread4");
		thread4.start();
		//thread5.setName("thread5");
		thread5.start();
		//thread6.setName("thread6");
		thread6.start();
		//thread7.setName("thread7");
		thread7.start();
//		//thread8.setName("thread8");
//		thread8.start();
//		//thread9.setName("thread9");
//		thread9.start();
//		//thread10.setName("thread10");
//		thread10.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("latch await waiting for run something wrong");
		}
		
		System.out.println("all threads done now another application need to be work");
		System.out.println("===============");
	}

}

class ThreadCreator2 extends Thread{
	
	private CountDownLatch latch;
	
	
	public ThreadCreator2(CountDownLatch latch) {
		
		this.latch = latch;
	}
	
	
	@Override
	public void run() {

		
		System.out.println(Thread.currentThread().getName()+" threads start running");
		System.out.println(Thread.currentThread().getName()+" threads stop working");
		System.out.println("==============");
		
		latch.countDown();
		
		
	}

	
	
	
	
	
	
}