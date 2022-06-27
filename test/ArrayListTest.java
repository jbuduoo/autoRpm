package jb.com;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		list.add("");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");
		System.out.println(list);
		String[] str= new String[list.size()];
		list.toArray(str);
		
		ProcessBuilder(str);
	}
	
    public static void ProcessBuilder(String... command) {
    	ArrayList<String> command2=null;
        command2 = new ArrayList<>(command.length);
        for (String arg : command)
            command2.add(arg);
        System.out.println("ProcessBuilder");
        System.out.println(command);
    }
    
}
