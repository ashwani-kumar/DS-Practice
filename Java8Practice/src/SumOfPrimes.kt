class SumOfPrimes {
    private fun sumOfPrimes(numberOfPrimes: Int): Long {
        var number = 2
        var count = 0
        var sum: Long = 0
        while (count < numberOfPrimes) {
            if (isPrime(number)) {
                sum += number.toLong()
                count++
            }
            number++
        }
        return sum
    }

    private fun isPrime(number: Int): Boolean {
        for (i in 2..number / 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sumOfPrimes = SumOfPrimes()
            println(sumOfPrimes.sumOfPrimes(1000))
        }
    }
}