package cn.xiaoyes.summerstudy.kotlin

import kotlin.random.Random

/*
* Kotlin标准库包含几个函数，他们的唯一目的是在对象的上下文中执行代码块。当对一个对象调用这样的函数并提供一个Lambda表达式时
* 他会形成一个临时作用域，在此作用域中，可以访问改对象而无需其名称，这些函数成为作用域函数。并有以下五种：
* let、run、with、apply以及also
*
* 这些函数基本上做了同样的事情：在一个对象上执行一个代码块。不同的是这个对象在块中如何使用，以及整个表达式的结果是什么。
*
* */

class Person7(var name: String,var age: Int){
    fun moveTo(name: String){ println("Hello moveTo $name") }
    fun incrementAge(){ println("incrementAge") }

    override fun toString(): String {
        return "Person7(name='$name', age=$age)"
    }
}

fun main(){
    val p7 = Person7("Andrew",20).let {
        println(it)
        it.moveTo("BPDBSIR")
        it.incrementAge()
        println(it)
    }

    // 如果不适用let来写这段代码，就必须引入一个新变量，并在每次使用它的时候重复其名称。
    val p8 = Person7("BJZ",19)
    println(p8)
    p8.moveTo("Bi Jizhuang")
    p8.incrementAge()
    println(p8)

    // 作用域函数没有引入任何新的技术，但是他们可以让你的代码更加简介易读
    // 由于作用域函数的相似性质，为你的案例选择正确的函数可能有点棘手。选择主要取决于你的意图和项目中使用的一致性。下面我们将详细描述各种作用域函数及其约定用法之间的区别。


    /* 区别 */
    // 由于作用域函数本质上都非常相识，因此了解他们之间的区别很重要，每个作用域函数之间有两个主要的区别：
    // 引用上下文对象的方式
    // 返回值


    // 上下文对象: this还是it
    // 在作用域函数的lambda表达式里面，上下文对象可以不适用其实际名称个而是使用可一个更简短的引用来访问。每个作用域函数都使用以下两种方式之一来访问上下文对象：
    // 组偶为Lambda表达式的接收者(this)或者作为lambda表达式的参数(it)。两者都提供了同样的功能，因此我们将正对不同的场景描述两者的优缺点，并提供使用建议。


    val str = "Hello"
    str.run {
        println("The receiver string length: $length")
        println("The receiver string length: ${this.length}")// 两种方式结果相同
    }
    str.let {
        println("Thr receiver string's length is ${it.length}")
    }

    // this
    // run with 以及 apply通过u关键字this映入上下文对象。
    // 因此，在他们的Lambda表达式中可以想在普通的类函数中一样访问上下文对象，在大多数场景，当你访问接收者对象时
    // 你可以省略this，来让你的代码变得更加简介，相对低，如果你省略了thisi，就很难区分接收者对象的成员以及外部对象或者函数
    // 英雌，队医主要对对象成员进行操作(调用其函数或者赋值其属性)的lambda表达式，建议将上下文对象作为接收者(this)

    val adam = Person7("Adam",10).apply {
        age = 20
        name = "HelloWorld"
    }
    println(adam)

    // it
    // 反过来，let 及 also 将上下文对象作为 lambda 表达式参数。
    // 如果没有指定参数名，对象可以用隐式默认名称 it 访问。it 比 this 简短，带有 it 的表达式通常更容易阅读。
    // 然而，当调用对象函数或属性时，不能像 this 这样隐式地访问对象。因此，当上下文对象在作用域中主要用作函数
    // 调用中的参数时，使用 it 作为上下文对象会更好。若在代码块中使用多个变量，则 it 也更好。
    fun getRandomInt(): Int {
        return Random.nextInt(100).also {
            println("getRandomInt() generated value $it")
        }
    }
    val i = getRandomInt()

    // 此外，当将上下文对象作为参数传递时，可以为上下文对象指定在作用域内的自定义名称。
    fun getRandomInt2(): Int {
        return Random.nextInt(100).also { value ->
            print("getRandomInt() generated value $value")
        }
    }

    val i2 = getRandomInt2()

    // 返回值
    // 更具返回结果，作用域函数可以分为以下两类：
    // apply以及also返回上下文对象
    // let、run以及with返回lambda表达式结果


//    apply 及 also 的返回值是上下文对象本身。
//    因此，它们可以作为辅助步骤包含在调用链中：你可以继续在同一个对象上进行链式函数调用。
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
            .apply {
                add(2.71)
                add(3.14)
                add(1.0)
            }
            .also { println("Sorting the list") }
            .sort()

//    它们还可以用在返回上下文对象的函数的 return 语句中。
    fun getRandomInt3(): Int {
        return Random.nextInt(100).also {
            print("getRandomInt() generated value $it")
        }
    }

    val i3 = getRandomInt3()

    /* Lambda 表达式结果 */
    /* let、run 及 with 返回 lambda 表达式的结果。所以，在需要使用其结果给一个变量赋值，或者在需要对其结果进行链式操作等情况下，可以使用它们。 */
    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")

    // 此外，还可以忽略返回值，仅使用作用域函数为变量创建一个临时作用域。

    val numbers2 = mutableListOf("one", "two", "three")
    with(numbers2) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }

}