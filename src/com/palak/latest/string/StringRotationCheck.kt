package com.palak.latest.string

fun main() {
    println(isStringRotated("abcd","cdab"))
    println(isStringRotated("abcd","cbae"))
    println(isStringRotated("palak","darji"))
}

fun isStringRotated(s1: String, s2: String) = s1.length == s2.length && (s1 + s1).contains(s2)
