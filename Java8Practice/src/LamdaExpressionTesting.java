import java.io.File;
import java.io.FileFilter;

public class LamdaExpressionTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileFilter filter = (File file) -> file.getName().endsWith(".java");
		
		File dir = new File("d:/Temp");
		File [] files = dir.listFiles(filter);
		
		for(File f : files) {
			System.out.println(f.getName());
		}
	}

}
