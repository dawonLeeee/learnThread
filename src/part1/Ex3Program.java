package part1;

public class Ex3Program {

	public static void main(String[] args) {
		
		
		Runnable subMain = new Runnable() {
			
			@Override
			public void run() {
				print();
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

		
		Thread th = Thread.currentThread();
		th.setName("Main");
		print();
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());

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
				System.out.printf("<%s[%d] : %d>\n",th.getName(), th.getId(), i+1);
			else
				System.out.printf("%s[%d] : %d\n",th.getName(), th.getId(), i+1);

		}
		
	}
	

}
