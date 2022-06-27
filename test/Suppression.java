package jb.com;

import java.util.Vector;

import jb.com.SuppressionBean;
public class Suppression {
	
	public static Vector<SuppressionBean> suppressionData = new Vector<>();
	
	//測試資料
	//KHJM@alarm.System@ALL@;
	//ALL@ALL@ALL@;
	//ALL@ALL@alarm.CPU@;
	//KHJM@ALL@ALL@;
	
	static {
		suppressionData.add(new SuppressionBean("KHJM","alarm.System",""));
		suppressionData.add(new SuppressionBean("KHJM","alarm.System",""));
		suppressionData.add(new SuppressionBean("KHJM","alarm.System",""));
	}
	
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < suppressionData.size(); i++) {

			if (suppressionData.get(i).suppDevice == null || suppressionData.get(i).suppDevice.equals("")) {
				sb.append("ALL@");
			} else {
				sb.append(suppressionData.get(i).suppDevice + ",");
			}
			if (suppressionData.get(i).suppAlarmType == null || suppressionData.get(i).suppAlarmType.equals("")) {
				sb.append("ALL@");
			} else {
				sb.append(suppressionData.get(i).suppAlarmType + ",");
			}
			if (suppressionData.get(i).suppAlarmCategory == null || suppressionData.get(i).suppAlarmCategory.equals("")) {
				sb.append("ALL@");
			} else {
				sb.append(suppressionData.get(i).suppAlarmCategory + "@");
			}
		}
		System.out.println(sb.toString());

	}

}
