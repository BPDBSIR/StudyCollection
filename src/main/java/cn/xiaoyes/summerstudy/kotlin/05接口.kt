package cn.xiaoyes.summerstudy.kotlin

fun main() {

}

// Kotlin的接口可以既包含抽象方法的声明也可以包含实现，与抽象类不同的是，接口无法 保存状态。它可以由属性但必须声明为抽象或者提供访问器实现
// 使用interface来定义接口
interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
    }

    // 接口中的属性
    val prop: Int// 抽象的

    val propertyWithImplementation: String
        get() = "foo"
}

// 实现接口
// 一个类或者对象可以要实现一个或者多个接口
class Child : MyInterface {
    override fun bar() {
        // 方法体
    }

    override val prop: Int
        get() = 123

}

// 接口继承
interface Named {
    val name: String
}

interface Persond : Named {
    val firstName: String
    val lastName: String
    override val name: String
        get() = "$firstName $lastName"
}

data class Employee(override val firstName: String, override val lastName: String) : Persond



// 解决覆盖冲突
// 实现多个接口时，可能会遇到统一方法继承多个实现的问题
interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}

/*
*
* 上例中，接口 A 和 B 都定义了方法 foo() 和 bar()。 两者都实现了 foo(), 但是只有 B 实现了 bar() (bar() 在 A 中没有标记为抽象，
*  因为在接口中没有方法体时默认为抽象）。因为 C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。

* 然而，如果我们从 A 和 B 派生 D，我们需要实现我们从多个接口继承的所有方法，并指明 D 应该如何实现它们。
* 这一规则既适用于继承单个实现（bar()）的方法也适用于继承多个实现（foo()）的方法。
* */
