package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamJAVA8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// differentWaysOfStreamCreation();

		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

		boolean matchedResult = memberNames.stream().
				
				anyMatch((s) -> s.startsWith("A"));

	}

	static void differentWaysOfStreamCreation() {

		/// Stream Creation
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

		Stream<Integer> stream = list.stream();
		stream.forEach(p -> System.out.println(p));

		System.out.println(stream.count());

	}

	static void streamToTheCollection() {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);

		System.out.println(evenNumbersArr);

		/// List<Integer> evenNumbersList = stream.filter(i -> i % 2 ==
		/// 0).collect(Collectors.toList());
		// System.out.print(evenNumbersList);

	}

}
