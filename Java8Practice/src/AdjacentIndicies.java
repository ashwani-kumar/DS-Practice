
public class AdjacentIndicies {
	
	public static void main(String... args) {
		AdjacentIndicies adjacentIndicies = new AdjacentIndicies();
		int[] A = {1, 4, 7, 3, 3, 5};
		System.out.println(adjacentIndicies.solution(A));
	}

//	public int solution(int[] A) {
//        // write your code in Java SE 8
//        int[] sortedArray = sortArray(A);
//        System.out.println(sortedArray);
//        int previous = sortedArray[0];
//        int currCount = 1;
//        int prevCount = 0;
//        int result = 0;
//        for(int i = 1; i < sortedArray.length; i++){
//            if(sortedArray[i] == previous){
//                currCount++;
//                result = result + prevCount + currCount -1;
//            }else{
//                result = result + currCount;
//                prevCount = currCount;
//                currCount = 1;
//            }
//            previous = sortedArray[i];
//        }
//        return result;
//    }
	
	public int solution(int[] A) {
        // write your code in Java SE 8
        int[] sortedArray = sortArray(A);
        for(int i=0; i < sortedArray.length; i++) {
        	System.out.println(sortedArray[i]);
        }
        
        long minimumDistance = Long.MAX_VALUE;
        for(int i=1; i < sortedArray.length; i++) {
        	long distance = (long) sortedArray[i] - sortedArray[i-1];
        	if(distance < minimumDistance) {
        		minimumDistance = distance;
        	}
        }
        return minimumDistance > 100000000 ? -1 : (int)minimumDistance;
    }
    
    private int[] sortArray(int[] arr){
        int size = arr.length;
        for(int i=0; i< size - 1; i++){
            for(int j = 0; j < size - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    
}
