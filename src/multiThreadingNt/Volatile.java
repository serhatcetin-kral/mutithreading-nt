package multiThreadingNt;

public class Volatile {

	
	volatile public static int flag=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread thread1=new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
				if(flag==0) {
					
					System.out.println("thread  "+Thread.currentThread().getName()+" running");
				}else {
					
					break;
				}
				}
			}
			
			
			
			
		});
		
		thread1.setName("thread1");
		thread1.start();
		
		
		Thread thread2=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag=1;
				System.out.println("flag is updated and "+Thread.currentThread().getName()+" running");
				
			}
			
			
			
		});
		thread2.setName("thread2");
		thread2.start();
		
	
		
	}

}
