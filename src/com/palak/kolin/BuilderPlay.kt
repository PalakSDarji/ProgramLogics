package com.palak.kolin

fun main() {

    val mobile = Mobile.Builder().setCompany("Samsung").setSize(8).build()
    println(mobile.company)
    println(mobile.size)
}

class Mobile(val company: String?, val size : Int?){

    class Builder{
        var c : String? = null
        var s : Int? = null

        fun setCompany(company: String) : Builder{
            c = company
            return this
        }

        fun setSize(size: Int) : Builder{
            s = size
            return this
        }

        fun build() : Mobile {
            return Mobile(c,s);
        }
    }
}