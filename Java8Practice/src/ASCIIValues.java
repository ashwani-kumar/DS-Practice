import java.util.Arrays;
import java.util.Comparator;

public class ASCIIValues {
	
	public static void main(String... args) {
		String[] values = {"Simprints, every person counts", "Relentless Commitment to Impact","Robust as Fudge","Be Surprisingly Bold","Get Back Up","Make it Happen","Don't be a Jerk"};
		Integer[] asciiSum = new Integer[values.length];
		for(int i = 0; i < values.length; i++) {
			int sum = 0;
			char[] str = values[i].toCharArray();
			for(int j = 0; j < str.length; j++){
				sum += str[j];
			}
			asciiSum[i] = sum;
		}
		Arrays.sort(asciiSum, Comparator.reverseOrder());
		for(int i = 0; i < asciiSum.length; i++) {
			System.out.print(asciiSum[i]+ " ");
		}
	}

}
