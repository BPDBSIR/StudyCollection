package cn.xiaoyes.summerstudy.kotlin


fun main() {

}

/*
* 类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。 （getter 总是与属性有着相同的可见性。） 在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。
*  如果没有显式指定修饰符的话，默认可见性是 public。
* */

fun baz() {}
class Bar {}

/**
 * -- 如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见
 * -- 如果你声明为 private，它只会在声明它的文件内可见
 * -- 如果你声明为 internal，它会在相同模块内随处可见
 * -- protected 不适合用于顶层声明
 */