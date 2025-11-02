
fun main() {
    val animalProducer: AnimalProducer<Animal> = AnimalProducer(Dog())
    val producer: Producer<Animal> = animalProducer
    println(animalProducer.produce())
    println(producer.produce())

    val animalProducer1: AnimalProducer<Animal> = AnimalProducer(Cat())
    println(animalProducer1.produce())

    val stringBox = Box("Hi")
    val anyBox: Box<Any> = stringBox

}

interface Producer<T> {
    fun produce() : T
}

class AnimalProducer<T>(private val animal: T) : Producer<T> {
    override fun produce(): T = animal
}

interface Animal
class Cat: Animal
class Dog: Animal

class Box<out T>(private val value: T) {
    fun get(): T = value
}

class Consumer<in T> {
    fun read(value : T) {
        println("reading: $value")
    }
}