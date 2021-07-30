package cn.xiaoyes.summerstudy.kotlin

// 我们经常创建一些只保存数据的类。在这些类中，一些标准函数往往是从数据机械推到而来的，在Kotlin中，这叫做数据类并标记为data
data class User(val name: String, val age: Int)

// 编译器自动从主构造函数中声明的所有属性导出以下成员
// -- equals()/hasCode()
// -- toString()
// -- componentN()函数
// -- copy()

/*
* 为了确保生成的代码的一致性以及有意义的行为，数据类必须满足以下要求：
  主构造函数需要至少有一个参数；
  主构造函数的所有参数需要标记为 val 或 var；
  数据类不能是抽象、开放、密封或者内部的；
  （在1.1之前）数据类只能实现接口。
* */

// 在JVM中，如果生成的类需要含有一个午餐的而构造函数，则所有的属性必须指定默认值


// 在类体中声明的属性
// 请注意，对于那些自动生成的函数，编译器只使用在主构造函数内部定义的属性。如需在生成的实现中排除一个属性，请将其声明在类体中：
data class Person6(val name: String) {
    var age: Int = 0
}
/*
* 在 toString()、 equals()、 hashCode() 以及 copy() 的实现中只会用到 name 属性，并且只有一个 component 函数 component1()。
* 虽然两个 Person 对象可以有不同的年龄，但它们会视为相等。
* */
fun main(){
    val person1 = Person6("John")
    val person2 = Person6("John")
    person1.age = 10
    person2.age = 20


// 数据类与结构声明
// 为数据类生成的Component函数还是他们可以在解构声明中使用
    val andrew = User("Andrew",20)
    val (name,age) = andrew
    println("$name, $age years of age")
}

// 复制
// 在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变。 copy() 函数就是为此而生成。对于上文的 User 类，其实现会类似下面这样：
//fun copy(name: String = this.name, age: Int = this.age) = User(name, age)

//val jack = User(name = "Jack", age = 1)
//val olderJack = jack.copy(age = 2)

// 标准数据类
// 标准库提供了 Pair 与 Triple。尽管在很多情况下具名数据类是更好的设计选择， 因为它们通过为属性提供有意义的名称使代码更具可读性。