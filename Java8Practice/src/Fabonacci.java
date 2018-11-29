import java.math.BigInteger;

public class Fabonacci {

	public static void main(String args[]) {
		int n = 8181;
		System.out.println(fib(n));
	}
	
	public static BigInteger fib(int n) {
		if(n==0) {
			return new BigInteger("0");
		}
		BigInteger[][] F = {{new BigInteger("1"),new BigInteger("1")},{new BigInteger("1"),new BigInteger("0")}};
		calculateNumber(F, n-1);
		return F[0][0];
	}

	private static void calculateNumber(BigInteger[][] F, int n) {
		// TODO Auto-generated method stub
		if(n == 0 || n == 1) {
			return;
		}
		BigInteger[][] M = {{new BigInteger("1"),new BigInteger("1")},{new BigInteger("1"),new BigInteger("0")}};
		calculateNumber(F, n/2);
		multiplyArray(F, F);
		if(n%2 != 0) {
			multiplyArray(M, F);
		}
	}

	private static void multiplyArray(BigInteger[][] M, BigInteger[][] F) {
		// TODO Auto-generated method stub
		BigInteger x = (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
		BigInteger y = (F[0][0].multiply(M[0][1])).add(F[0][1].multiply(M[1][1]));
		BigInteger z = (F[1][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
		BigInteger w = (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));
		
		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;		
	}
}
