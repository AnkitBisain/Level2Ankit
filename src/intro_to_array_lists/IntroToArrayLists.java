package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		// 1. Create an array list of Strings
		ArrayList<String> strings = new ArrayList<String>();
		// Don't forget to import the ArrayList class

		// 2. Add five Strings to your list
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("e");
		// 3. Print all the Strings using a standard for-loop
		System.out.println("All strings:");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		// 4. Print all the Strings using a for-each loop
		System.out.println("All strings:");
		for (String s : strings) {
			System.out.println(s);
		}
		// 5. Print only the even numbered elements in the list.
		System.out.println("All even numbered strings:");
		for (int i = 0; i < strings.size(); i+=2) {
			System.out.println(strings.get(i));
		}
		// 6. Print all the Strings in reverse order.
		System.out.println("All strings in reverse order:");
		for (int i = strings.size()-1; i > -1; i--) {
			System.out.println(strings.get(i));
		}
		// 7. Print only the Strings that have the letter 'e' in them.
		System.out.println("All strings with \"e\":");
		for (String s : strings) {
			if (s.contains("e")) {
				System.out.println(s);
			}
		}
	}
}
