import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);

		List<List<Integer>> list =  Arrays.asList(list1, list2, list3);
		System.out.println(list);
		Function<List<?>, Integer> size = l -> l.size()*2;//List::size;
		Predicate<Integer> p1 = s -> s > 3;
		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream().filter(p1); 
		list.stream()
			.flatMap(flatMapper)
			.forEach(System.out::println);
	}

}