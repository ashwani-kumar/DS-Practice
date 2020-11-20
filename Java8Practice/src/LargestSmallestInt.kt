fun main() {
    findLargestAndSmallestValue(intArrayOf(-20, 34, 21, -87, 92, Int.MAX_VALUE))
    findLargestAndSmallestValue(intArrayOf(10, Int.MIN_VALUE, -2))
    findLargestAndSmallestValue(intArrayOf(Int.MAX_VALUE, 40, Int.MAX_VALUE))
    findLargestAndSmallestValue(intArrayOf(1, -1, 0))
}

fun findLargestAndSmallestValue(arr: IntArray){
    var largest = Int.MIN_VALUE
    var smallest = Int.MAX_VALUE

    for(number in arr){
        if(number > largest){
            largest = number
        } else if(number < smallest){
            smallest = number
        }
    }
}