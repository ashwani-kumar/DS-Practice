import java.util.HashSet

fun printPairsUsingSet(numbers:IntArray, n: Int){
    if(numbers.size < 2){ return; }
    val set = HashSet<Int>(numbers.size)
    for(value in numbers){
        var target = n - value // if target number is not in set then add
        if(!set.contains(target)){
            set.add(value);
        }else {
            System.out.printf("(%d, %d) %n", value, target);
        }
    }
}

fun printPairOptimized(numbers:IntArray, n: Int){
    numbers.sort()
    if(numbers.size < 2){ return; }
    var left = 0
    var right = numbers.size - 1
    while(left < right) {
        val sum = numbers[left] + numbers[right]
        when {
            sum == n -> {
                println("(${numbers[left]}, ${numbers[right]})")
                left += 1
                right -= 1
            }
            sum > n -> {
                right -= 1
            }
            sum < n -> {
                left += 1
            }
        }
    }

}

fun main(){
    val numbers = intArrayOf(1,2,3,4,5)
    printPairOptimized(numbers, 5)
    //printPairsUsingSet(numbers, 5)
}
