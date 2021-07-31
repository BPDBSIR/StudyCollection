package cn.xiaoyes.summerstudy.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
* 有一些常见的属性类型，虽然我们可以在每次需要的时候手动实现它们，
* 但是如果能够为大家把他们只实现一次并放入一个库会更好。例如包括：
* 延迟属性（lazy properties）: 其值只在首次访问时计算；
* 可观察属性（observable properties）: 监听器会收到有关此属性变更的通知；
* 把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。
* 为了涵盖这些（以及其他）情况，Kotlin 支持 委托属性:
* */
/*
class Example4 {
    var p: String by Delegate()
}*/

// 语法: val/var <属性名>: <类型> by <表达式>
// 在by后面的表达式是改委托，因为属性对应的get()与set()会被委托给他的getValue()与setValue()方法。
// 属性委托不必实现任何接口，但是需要提供一个getValue()函数与setValue() 对于var属性
class Delegate{
    operator fun getValue(thisRef: Any?,property: KProperty<*>): String{
        return "$thisRef, thank you  for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?,property: KProperty<*>,value: String){
        println("$value has been assigned to '${property.name} in $thisRef'")
    }
}

// 当我们从委托到一个 Delegate 实例的 p 读取时，将调用 Delegate 中的 getValue() 函数，
// 所以它第一个参数是读出 p 的对象、第二个参数保存了对 p 自身的描述 （例如你可以取它的名字)。 例如:
class Example4{
    var p: String by Delegate()
}
fun main(){
    val e = Example4()
    println(e.p)
    // 类似地，当我们给 p 赋值时，将调用 setValue() 函数。前两个参数相同，第三个参数保存将要被赋予的值：
    e.p = "NEW"

    println(lazyValue)
    println(lazyValue)

    val user = Users()
    user.name = "first"
    user.name = "second"
}
// 自 Kotlin 1.1 起你可以在函数或代码块中声明一个委托属性，因此它不一定是类的成员。

// 标准委托
// Kotlin标准库为集中有用的委托提供了工厂方法
// 延迟属性Lazy
// lazy() 是接受一个 lambda 并返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}
/*
* 默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）：该值只在一个线程中计算，并且所有线程会看到相同的值。如果初始化委托的同步锁不是必需的，这样多个线程可以同时执行，那么将 LazyThreadSafetyMode.PUBLICATION 作为参数传递给 lazy() 函数。 而如果你确定初始化将总是发生在与属性使用位于相同的线程， 那么可以使用 LazyThreadSafetyMode.NONE 模式：它不会有任何线程安全的保证以及相关的开销。
* */
// 可观察属性
// Delegates.observable() 接受两个参数：初始值与修改时处理程序（handler）。 每当我们给属性赋值时会调用该处理程序（在赋值后执行）。它有三个参数：被赋值的属性、旧值与新值：
class Users{
    var name: String by Delegates.observable("<no name>"){
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}
