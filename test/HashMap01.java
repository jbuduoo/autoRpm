package jb.com;

import java.util.HashMap;

public class HashMap01 {

	public static void main(String[] args) {
        //STR01,alarm.Level2@12345,alarm.Level2@STR02,alarm.Level2@STR01,alarm.Level3
        HashMap<String, String> Sites = new HashMap<String, String>();
        // 添加键值对
        Sites.put("STR01", "alarm.Level3");    
        Sites.get("STR01").equals("fuck");
        Sites.put("STR01", "alarm.Level2");
        Sites.put("12345", "alarm.Level2");

        System.out.println(Sites);

	}

}
