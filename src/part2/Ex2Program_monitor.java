package part2;

public class Ex2Program_monitor {

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

		
		System.out.println("====== exit ======");
	}

	static Object lockIndex = new Object(); //스레드가 이 정보를 가지고 스레드로 들어갈 수 있도록 변수 하나 생성
	static int gIndex = 0; 
	
	private static void print() {
		
		int index = 0; 
		
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
			
			//lock으로 잠금을 해야 하는 상황
			synchronized (lockIndex) { // 이 lockIndex를 소유한 스레드만 이 안에 들어올 수 있음
				index++;
				gIndex++;
				
				System.out.printf("%s[%d] : %d, index = %d, gIndex : %d\n",th.getName(), th.getId(), i+1, index, gIndex);

			}
		}
		
	}
	

}
