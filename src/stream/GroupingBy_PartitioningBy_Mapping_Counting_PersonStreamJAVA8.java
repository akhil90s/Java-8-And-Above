package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy_PartitioningBy_Mapping_Counting_PersonStreamJAVA8 {

	public static void main(String[] args) {
		List<Person> resultantList = populateWithData();

		System.out.println("-----Obtain US and Non-US based persons by using groupingBy and partitioningBy-----");

		Map<Boolean, List<Person>> a1 = resultantList.stream()
				.collect(Collectors.partitioningBy((Person p) -> p.getCountry().equals("US")));
		System.out.println(a1);
		Map<Boolean, List<Person>> a2 = resultantList.stream()
				.collect(Collectors.groupingBy((Person p) -> p.getCountry().equals("US")));
		System.out.println(a2);

		System.out.println("-----Count US and Non-US based persons by using groupingBy and partitioningBy-----");

		Map<Boolean, Long> b1 = resultantList.stream()
				.collect(Collectors.partitioningBy((Person p) -> p.getCountry().equals("US"), Collectors.counting()));
		System.out.println(b1);
		Map<Boolean, Long> b2 = resultantList.stream()
				.collect(Collectors.groupingBy((Person p) -> p.getCountry().equals("US"), Collectors.counting()));
		System.out.println(b2);

		System.out.println("-----Obtain persons in each of the country and count them using groupingBy-----");

		Map<String, List<Person>> c1 = resultantList.stream().collect(Collectors.groupingBy(Person::getCountry));
		System.out.println(c1);
		Map<String, Long> c2 = resultantList.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
		System.out.println(c2);

		System.out.println(
				"-----Obtain US and Non-US based persons by using partitioningBy and map names to uppercase using mapping-----");

		Map<Boolean, List<String>> d1 = resultantList.stream()
				.collect(Collectors.partitioningBy((Person p) -> p.getCountry().equals("US"),
						Collectors.mapping((Person p) -> p.getName().toUpperCase(), Collectors.toList())));
		System.out.println(d1);

		System.out.println(
				"-----Obtain persons in each of the country by using groupingBy and map names to uppercase using mapping-----");
		
		Map<String, List<String>> e1 = resultantList.stream().collect(Collectors.groupingBy(Person::getCountry,
				Collectors.mapping((Person p) -> p.getName().toUpperCase(), Collectors.toList())));
		System.out.println(e1);

	}

	public static List<Person> populateWithData() {

		List<Person> resultantList = new ArrayList<Person>();

		Person p1 = new Person("p1", "US");
		Person p2 = new Person("p2", "UK");
		Person p3 = new Person("p3", "India");
		Person p4 = new Person("p4", "Australia");
		Person p5 = new Person("p5", "Spain");
		Person p6 = new Person("p6", "US");
		Person p7 = new Person("p7", "India");

		Collections.addAll(resultantList, p1, p2, p3, p4, p5, p6, p7);

		return resultantList;

	}

}
