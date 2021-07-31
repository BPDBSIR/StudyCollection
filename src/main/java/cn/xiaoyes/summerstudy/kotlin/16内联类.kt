package cn.xiaoyes.summerstudy.kotlin

/*
* 有时候，业务逻辑需要围绕某种类型创建包装器。然而，由于额外的堆内存分配问题，它会引入运行时的性能开销。此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，因为原生类型通常在运行时就进行了大量优化，然而他们的包装器却没有得到任何特殊的处理。

为了解决这类问题，Kotlin 引入了一种被称为 内联类 的特殊类，它通过在类的前面定义一个 inline 修饰符来声明：
* */

inline class Password(val value: String)