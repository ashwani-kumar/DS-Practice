
public class LamdaExpRunnableTesting {

	
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 3; i++) {
					System.out.println("[ Hello world from thread "+
							Thread.currentThread().getName()+
							"]");
				}
			}
			
		};
		
		Runnable lambdaRunnable = () -> {
			// TODO Auto-generated method stub
			for(int i = 0; i < 3; i++) {
				System.out.println("[ Hello world from 	thread "+
						Thread.currentThread().getName()+
						"]");
			}
		};
		
		Thread t = new Thread(lambdaRunnable);
		t.start();
		t.join();
	}
}
