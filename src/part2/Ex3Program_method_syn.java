package part2;

public class Ex3Program_method_syn {

	public static void main(String[] args) {
		
		
		CharList list = new CharList();
		
		
		Runnable subMain = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 80; i++)
					list.printNext();
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

	
	

}
