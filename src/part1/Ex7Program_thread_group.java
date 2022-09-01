package part1;

public class Ex7Program_thread_group {

	public static void main(String[] args) {
		
		
		Runnable subMain = new Runnable() {
			
			@Override
			public void run() {
				print();
			}
		};
		
	//  중첩해서 그룹을 생성할 수 있다
		ThreadGroup thGroup = new ThreadGroup("print main group");
		ThreadGroup thGroup1 = new ThreadGroup(thGroup, "print sub1 group"); // 스레드그룹 부모를 둘 수 있다
		ThreadGroup thGroup2 = new ThreadGroup("print sub2 group");
		
		// new Thread(그룹이름, 스레드 이름) 넣어주면 스레드 그룹을 통해 해당 스테드를 관리할 수 있다
		Thread th1 = new Thread(thGroup1, subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(thGroup1, subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(thGroup1, subMain);
		th3.setName("sub3");
		Thread th4 = new Thread(thGroup2, subMain);
		th4.setName("sub4");
		Thread th5 = new Thread(thGroup2, subMain);
		th5.setName("sub5");
		Thread th6 = new Thread(thGroup2, subMain);
		th6.setName("sub6");
		
		
		

		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//interrupt전의 그룹상태 확인
		thGroup.list();
		
		//그룹이 있으면 해당 스레드들을 모두 interrupt할 수 있다
		thGroup.interrupt();
		
		//그룹을 통해 관리가능한 것 : 
		// 	현재 활성화되어 있는 스레드 갯수를 알 수 있다
		// 	일괄적으로 interrupt를 걸 수 있다
		
		
		
		
		//메인스레드가 종료 후 나머지 스레드를 종료시키고 싶다면 :
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
		// 이 방법보다 스레드 그룹을 만들어서 동시에 interrupt를 하는게 낫다
		
		
		
		System.out.println("====== exit ======");
	}

	private static void print() {
		
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
			
			
			if(th.getName().equals("Main"))
				System.out.printf("<%s[%d] : %d>\n",th.getName(), th.getId(), i+1);
			else
				System.out.printf("%s[%d] : %d\n",th.getName(), th.getId(), i+1);

		}
		
	}
	

}
