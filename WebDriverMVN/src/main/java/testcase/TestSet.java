package testcase;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		System.err.println("Size : "+set.size());
		set.add("A");
		System.err.println("Size : "+set.size());
		set.remove("B");
		System.err.println("Size : "+set.size());

	}
}
