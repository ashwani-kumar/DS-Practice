
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StringEncryption {

	// Complete the encryption function below.
	static String encryption(String s) {
		String usableString = s.trim();
		int length = usableString.length();
		double matrixSize = (double) Math.sqrt(length);
		int floorValue = (int) Math.floor(matrixSize);
		int ceilValue = (int) Math.ceil(matrixSize);
		char[][] encrypted = null;
		StringBuilder excryptedString = new StringBuilder();
		if(floorValue * ceilValue < length){
			//use ceil X ceil value
			encrypted = new char[ceilValue][ceilValue]; 
			char[] charSequence = usableString.toCharArray();
			int k = 0;
			for(int i = 0; i < ceilValue; i++){
				StringBuilder temp = new StringBuilder();
				for (int j = 0; j < ceilValue; j++) {
					if(k < charSequence.length) {
						encrypted[i][j] = charSequence[k];
					}else {
						encrypted[i][j] = ' ';
					}
					System.out.print(encrypted[i][j]);
					k++;
				}
				System.out.println(" ");
			}
		}else if(floorValue * ceilValue >= length){
			// use floor X ceil value
			encrypted = new char[floorValue][ceilValue];
			char[] charSequence = usableString.toCharArray();
			int k = 0;
			for(int i = 0; i < floorValue; i++){
				StringBuilder temp = new StringBuilder();
				for (int j = 0; j < ceilValue; j++) {
					if(k < charSequence.length) {
						encrypted[i][j] = charSequence[k];
					}else {
						encrypted[i][j] = ' ';
					}
					System.out.print(encrypted[i][j]);
					k++;
				}
				System.out.println(" ");
			}
		}
		
		
		if(floorValue * ceilValue < length){
			//use ceil X ceil value
			for(int i = 0; i < ceilValue; i++){
				StringBuilder temp = new StringBuilder();
				for (int j = 0; j < ceilValue; j++) {
					char c = encrypted[j][i];
					if(c != ' ') {
						temp.append(encrypted[j][i]);
					}
				}
				excryptedString.append(temp.toString()).append(" ");
			}
		}else if(floorValue * ceilValue >= length){
			// use floor X ceil value
			for(int i = 0; i < ceilValue; i++){
				StringBuilder temp = new StringBuilder();
				for (int j = 0; j < floorValue; j++) {
					char c = encrypted[j][i];
					if(c != ' ') {
						temp.append(encrypted[j][i]);
					}
				}
				excryptedString.append(temp.toString()).append(" ");
			}
		}
		
		
		return excryptedString.toString();
	}

	//private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		//String s = scanner.nextLine();

		System.out.println(encryption("haveaniceday"));
		System.out.println(encryption("feedthedog"));
		System.out.println(encryption("chillout"));
		//bufferedWriter.write(result);
		//bufferedWriter.newLine();

		//bufferedWriter.close();

		//scanner.close();
	}
}


