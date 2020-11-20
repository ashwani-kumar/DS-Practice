fun main(){
    var array1 = intArrayOf(101,102,103,104,105,106)
    var array = intArrayOf(101,102,103,104,105)
    print(reverseArray(array1).contentToString())
    print(reverseArray(array).contentToString())
}

fun reverseArray(array: IntArray): IntArray {
    var left = 0
    var right = array.size - 1

    while(left < right){
        val temp = array[right]
        array[right] = array[left]
        array[left] = temp
        left++
        right--
    }
    return array
}