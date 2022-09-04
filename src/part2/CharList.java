package part2;

public class CharList {
	private char[] list;
	private int index;
	
	public CharList() {
		list = new char[240];
		for(int i = 0; i < 240; i++)
			list[i] = (char)i;
			
		index = 0;
		
	}
	
	public void printNext() { // 메서드 자체에 synchronized 처리할 수 있다
		Thread th = Thread.currentThread();
		
		
		char ch = list[index];
		
		try {
			Thread.sleep(20);
		} catch(InterruptedException e) {
			System.out.println("자다가 깨서 스레드를 종료함 ");
			return;
		}
		

		synchronized(this) {
			System.out.printf("%s[%d] = index:%d, char:%c\n",
					th.getName(), th.getId(),index, list[index]);

			index++;
		}
		
		// 동기화되지 않았기 때문에 이 작업이 일어나느 중간에 다른 스레드가 끼어들면 같은 값이 츨력되게 된다
	}
}
