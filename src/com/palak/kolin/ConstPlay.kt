package com.palak.kolin

private const val c : String = "s";

class ConstPlay {

    private lateinit var lateVariable : String
    private val lazyObject : Int by lazy {
        9
    }

    var id : String = "sd";
    var address : String? = null

    companion object S{
        //const val i : Men = Men();//Not allowed. Only string and primitive allowed.
        const val i : Float = 3f
    }

    fun finalTest(){
        println(lazyObject);
        println(this::lateVariable.isInitialized)
        lateVariable::isEmpty
        defineStatic()

        address?.let {

        } ?: kotlin.run {

        }
    }
}

fun main() {
    ConstPlay().finalTest()
    ConstPlay.i
}

data class Men(
    var name: String?
)