package jb.com;

import java.util.Vector;

/*
 * Vector线程不安全的写法
 */
public class Test {
	 private static Vector<Integer> vector = new Vector<Integer>();
	 
     public static void main(String[] args) {
         while (true) {
             for (int i = 0; i < 10; i++) {
                 System.out.println("添加");
                 vector.add(i);
             }
//             try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
             Thread removeThread = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     for (int i = 0; i < vector.size(); i++) {
                         System.out.println("removeThread删除:"+vector.size());
                         vector.remove(i);
                     }
                 }
             });

//             Thread printThread = new Thread(new Runnable() {
//                 @Override
//                 public void run() {
//                     for (int i = 0; i < vector.size(); i++) {
//                         System.out.println("printThread获取");
//
//                         System.out.println((vector.get(i)));
//                     }
//                 }
//             });

             removeThread.start();
//             printThread.start();

             //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20);
         }
     }
}


