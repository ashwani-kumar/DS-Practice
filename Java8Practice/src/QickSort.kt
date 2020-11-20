import java.util.*

fun main() {
    var unsorted = intArrayOf(6, 5, 3, 1, 8, 7, 2, 4)
    System.out.println("Unsorted array :" + Arrays.toString(unsorted));
    sort(unsorted);
    System.out.println("Sorted array :" + Arrays.toString(unsorted));
}

var input: IntArray? = null
var length: Int = 0
fun sort(numbers: IntArray){
    if(numbers == null || numbers.isEmpty()){
        return
    }
    input = numbers
    length = numbers.size
    if (input != null) {
        quickSort(0, length - 1)
    }
}

fun quickSort(low: Int, high: Int){
    var i = low
    var j = high

    var pivot = input!![low + (high - low)/2]
    println("$pivot input[$low + ($high - $low)/2")

    while(i <= j){
        while(input!![i] < pivot){
            i++
        }

        while(input!![j] > pivot){
            j--
        }

        if(i <= j){
            swap(i,j)
            i++
            j--
        }
    }

    if( low < j){
        quickSort(low, j)
    }

    if(i < high){
        quickSort(i, high)
    }
}

fun swap(i: Int, j: Int){
    var temp = input!![i]
    input!![i] = input!![j]
    input!![j] = temp
}