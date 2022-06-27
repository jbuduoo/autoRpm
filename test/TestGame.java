package jb.com;

import java.nio.file.FileSystemLoopException;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;

public class TestGame {

	public static void main(String[] args) {
		String[] balls= {"r","g","gray"};
		String[] balls2= {"g","r"};
		String[] balls3= {"grey","r","g"};
		String[] balls4= {"g","r","g"};
		String[] balls5= {"g","g","grey","g","r"};
		String[] balls6= {"grey","grey","grey"};
		String[] balls7= {"g","grey","g"};
		String[] balls8= {"g","grey","r"};
		String[] balls9= {"r","r","grey"};
		play(balls);
		play(balls2);
		play(balls3);
		play(balls4);		
		play(balls5);	
		play(balls6);	
		play(balls7);	
		play(balls8);	
		play(balls9);
	}
	
	public static void play(String[] str) {
		HashMap<String,String> map=new HashMap<>();

		for (int i = 0; i < str.length;i++) {

			if (map.get("1") == null) {
				map.put("1", str[i]);
			} else {
				if (map.get("1") == "r") {
					break;
				}else if(map.get("1") == "g") {
					if(str[i].equals("r")) {
						map.put("1", str[i]);
					}
				}else {
					if(str[i].equals("r")) {
						map.put("1", str[i]);
					}else if(str[i].equals("g")) {
						map.put("1", str[i]);
					}
				}
			}
		}
		System.out.println("end:"+map.toString());

		
		
	}

}
