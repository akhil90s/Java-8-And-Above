package functionalInterfaces;

import java.util.HashMap;
import java.util.Map;

public class Implementation {

	public static void main(String[] args) {

		IdentityCard identityCard_1 = (String name, int age, String address) -> {
			return "My Name Is " + name + ". My Age Is " + age + " . My address is " + address;
		};

		IdentityCard identityCard_2 = (name, age, address) -> {
			return "My Name Is " + name + " And My Age Is " + age + " . My address is " + address;
		};

		MathsOperations addNumbers = (n1, n2) -> {
			return n1 + n2;
		};

		MathsOperations subtractNumbers = (n1, n2) -> {
			return n1 - n2;
		};

		MathsOperations multiplyNumbers = (n1, n2) -> {
			return n1 * n2;
		};

		CharacterCount characterCount = (s) -> {
			s = s.toLowerCase();
			Map<Character, Integer> map = new HashMap<>();
			for (Character c : s.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			return map;
		};

		System.out.println(identityCard_1.identityCard("Akhil", 25, "Gurgaon"));
		System.out.println(identityCard_2.identityCard("Akhil", 27, "Pune"));
		System.out.println(addNumbers.mathsOperations(5, 7));
		System.out.println(subtractNumbers.mathsOperations(8, 7));
		System.out.println(multiplyNumbers.mathsOperations(5, 7));
		System.out.println(characterCount.getCharacterCount("Akhil"));
		System.out.println(characterCount.getCharacterCount("Kajal"));
		
		
	}

}
