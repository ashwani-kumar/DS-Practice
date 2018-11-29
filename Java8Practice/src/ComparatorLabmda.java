import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLabmda {
	public static <T> void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		Comparator<String> comparatorLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
		
		List<String> list = Arrays.asList("***","**","****","*");
		Collections.sort(list, comparatorLambda);
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}
