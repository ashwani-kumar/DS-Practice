class AnagramPalindrome {
    private val STR_CHARS = 256
    private fun isAnagramPalindrom(str: String): Boolean {
        val count = IntArray(STR_CHARS)
        for (element in str) {
            count[element.toInt()]++
        }
        var odd = 0
        for (i in 0 until STR_CHARS) {
            if (count[i] and 1 != 0) {
                odd++
            }
            if (odd > 1) {
                return false
            }
        }
        return true
    }

    private fun isAnagramPalindromMap(str: String): Boolean {
        var count = HashMap<Char, Int>()
        for (element in str) {
            if (count.containsKey(element)) {
                count[element] = count[element]!!.plus(1)
            } else {
                count[element] = 1
            }
        }
        var odd = 0
        count.map {
            if (it.value and 1 != 0) {
                odd++
            }
            if (odd > 1) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val anagramPalindrome = AnagramPalindrome()
            println(if (anagramPalindrome.isAnagramPalindrom("geeksforgeeks")) "Yes" else "No")
            println(if (anagramPalindrome.isAnagramPalindrom("geeksogeeks")) "Yes" else "No")
            println("Using Map")
            println(if (anagramPalindrome.isAnagramPalindromMap("geeksforgeeks")) "Yes" else "No")
            println(if (anagramPalindrome.isAnagramPalindromMap("geeksogeeks")) "Yes" else "No")
        }
    }
}