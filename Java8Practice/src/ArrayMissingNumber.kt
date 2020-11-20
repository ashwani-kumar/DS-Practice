import java.util.*

class ArrayMissingNumber {

    init {
        val arr = intArrayOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20,
            21,
            22,
            23,
            24,
            25,
            26,
            27,
            28,
            30
        )
        //println(getMissingNumber(arr, 30))
        //println(getMissingUsingTotal(arr, 30))
        getMissingUsingBitSet(arr, 30)
//        val iArray = intArrayOf(1, 2, 3, 5, 6, 7, 8, 9, 10)
//        val missing = getMissingUsingTotal(iArray, 10)
//        System.out.printf("Missing number in array %s is %d %n",
//            Arrays.toString(iArray), missing)
    }

    private fun getMissingNumber(arr: IntArray, len:Int): Int {
        for ((index, number) in arr.withIndex()) {
            if (index + 1 < arr.size) {
                if (number + 1 != arr[index + 1]) {
                    return number + 1
                }
            }
        }
        return -1
    }

    private fun getMissingUsingTotal(numbers: IntArray, totalCount: Int): Int {
        val expectedSum = totalCount * ((totalCount + 1) / 2)
        var actualSum = 0
        for (i in numbers) {
            actualSum += i
        }
        return expectedSum - actualSum
    }
    
    private fun getMissingUsingBitSet(numbers: IntArray, count:Int) {
        val missingCount = count - numbers.size
        val bitSet = BitSet(count)
        for(number in numbers){
            bitSet.set(number - 1)
        }
        
        var lastMissingIndex = 0
        for(index in 0 until missingCount){
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex)
            println(++lastMissingIndex)
        }
    }
}

fun main() {
    val arrayMissingNumber: ArrayMissingNumber = ArrayMissingNumber()
}


