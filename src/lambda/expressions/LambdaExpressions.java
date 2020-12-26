package lambda.expressions;

public class LambdaExpressions {

	public static void main(String[] args) {

		FunctionalInterface test = (String name, int age) -> {
			System.out.println("My Name Is " + name + " And My Age Is " + age);
		};
		
		FunctionalInterface test1 = (name, age) -> {
			System.out.println("My Name Is " + name + " And My Age Is " + age);
		};
		
		test.testLambda("Akhil", 25);
		test1.testLambda("Akhil", 27);

	}

}
