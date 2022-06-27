package jb.com;

public class TryCatchTest01 {

	public static void main(String[] args) {
		try {
			run();
		}catch(Exception e) {
			System.out.println("a1");
			e.printStackTrace();
			System.out.println("a2");
		}
	}
	
	public static void run() {
		String abc="123";
		int num =5;
		try {
			num=num/0;
		}catch(Exception e) {
			System.out.println("1");
			e.printStackTrace();
			String ioeException= e.getMessage();
			if(ioeException.contains("by zero")) {
				System.out.println("硬碟空間不足");
			}
			abc="526";
		}
		
		System.out.println("1111"+abc);
	}

}
