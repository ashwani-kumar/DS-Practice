import java.util.*

fun main(){
    var test1 = intArrayOf(1, 1, 2, 2, 3, 4, 5)
    var test2 = intArrayOf(1, 1, 1, 1, 1, 1, 1)
    var test3 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    var test4 = intArrayOf(1, 2, 1, 1, 1, 1, 1)

    var test = arrayOf(test1, test2, test3, test4)

    for (input in test) {
        println("Array with Duplicates       : " + input.contentToString());
        println("After removing duplicates   : " + removeDuplicates(input).contentToString())
    }
}

fun removeDuplicates(array: IntArray): IntArray {
    array.sort()
    var result = IntArray(array.size)
    var previous = array[0]
    result[0] = previous
    for((index, number) in array.withIndex()){
        if(previous != number){
            result[index] = number
        }
        previous = number
    }
    return result
}