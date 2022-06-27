package jb.com;

import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class JSONtest {

	// 取得server的台數，先預設為4 TODO
	public static String[] serverbean = { "1", "2", "3", "4" };
	private static ArrayNode cpuhourly2 = JsonNodeFactory.instance.arrayNode();
	public static ObjectNode cpuDataTable = JsonNodeFactory.instance.objectNode();
	public static long lastMin;
	private GregorianCalendar gc;
	
	
	//取得資料庫中所有的server資料
	public static void getServerBean() {
		
		//TODO
		
	}
	public static void main(String[] args) {
		System.out.println(cpuDataTable.toString());
		getDate();
		System.out.println(cpuDataTable.toString());
	}
	
	public void run() {
		long currentTime = System.currentTimeMillis();
		if ((currentTime - lastMin) > 60000) {
			gc.set(Calendar.SECOND, 0);
			gc.set(Calendar.MILLISECOND, 0);
			lastMin = gc.getTimeInMillis();
			saveDate();//每分鐘存一次資料，存到資料庫
		}
	}
	
	//每分鐘存一次資料，存到資料庫
	public void saveDate() {
		
	}
	
	//每次取資料時，呼叫這個方法。(可能有1小時，2小時，3小時，或一天 TODO )
	public static ObjectNode getDate() {
		getServerBean();
		// 把基本的架構弄出來
		ArrayNode rows = null;
		ObjectNode jsonObj = null;
		for (int i = 0; i < serverbean.length; i++) {
			rows = JsonNodeFactory.instance.arrayNode();
			jsonObj = JsonNodeFactory.instance.objectNode();
			jsonObj.put("borderColor", "#63b598"); // 取得顏色 TODO
			jsonObj.put("backgroundColor", "#63b598"); // 取得顏色 TODO
			jsonObj.put("label", "CPU" + serverbean[i]);// 取得serverName TODO
			jsonObj.set("data", rows);
			cpuhourly2.add(jsonObj);
		}
		cpuDataTable.set("code", JsonNodeFactory.instance.numberNode(0));
		cpuDataTable.set("message", JsonNodeFactory.instance.textNode("Success"));
		cpuDataTable.set("datasets", cpuhourly2);

		// 設定為0點0分0秒，每執行一次加一秒，共加1440次
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		gc.add(Calendar.MINUTE, 0 - 1440);

		HashMap<String, String> map = new LinkedHashMap<>();
		// init data 1440次
		int times =2;
		for (int i = times; i > 0; i--) {
			gc.add(Calendar.MINUTE, 1);
			long time = gc.getTimeInMillis();
			map.put("" + time, "0");
		}

		// 2.取得前8個字相同的，放入值
		map.put("1652405020000", "11111");

		// 3.再拿來放入到json裡
		for (String value : map.keySet()) {
			for (int j = 0; j < cpuhourly2.size(); j++) {
				rows = (ArrayNode) cpuhourly2.get(j).path("data");
				ObjectNode jsonObj2 = JsonNodeFactory.instance.objectNode();
				jsonObj2.put("x", value);
				jsonObj2.put("y", map.get(value));
				rows.add(jsonObj2);
			}
		}
		
		return cpuDataTable;
	}
	
}
