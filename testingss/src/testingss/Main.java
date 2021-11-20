package testingss;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		forTest();

		String s1 = "Tolga";
		String s2 = "Tolga";
		String s3 = new String("Tolga");
		String s4 = new String("Tolga");
		
		if(s1 == s2)
			System.out.println("s1 equals s2");
		if(s2 != s3)
			System.out.println("s2 doesnt equal s3");
		if(s1 != s3)
			System.out.println("s1 doesnt equal s3");
		if(s3 != s4)
			System.out.println("s3 doesnt equal s4");

		arrayTest(new int[] {1, 1, 3, 7, 7, 8, 9, 9, 9, 10});

		String [] array = {"tolga", "ali", "veli", "tolga","ali", "ceren"};
		Set<String> stringSet = new HashSet<>(Arrays.asList(array));
		String[] filteredArray = stringSet.toArray(new String[0]);
		for(String s: filteredArray) {
			System.out.println(s);
		}
		
		int [] intArray = {1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		 Set<Integer> setInt = new LinkedHashSet<Integer>();
		    for(int i=0;i<intArray.length;i++){
		    	setInt.add(intArray[i]);
		    }
		    System.out.println(setInt);

		Integer[] origArray = new Integer[] { 1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 12, 15, 12, 16, 1 };
		System.out.println(Arrays.toString(origArray));
		Integer[] tempArray = removeDuplicates(origArray);
		System.out.println(Arrays.toString(tempArray));

		int[] primitiveArray = new int[] { 1, 1, 3, 7, 7, 8, 9, 9, 9, 10 };
		Integer[] complexArray = Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);
		
		switchMethod(8);

	}

	static void forTest() {
		int i = 0;
		for (; i < 10; i++) {
			System.out.println("testing");
		}
		System.out.println(i);
	}

	static void arrayTest(int[] input) {
		int current = input[0];
		boolean found = false;

		for (int i = 0; i < input.length; i++) {
			if (current == input[i] && !found) {
				found = true;
			} else if (current != input[i]) {
				System.out.print(" " + current);
				current = input[i];
				found = false;
			}
		}
		System.out.print(" " + current);
	}

	private static Integer[] removeDuplicates(Integer[] origArray) {

		for (int j = 0; j < origArray.length; j++) {
			for (int i = j + 1; i < origArray.length; i++) {
				if (origArray[j] == origArray[i]) {
					origArray[i] = null;
				}
			}
		}
		return origArray;
	}
	
	private static void switchMethod(int number) {
		switch(number) {
		case 1 -> System.out.println("Tolga");
		default -> System.out.println("Ceren");
		}
	}
	
}
