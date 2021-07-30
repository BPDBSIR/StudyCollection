package cn.xiaoyes.summerstudy.kotlin

fun main(){

}

// 只有已给抽象方法的接口成为函数接口或者SAM(单一抽象方法)接口，函数式接口可以由多个非抽象成员，但只能由一个抽象成员

// 可以在fun修饰符在Kotlin中声明一个函数时接口
fun interface KRunnable{
    fun invoke()
}

// SAM转换
// 对于函数式接口，可以通过Lambda表达式实现SAM转换，从而是代码更简洁、更具有可读性
// 使用lambda表达式可以替代手动创建实现函数式接口的类，通过过SAM转换，Kotlin可以将 其签名与接口的单个抽象方法的签名匹配的任何lambda表达式转换为实现该接口的实例
// 假如由这样一个Kotlin函数时候接口
fun interface IntPredicate{
    fun accept(i: Int): Boolean
}

// 如果不使用SAM转换，那么你需要像这样编写代码：
val isEven = object : IntPredicate{
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}
// 通过过利用Kotlin的SAM转换，可以改为一下等效代码：
val isEven2 = IntPredicate { it % 2 == 0 }
// 可以通过过更短的lambda表达式i替换所有不必要的代码。

// 函数式接口与类型别名的比较
// 函数式接口和类型别名用途并不相同，类型别名只是现有类型的名称，他们不会创建新的类型
// 而函数式接口却会创建新的类型
// 类型别名只能由一个车呢官员，而函数式接口可以有多个非抽象成员以及一个抽象成员。函数式接口还可以实现以及继承其他接口
// 考虑以上情况，函数式接口比类型别名更有灵活性并且提供了更多的功能