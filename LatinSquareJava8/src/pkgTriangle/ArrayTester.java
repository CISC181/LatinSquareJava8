package pkgTriangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTester {
	private static boolean containsDuplcates(int[] arr) {
		//	How to convert an array of ints into a array of Integers
		// Integer[] numbers = Arrays.stream(arr).boxed().toArray(Integer[]::new);		
		
		//	Create a new HashSet.  The HashSet will only accept unique values (by hashcode)
		Set<Integer> allItems = new HashSet<>();
		
		//	'duplicates' will be a set of values that are duplicate in the array.  If the size is > 0, you have a duplicate item
		Set<Integer> duplicates = Arrays.stream(Arrays.stream(arr).boxed().toArray(Integer[]::new)).filter(n -> !allItems.add(n)).collect(Collectors.toSet());
		return (duplicates.size() > 0);
	}

	private static boolean hasAllValues(int[] arr1, int[] arr2) {
		//	This will return a true if every item from arr2 is in arr1, otherwise false
		return IntStream.of(arr2).boxed().collect(Collectors.toCollection(HashSet::new))
				.containsAll(IntStream.of(arr1).boxed().collect(Collectors.toCollection(HashSet::new)));
	}

	private static int[] getColumn(int[][] arr2D, int c) {
		return IntStream.range(0, arr2D.length).map(i -> arr2D[i][c]).toArray();
	} 

	public static boolean isLatin(int[][] square) {

		if (containsDuplcates(square[0]))
			return false;
		
		for (int a = 0; a < square.length - 1; a++) {
			if (!hasAllValues(square[0], square[a + 1]) || (!hasAllValues(square[0], getColumn(square, a + 1))))
				return false;
		}
		return true;
	}
}
