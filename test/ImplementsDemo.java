package jb.com;

/*
 * 线程不安全的问题分析：在小朋友抢气球的案例中模拟网络延迟来将问题暴露出来
 * 解決方法，同步鎖 synchronized 
 */
public class ImplementsDemo {
	public static void main(String[] args) {
		Balloon balloon = new Balloon();
		new Thread(balloon, "小红").start();
		new Thread(balloon, "小强").start();
		new Thread(balloon, "小明").start();
	}
}

// 气球
class Balloon extends Thread {

	private int num = 50;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
//			synchronized (this) {             
				if (num > 0) {
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + " 抢到了" + (num--) + "号气球");
				}
			}
//		}
	}
}