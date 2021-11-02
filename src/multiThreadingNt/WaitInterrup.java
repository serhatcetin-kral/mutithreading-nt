package multiThreadingNt;

public class WaitInterrup {

	
	public static double balance=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WaitInterrup obj1=new WaitInterrup();
		 Thread thread1=new Thread(new Runnable() {

			@Override
			public void run() {
				
				obj1.withDraw(1000);
			}
			 
			 
			 
		 }); 
		 thread1.setName("thread1");
		 thread1.start();
		 Thread thread2=new Thread(new Runnable() {

			@Override
			public void run() {
				
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				obj1.deposit(50000);
				 thread1.interrupt();
			}
			 
			 
			 
		 });
		 thread2.setName("thread2");
		 thread2.start();
		
		
		
		
		
		
	}

	
	
	public void withDraw(double amount) {
		synchronized(this) {
		if(balance==0 || balance<amount) {
			
			
			try {
				System.out.println("waiting for updating balance");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("interrup prosecc runnuning");
				balance=balance-amount;
				   System.out.println("withdraw is successful current balance is "+balance);
			}
		} }
		
		
	}
	
	
	
	
	public void deposit(double amount) {
		
		
		balance=balance+amount;
		System.out.println("balance is updated now uddated balance is "+balance);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
