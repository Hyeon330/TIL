package chap05.section4

open class A {
    open fun f() = println("A class f()")
    fun a() = println("A class a()")
}

interface B {
    fun f() = println("B Interface f()")
    fun b() = println("B interface b()")
}

class C : A(), B {
    override fun f() {
        println("C class f()")
    }

    fun test() {
        f()
        b()
        super<A>.f()
        super<B>.b()
    }
}

fun main() {
    val c = C()
    c.test()
}