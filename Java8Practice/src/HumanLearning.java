import java.util.Scanner;

public class HumanLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HumanLearning humanLearning = new HumanLearning();
		//int[][] array = {{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5}};
		//int[][] array = {{10,2,3,4,5,10},
		//				         {1,20,3,4,20,6},
		//				         {1,2,30,30,5,6},
		//				         {1,2,40,40,5,6},
		//				         {1,50,3,4,50,6},
		//				         {60,2,3,4,5,60}};
		//int[][] array = {{2,1},{1,2}};
		//int [] array = {-1};
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter input size: ");
		int matrixSize = scanner.nextInt();
		
		if(matrixSize > 1) {
			//Read input for 2d array
			int [][] array = new int[matrixSize][matrixSize];
			System.out.println("Enter input data: ");
			for(int i = 0; i < matrixSize; i++) {
				for(int j = 0; j < matrixSize; j++) {
					array[i][j] = scanner.nextInt();
				}
			}
			System.out.println("Output: " + humanLearning.solution(array));
		} else if(matrixSize == 1) {
			//read input for 1d array
			int [] array = new int[matrixSize];
			for(int i = 0; i < matrixSize; i++) {
				array[i] = scanner.nextInt();
			}
			System.out.println("Output: " + humanLearning.solution(array));
		}else {
			System.out.println("Invalid input size");
		}
	}
	
	private int solution(int[] array) {
		return array[0];
	}
	
	private int solution(int[][] array) {
		int length = array.length;
			boolean isOddArray = (length % 2 != 0);
			int sum = 0;
			int maxArrayIndex = length - 1;
			for(int i = 0; i < length; i++) {
				if(isOddArray && (i == maxArrayIndex - i)) {
					sum += array[i][i];
				}else {
					sum += array[i][i] + array[maxArrayIndex - i][i];
				}
			}
			return sum;
	}
	

}
