package testcase;

import java.util.LinkedList;
import java.util.List;


public class TestList {
	public static void main(String[] arg){
		List<String> list = new LinkedList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		System.out.println("Value at 1rs : "+list.get(1));
		System.err.println("Size : "+list.size());
		list.remove(2);
		
		System.err.println("Size : "+list.size());
		list.clear();
		System.err.println("Size : "+list.size());
	}
}
