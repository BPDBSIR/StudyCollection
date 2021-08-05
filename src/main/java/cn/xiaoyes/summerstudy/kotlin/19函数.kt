package cn.xiaoyes.summerstudy.kotlin

fun main() {

    // 函数用法
    val result = double(2)


}

// Kotlin中的函数使用fun关键数字申明
fun double(x: Int): Int {
    return 2 * x
}


// 参数
// 函数参数使用Pascal表示法定义 name: type。参数用投逗号隔开。每个参数必须有显示类型：
fun powerOf(number: Int, exponent: Int): Int {
    /* ... */
    return 0
}


// 默认参数
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) { /*...*/
}

// 覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值：
open class AF {
    open fun foo(i: Int = 10) {}
}

class BF : AF() {
    override fun foo(i: Int) {}// 不能有默认值
}

// 如有一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用:
fun foo2(bar: Int = 0, baz: Int) {}
// foo2(baz = 1)// 使用默认值bar = 0

// 如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入：
fun foo3(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {}
// foo3(1){ println('Hello') } //使用默认值baz = 1
// foo3(qux = { println('Hello ')}) //使用两个默认值bar = 0与baz = 1
// foo{ println('Hello') }// 使用两个默认值bar = 0与baz = 1


// 返回Unit的函数
// 如果一个函数不反悔任何有用的值，它的返回类型是Unit，Unit是一种只有一个值--Unit的类型，这个值不需要显示返回:
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // return Unit 或者 return 都是可选的
}

// Unit返回值类型生命也是可选的
fun printlnHello2(name: String?) {}

// 单函数表达式
// 当函数返回单个表达式时，可以省略花括号并且在=符号之后指定代码体即可：
fun double2(x: Int): Int = x * 2

// 当返回值类型可以由编辑器推断是，显示声明返回值时可选的
fun double3(x: Int) = x * 2

/// 可变数量的参数
// 函数的啊承诺书 通常时最后一个 可以使用vararg修饰符标记
fun <T> asList(vararg ts: T) {}

// 中缀表示法
// 标由infix关键字的函数也可以使用中缀表示法(忽略调用的点与圆括号)调用。中缀函数必须满足以下要求：
// 他们必须时成员函数或者扩展函数
// 他们必须只有一个参数
// 其参数不得接受可变数量的参数且i不能由默认值
infix fun Int.shl(x: Int): Int = x * 2

// 用中缀表示法调用该函数
// 1 shl 2
// 等同这样
// 1.shl(2)


// 函数作用域

// 局部函数 一个函数在另外一个函数内部
/*
fun dfs(graph: Graph) {
    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v, visited)
    }

    dfs(graph.vertices[0], HashSet())
}*/
/*
* 局部函数可以访问外部函数（即闭包）的局部变量，所以在上例中，visited 可以是局部变量：
* */
/*
* fun dfs(graph: Graph) {
    val visited = HashSet<Vertex>()
    fun dfs(current: Vertex) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v)
    }

    dfs(graph.vertices[0])
}
* */


// 成员函数 成员函数时在类或者对象内部定义的函数:
class Sample {
    fun foo() {
        print("Foo")
    }
}
// Sample().foo() // 创建Sample实例并且调用foo方法


// 泛型函数 函数可以由泛型参数，通过过 在函数名前面使用尖括号指定
fun <T> singletonList(item: T): List<T> {
    return emptyList()
}


// 内联函数 ...


// 扩展函数 ...

// 高阶函数和Lambda表达式 ...


// 尾递归函数
/* Kotlin 支持一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。 当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本： */


/*val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))*/

/*
* 这段代码计算余弦的不动点（fixpoint of cosine），这是一个数学常数。 它只是重复地从 1.0 开始调用 Math.cos，直到结果不再改变，
*
* 对于这里指定的 eps 精度会产生 0.7390851332151611 的结果。最终代码相当于这种更传统风格的代码：
* */

/*val eps = 1E-10 // "good enough", could be 10^-15

private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}*/
/*
* 要符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作。在递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中。目前在 Kotlin for JVM 与 Kotlin/Native 中支持尾递归。
* */

