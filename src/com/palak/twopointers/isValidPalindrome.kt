package com.palak.twopointers

fun main() {
    val p = ValidPalindrome()
    println(p.isPalindrome("12.02.2021"))
    println(p.isPalindrome("!, (?)"))
    println(p.isPalindrome("hello, world!"))
}
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            val leftChar = s[left]
            val rightChar = s[right]

            if (!leftChar.isLetterOrDigit() || leftChar.isWhitespace()) {
                left++
                continue
            }
            if (!rightChar.isLetterOrDigit() || rightChar.isWhitespace()) {
                right--
                continue
            }
            if (leftChar.lowercaseChar() == rightChar.lowercaseChar()) {
                left++
                right--
            } else {
                /*println("$left, $leftChar, $right, $rightChar")*/
                return false
            }
        }
        return true
    }
}