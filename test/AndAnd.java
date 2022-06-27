package jb.com;

public class AndAnd {

	public static void main(String[] args) {
		int a = 1, b = 2;

		if (a > 1 & b++ > 2) {
			System.out.println("Hello");
		}
		System.out.println("a = " + a + ", b = " + b);

		a = 1;
		b = 2;

		if (a > 1 && b++ > 2) {
			System.out.println("Hello");
		}
		System.out.println("a = " + a + ", b = " + b);

	}

}
