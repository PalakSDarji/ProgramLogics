package com.palak.kolin

import java.lang.ArithmeticException
import java.lang.Error
import java.lang.RuntimeException

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data : T) : Result<T>()
    data class Failure(val error : Throwable) : Result<Nothing>()
}

sealed class WeekDaysWorkHours{
    data class Mon(val int: Int) : WeekDaysWorkHours()
    data class Tue(val int: Int, val str: String) : WeekDaysWorkHours()
    object Sun : WeekDaysWorkHours()
}

fun main() {

    var result1 : Result<String> = Result.Success("Success")
    val result2 : Result<String> = Result.Success("Done")

    result1 = Result.Failure(RuntimeException("ds"))
    when(result1){
        is Result.Success -> {
            println("in success : ${result1.data}")
        }
        is Result.Failure -> {
            println("in failure : ${result1.error}")
        }
    }

    Sample<ArithmeticException>()
    Sample<Exception>()
    Sample<Throwable>()
}

class Sample<out T : Any>{

}

object Wed : WeekDaysWorkHours()