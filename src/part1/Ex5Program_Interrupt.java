package part1;

public class Ex5Program_Interrupt {

	public static void main(String[] args) {
		
		Thread th = Thread.currentThread();
		th.setName("Main");

		
		Runnable subMain = new Runnable() {
			
			@Override
			public void run() {
				System.out.printf("%s : %s\n", th.getName(), th.getState());

				print();
				System.out.printf("%s : %s\n", th.getName(), th.getState());

			}
		};
		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		
		// 아직 실행하지 않은 상태 // sub1 : NEW
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());

		
		th1.start();
		
		// 실행가능한 상태(Runnable) // sub1 : RUNNABLE
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());

		
		print();
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());

		if(th1.isAlive()) {
			try {
				// 2초 동안 기다려준다
				th1.join(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// interrupt( )를 받은 스레드가 프로그램의 종료 여부를 결정한다
			th1.interrupt();
		}
		
		System.out.println("======== Main Exit ============");
	}

	private static void print() {
		
		Thread th = Thread.currentThread();
		
		
		
		for(int i = 0; i < 1000000000; i++) {
			try {
				// sleep( )도중 interrupted( )하면 스레드가 깨어난게 된다
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				
//				e.printStackTrace();
				System.out.println("우왓... 누가 날 깨운거야");
			}
			
			if(th.isInterrupted()) {
				System.out.println("----- Th Interrupted -----");
				return;
			}
			
			if(th.getName().equals("Main"))
				System.out.printf("<%s[%d] : %d>\n",th.getName(), th.getId(), i+1);
			else
				System.out.printf("%s[%d] : %d\n",th.getName(), th.getId(), i+1);

		}
		
	}
	

}
