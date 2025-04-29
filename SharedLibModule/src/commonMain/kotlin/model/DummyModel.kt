package model

// top-level func
fun dummyTopLevelFunc() {
    println("dummyTopLevelFunc did call")
}

// class
class DummyClass {
    // type
    val dummyStr: String
    val dummyBool: Boolean = true
    val dummyInt: Int = 1
    val dummyFloat: Float = 1.0f
    val dummyDouble: Double = 1.0
    val dummyData: Byte = (1).toByte()
    val dummyRange: IntRange = 0..10
    val dummyOptional: String? = null
    val dummyResultSuccess: Result<String> = Result.success("S")
    val dummyResultFailure: Result<String> = Result.failure(Exception("F"))

    // init
    constructor(dummyStr: String) {
        this.dummyStr = dummyStr
    }

    // async await -> Void
    suspend fun dummySuspend(): Unit {}

    // throws
    @Throws(Exception::class)
    fun dummyThrow() {
        throw Exception("Dummy Throw!")
    }

    // closure
    fun dummyClosure(closure: (String) -> Unit) {
        closure("Hi")
    }

    fun dummyPrimitiveClosure(closure: (Int) -> Unit) {
        closure(1)
    }
}

// enum
enum class DummyEnum(name: String) {
    AppleJuice("A"),
    BananaJuice("B"),
    Cherry("C")
}

sealed class DummyAssoEnum {
    object Dog : DummyAssoEnum()
    data class Elephant(val str: String) : DummyAssoEnum()
    data class Fox(val num: Int) : DummyAssoEnum()
}

// protocol
interface DummyInterface {
    fun dummyHello()
}

// extension
fun String.dummyExtension(): String {
    return "$this extension"
}

// singleton
object DummySingleton {
    // array
    val dummyArray: List<String> = emptyList<String>()

    // set
    val dummySet: Set<String> = emptySet<String>()

    // map
    val dummyMap: Map<String, String> = emptyMap<String, String>()
}