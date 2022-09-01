package part1;

public class Ex6Program_Priority_Demon {

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
//		th2.setPriority(Thread.MIN_PRIORITY);
		th2.setDaemon(true); // 100까지 출력되지 않을 수 있다
		// Daemom : 보조업무를 다루는 스레드. (업무를 다루는게 아니라 업무를 다루는 다른 스레드가 일을 하다가 도와주는 것)
		// 대표적인 Daemon thread : GC는 Daemon thread에서 동작함.
		// 더이상 활성화된 스레드가 없으면 일을 다 마치지 못했더라도 종료한다
		// 다른 업무보다 순위가 낮게 설정하는게 일반적임.
		// 아직 실행하지 않은 상태 // sub1 : NEW
		

		
		th1.start();
		th2.start();
		
		

		
		Thread th = Thread.currentThread();
		th.setName("Main");
		print();
		
		

		System.out.println("======== Main Exit ============");
	}

	private static void print() {
		
		Thread th = Thread.currentThread();
		
		Thread thread = Thread.currentThread();
		
		System.out.println("------------------------");
		System.out.printf("Thread ID : Rs\n", thread.getId());
		System.out.printf("Thread Name : Rs\n", thread.getName());
		System.out.printf("Thread Priority : Rs\n", thread.getPriority());
		System.out.printf("Thread status : Rs\n", thread.getState());
		System.out.println("------------------------");
		
		
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if(th.getName().equals("Main"))
				System.out.printf("  <%s[%d] : %d>\n",th.getName(), th.getId(), i+1);
			else
				System.out.printf("%s[%d] : %d\n",th.getName(), th.getId(), i+1);

		}
		
	}
	

}
