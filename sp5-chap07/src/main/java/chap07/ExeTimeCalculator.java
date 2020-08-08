package chap07;

public class ExeTimeCalculator implements Calculator {

	private Calculator calculator;

	public ExeTimeCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = calculator.factorial(num);
		long end = System.nanoTime();

		System.out.printf("%s.factorial(%d) 실행 시간 = %d\n", calculator.getClass().getSimpleName(), num, (end - start));
		return result;
	}

}
