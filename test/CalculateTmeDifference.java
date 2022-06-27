package jb.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateTmeDifference {

	public static void main(String[] args) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d1 = new Date();
			for (int i = 0; i < 1000000; i++) {
				System.out.println(i);
			}

			Date d2 = new Date();
			long time = d2.getTime() - d1.getTime();

			System.out.println("days:"+time);
		} catch (Exception e) {
		}

	}

}
