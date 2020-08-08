package chap07;

public class MainProxy {

	public static void main(String[] args) {
		RecCalculator rc = new RecCalculator();
		ExeTimeCalculator etc = new ExeTimeCalculator(rc);

		System.out.println(etc.factorial(20));

	}

}
