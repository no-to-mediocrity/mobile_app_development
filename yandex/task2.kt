import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val s = sc.next()

    var ans = "-1"
    var minLength = Int.MAX_VALUE

     for (i in 0 until s.length) {
        for (j in i + 1 until s.length) {
            val substring = s.substring(i, j + 1)

           if (isPalindrome(substring)) {

               if (substring.length < minLength) {
                    ans = substring
                    minLength = substring.length
                }

                 else if (substring.length == minLength && substring < ans) {
                    ans = substring
                }
            }
        }
    }

    println(ans)
}

fun isPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length - 1

    while (i < j) {
        if (s[i] != s[j]) {
            return false
        }
        i++
        j--
    }

    return true
}
