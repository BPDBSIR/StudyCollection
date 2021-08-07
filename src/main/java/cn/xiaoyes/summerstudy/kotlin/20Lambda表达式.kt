package cn.xiaoyes.summerstudy.kotlin

// Kotlin 函数是头等的，这意味着他们可以储存在变量与数据结构中，作为参数传递给其他高阶函数以及从其他高阶函数返回。
// 可以像操作任意其他 非函数值一样操作函数.

// 高阶函数// 高阶函数是将函数用作参数或者返回值的函数

//一个不错的示例是集合的函数式风格的 fold
// 它接受一个初始累积值与一个接合函数，并通过将当前累积值与每个集合元素连续接合起来代入累积值来构建返回值：
fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}