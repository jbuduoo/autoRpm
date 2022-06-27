package jb.com;

public class StringBuilder01 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("<span>&nbsp;");
		sb.append("abadadf");
		sb.append("abadadf");
		sb.append("abadadf");
		sb.append("abadadf");
//		alarm[4]=DevicelistService.Devicelist();	
		sb.insert(4, "sssss");
		System.out.println("dddddddddd:"+sb.toString());


	}

}
