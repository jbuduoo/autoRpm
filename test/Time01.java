package jb.com;

public class Time01 {


	public static void main(String[] args) {
		formatTime("");
		formatTime(null);
		formatTime("00:11");
		formatTime("  00:09:56.50  ");//9 min 56 sec
		formatTime("  01:09:56.50  ");//1 hour 9 min 56 sec
		formatTime("  00:00:00.50  ");//0 sec
		formatTime("  00:00:56.50  ");//56 sec
	}

	/**
	 *  將00:09:56.50 改成9 min 56秒
	 * @param time String
	 * @return String
	 */
	public static String formatTime(String time) {
		String timeStr = "";
		if (time == null || time.equals("")) {
			return time;
		}
		time = time.trim();
		int index = time.indexOf(".");
		if (index > 0) {
			time = time.substring(0, index);

			String[] timeArray = time.split(":");

			if (timeArray.length == 3) {
				int hours = Integer.parseInt(timeArray[0]);
				int min = Integer.parseInt(timeArray[1]);
				int sec = Integer.parseInt(timeArray[2]);
				if (hours > 0) {
					timeStr = hours + " hour " + min + " min " + sec + " sec";
				} else if (min > 0) {
					timeStr = min + " min " + sec + " sec";
				} else {
					timeStr = sec + " sec";
				}

			}
		}

		System.out.println(timeStr);
		return timeStr;
	}

}
