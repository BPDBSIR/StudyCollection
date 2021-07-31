package cn.xiaoyes.summerstudy.kotlin


// 类可以嵌套在其他类中
class Outer{
    private val bar: Int = 1
    class Nested{
        fun foo() = 2
    }
}

fun main(){
    val demo = Outer.Nested().foo()
    println(demo)

    val demo2 = Outer2().Inner2().foo()
    println(demo2)
}
// 您还可以使用带有嵌套的接口。类和接口的所有组合都是可能的：您可以在类中嵌套接口，在接口中嵌套类，在接口中嵌套接口。
interface OuterInterface{
    class InterClass
    interface InnerInterface
}
class OuterClass{
    class InnerClass
    interface InnerInterface
}


// 内部类
// 标记为inner得桥陶磊能够访问其外部类得成员。内部类会带有一个对外部得对象引用：
class Outer2{
    private val bar: Int = 1
    inner class Inner2{
        fun foo() = bar
    }
}


// 匿名内部类
// 对于 JVM 平台, 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它
//val listener = ActionListener { println("clicked") }