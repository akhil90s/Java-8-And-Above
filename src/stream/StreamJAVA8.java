package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamJAVA8 {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = getListOfInteger();

		// Find out sum of all integers greater than 10
		int sumOfAllIntegersGreaterThan10 = listOfIntegers.stream().filter((Integer i) -> i > 10).mapToInt(i -> i)
				.sum();
		System.out.println(sumOfAllIntegersGreaterThan10);
		
		// Find duplicate elements in a list using stream functions
		Set<Integer> set = new HashSet<>();
		List<Integer> dublicateElements = listOfIntegers.stream().filter(n->!set.add(n)).collect(Collectors.toList());
		System.out.println(dublicateElements);
		
		// Find the total number of all the elements 
		long countOfElements = listOfIntegers.stream().count();
		System.out.println(countOfElements);
		
		// Find first non-repeated character in the string
		String input = "Java Hungry Blog Alive is Awesome";
		Character resultNonRepeatedCharacter = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(resultNonRepeatedCharacter);

		// Find first repeated character in the string
		Character resultFirstRepeatedCharacter = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(resultFirstRepeatedCharacter);
		
	}
	
	static List<Integer> getListOfInteger() {

		List<Integer> listOfInteger = new ArrayList<>();
		Collections.addAll(listOfInteger, 11, 3, 5, 20, 4, 3, 21, 45, 98, 21, 98);
		return listOfInteger;
	}
	

}
