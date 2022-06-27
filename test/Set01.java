package jb.com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set01 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
    	for(int i= 0;i<6;i++){
		set.add(i+"");
    	}
    	set.add("1");		//重複資料，不會寫入
    	set.add(null);		//可以寫入空資料
    	Iterator<String> iter = set.iterator();
    	while(iter.hasNext()){
    		String abc=iter.next();
		System.out.println(abc);		//輸出是無序的
    	}
        System.out.println("Does the Set contains 'Geeks'? " + set.contains("Geeks")); 
	}

}
