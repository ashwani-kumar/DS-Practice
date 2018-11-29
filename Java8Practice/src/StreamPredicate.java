import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamPredicate {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five", "six");
		
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		stream.filter(p2.or(p3)).forEach(s -> System.out.println(s));
	}
}
