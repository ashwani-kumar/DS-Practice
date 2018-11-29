import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFileDemo {

	public static void main(String args[]) throws IOException {
		FileReader in = null;
		Map<Integer, String> histogram = new HashMap<>();
		for(int i = 48; i < 58; i++) {
			histogram.put(i, "");
		}

		for(int i = 97; i < 123; i++) {
			histogram.put(i, "");
		}

		try {
			in = new FileReader("C:\\Users\\ashwanikumar\\Downloads\\CV_Kumar_Ashwani_Text.txt");

			int c;
			while ((c = in.read()) != -1) {
				c = Character.toLowerCase(c);
				if(histogram.containsKey(c)) {
					String count = histogram.get(c);
					count += "-";
					histogram.put(c, count);
				}else {
					histogram.put(c, "-");
				}
			}
			for(int i = 48; i < 58; i++) {
				String count = histogram.get(i);
				System.out.println((char)i +" : "+ count);
			}

			for(int i = 97; i < 123; i++) {
				String count = histogram.get(i);
				System.out.println((char)i +" : "+ count);
			}
		}finally {
			if (in != null) {
				in.close();
			}
		}
	}
}