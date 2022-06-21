package com.palak

fun main() {
    val obj = IntPalindrome()
    obj.checkIfPalindrome(121)
    obj.checkIfPalindrome(1231)
    obj.checkIfPalindrome(45154)
}

class IntPalindrome {

    fun checkIfPalindrome(number: Int) {
        val rev = reverse(number)
        if(number == rev){
            println("$number is Palindrome.")
        }
        else {
            println("$number is not Palindrome.")
        }
    }

    private fun reverse(number : Int) : Int{

        var num : Int = number
        var rev : Int = 0

        while(num > 0){
            rev = rev * 10
            rev = rev + num%10
            num = num/10
        }

        return rev;
    }
}