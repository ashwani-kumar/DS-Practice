import java.math.BigInteger;

public class Hexanacci {
	void calculateWays(int turns) {
		BigInteger identifiedWays;

		BigInteger n1 = new BigInteger("0");
		BigInteger n2 = new BigInteger("0");
		BigInteger n3 = new BigInteger("0");
		BigInteger n4 = new BigInteger("0");
		BigInteger n5 = new BigInteger("0");
		BigInteger n6 = new BigInteger("1");

		for (int i = 0; i <= turns; i++) {

			identifiedWays = n1.add(n2).add(n3).add(n4).add(n5).add(n6);

			if (i > 0) {
				n1 = n2;
				n2 = n3;
				n3 = n4;
				n4 = n5;
				n5 = n6;
				n6 = identifiedWays;
			}

			System.out.println(i + ": ->" + identifiedWays);
		}
	}

	public static void main(String... args) {
		Hexanacci mHexanacci = new Hexanacci();
		mHexanacci.calculateWays(610);
	}
}
