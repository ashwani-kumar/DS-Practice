
public class SumOfDialgonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5}};
				//int[][] array = {{10,2,3,4,5,10},
				//				         {1,20,3,4,20,6},
				//				         {1,2,30,30,5,6},
				//				         {1,2,40,40,5,6},
				//				         {1,50,3,4,50,6},
				//				         {60,2,3,4,5,60}};
				//int[][] array = {{2,1},{1,2}};
				//int [] array = {-1};
		SumOfDialgonal sumOfDiagonal = new SumOfDialgonal();
		System.out.println(sumOfDiagonal.solution(array));
	}
	
	private int solution(int[][] arr) {
		int rows = 0;
		int i = arr.length;
		int Sum = 0;
		for(rows = 0; rows < i; rows++)
	  	{
	   		Sum = Sum + arr[rows][rows];
	  	}
		return Sum;
	}

}
