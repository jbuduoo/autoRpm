package jb.com;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		play(list);
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		play2(list);
		list.add("adasfd");
		System.out.println(list.toString());
	}
	public static void play(ArrayList<String> list) {
		list.add("2");
		play2( list);
	}
	public static void play2(ArrayList<String> list) {
		list.add("eeeeeee");
	}
}
