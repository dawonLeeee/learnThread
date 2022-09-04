package part2;

public class Ex1Program {

	public static void main(String[] args) {
		
		
		Runnable subMain = new Runnable() {
			
			@Override
			public void run() {
				print();
			}
		};
		
	
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(subMain);
		th3.setName("sub3");
		
		

		
		th1.start();
		th2.start();
		th3.start();
		
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

		
		
//		if(th1.isAlive()) // th1이 동작중인지 확인 후
//			th1.interrupt();
//		if(th2.isAlive()) 
//			th2.interrupt();
//		if(th3.isAlive()) 
//			th3.interrupt();
//		if(th4.isAlive()) 
//			th4.interrupt();
//		if(th5.isAlive()) 
//			th5.interrupt();
//		if(th6.isAlive()) 
//			th6.interrupt();
	
		
		
		
		System.out.println("====== exit ======");
	}

	static int gIndex = 0; // 전역변수 선언(데이터/정적 영역)-->모든 스레드가 공유
	
	private static void print() {
		
		int index = 0; // 스택(-->스레드별로 개별적으로 생성)
		
		Thread th = Thread.currentThread();
		

		for(int i = 0; i < 100; i++) {
			if(th.isInterrupted()) {
				System.err.println("요청이 들어와서 종료함");
				return;
			}

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("자다가 깨서 스레드를 종료함");
				e.printStackTrace();
			}
			
			index++;
			gIndex++;
			
			System.out.printf("%s[%d] : %d, index = %d, gIndex : %d\n",th.getName(), th.getId(), i+1, index, gIndex);

		}
		
	}
	

}
