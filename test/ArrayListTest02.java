package jb.com;

import java.util.ArrayList;

public class ArrayListTest02 {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		list.add("");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");

		
		c.ProcessBuilder(list);
		
		
		String[] str= new String[list.size()];
		list.toArray(str);
		System.out.println(list);System.out.println(str);
	}
	

}

class c{
    public static void ProcessBuilder(ArrayList<String> list) {
    	list.add("ccc");
    	list.add("ccc");
    	list.add("ccc");
    	list.add("ddd");
    }
	
}
