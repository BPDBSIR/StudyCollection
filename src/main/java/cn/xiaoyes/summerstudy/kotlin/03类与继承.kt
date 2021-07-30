package cn.xiaoyes.summerstudy.kotlin

fun main(){
    // 创建类的实例(Kotlin中没有new关键字)
    InitOrderDemo("Kotlin")
    Constructors(123)
    Customer2("")

    DerivedModel("B","JZ")

    val rect = FilledRectangle()
    rect.draw()
    println(rect.borderColor)

    println(Compose.name)
}


// Kotlin中使用关键字class声明类
class Invoice{ }


// 如果一个类没有类体，可以省略花括号
class Empty


// 构造函数 在Kt中的一个类可以有一个`主构造函数`以及一个或多个次构造函数。主构造函数是类头的一部分，它跟在类名(与可选的类型参数)后

class Person constructor(firstName: String){ }

//如果主构造函数没有任何注解或者可见性修饰符 可以省略这个constructor关键字
class Person2(firstName: String){ }


// 主构造函数不能包含任何代码 。初始化的代码可以放到init关键字作为前缀的初始化块中
// 在实例初始化期间，初始化块按照他们出现在类中的顺序执行与属性初始化器交织在一起：
class InitOrderDemo(name: String){
    val firstProperty = "First property: $name".also(::println)
    init {
        println("First initializer block that prints $name")
    }
    val secondProperty = "Second property: ${name.length}".also(::print)
    init {
        println("Second initializer block that prints ${name.length}")
    }
}


// 主构造的参数可以在初始化块中使用 他们也可以在类体内生命的属性初始化器中使用
class Customer(name: String){
    val customerKey = name.uppercase()
}

// 事实上，声明属性以及从主构造函数初始化属性Kotlin有简介的语法
class Person3(val firstName: String,val lastName: String,var age: Int){}
// 与普通属性一样，主构造函数中声明的属性可以是可变的（var）或只读的（val）。

// 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
//class Customer2 public @Inject constructor(name: String) { /*……*/ }


// 次构造函数

class Person4{
    var children: MutableList<Person4> = mutableListOf()
    constructor(parent: Person4){
        parent.children.add(this)
    }

}

// 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
class Person5(val name: String) {
    var children: MutableList<Person5> = mutableListOf()
    constructor(name: String, parent: Person5) : this(name) {
        parent.children.add(this)
    }
}

/*
* 请注意，初始化块中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，
* 因此所有初始化块与属性初始化器中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块：
* */
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

/*
* 如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是 public。
* 如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数
* */
class DontCreateMe private constructor () { /*……*/ }


/*
* 在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库。
* */
class Customer2(val customerName: String = "")



// Kotlin中所有类都有一个共同的超类Any，这对于没有超类型生命的类都是默认的
class Example // Any隐式继承

// 默认 情况下Kotlin类最终都是final的，他们不能被继承。要使用一个类可以被继承，请使用open关键字标记他
open class Base(p: Int)// 该类开放继承

// 如需生命一个显示的超类型，请在类头中把超类型放到冒号之后
class Derived(p: Int): Base(p)


// 覆盖方法 开放覆盖的方法需要显示声明open关键字
open class Shape{
    open fun draw(){}
    fun fill(){}
}

class Circle(): Shape(){
    override fun draw() {
        super.draw()
    }
}
// 标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。如果你想禁止再次覆盖，使用 final 关键字
open class Rectangle(): Shape(){
    final override fun draw() {
        super.draw()
    }
}

// 覆盖属性
// 属性覆盖与方覆盖雷士，在超累声明后在派生类中重新声明的属性必须以override开头，并且他们必须具有兼容的类型
// 每个声明的属性可以由初始化器的属性或者具有get方法的属性覆盖
open class Shape2{
    open val vertexCount: Int = 0
}
class  Rectangle2: Shape2(){
    override val vertexCount: Int
        get() = super.vertexCount * 2
}
// 你也可以使用一个`var`属性覆盖一个`val`属性 但反之则不行 这是不允许的，因为一个val属性
// 本是上声明那个了一个get方法，而将其覆盖为var只是在子类中额外声明一个set方法
// 请注意 你可以在主构造函数中使用override关键字作为属性声明的一部分
interface Shapes{
    val vertexCount: Int
}
class Rectangles(override val vertexCount: Int) : Shapes

class Polygons: Shapes{
    override val vertexCount: Int
        get() = 8
}
// 派生类初始化顺序
// 在构造派生类的新势力的过程中，第一部分完成其基类的初始化(在之前只有对基类构造函数参数的求值) 英雌发生在派生类的初始化逻辑运行之前
open class BaseMode(val name: String){
    init {
        println("Initializing BaseModel")
    }
    open val size: Int =
            name.length.also { println("Initializing size in BaseModel: $it") }
}
class DerivedModel(name: String,val lastName: String): BaseMode(name.capitalize().also { println("Argument for BaseModel: $it") }){
    init {
        println("Initializing DerivedModel")
    }
    override val size: Int
        get() = (super.size + lastName.length.also { println("Initializing size in Derived: $it") })
}
/*
* 这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
* 如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）使用了任何一个这种属性，
* 那么都可能导致不正确的行为或运行时故障。设计一个基类时，应该避免在构造函数、
* 属性初始化器以及 init 块中使用 open 成员。
* */


// 派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：
open class Rectangle3 {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle3() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor

    // 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
        }
    }
}

// 在 Kotlin 中，实现继承由下述规则规定：如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
// 为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>：


open class Rectangle4 {
    open fun draw() { /* …… */ }
}

interface Polygon {
    fun draw() { /* …… */ } // 接口成员默认就是“open”的
}

class Square() : Rectangle4(), Polygon {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle4>.draw() // 调用 Rectangle.draw()
        super<Polygon>.draw() // 调用 Polygon.draw()
    }
}
// 可以同时继承 Rectangle 与 Polygon， 但是二者都有各自的 draw() 实现，所以我们必须在 Square 中覆盖 draw()， 并提供其自身的实现以消除歧义。



// 类以及其中的某些成员可以声明为 abstract。 抽象成员在本类中可以不用实现。 需要注意的是，我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
//
//我们可以用一个抽象成员覆盖一个非抽象的开放成员

open class Polygon3 {
    open fun draw() {}
}

abstract class Rectangle5 : Polygon3() {
    abstract override fun draw()
}

// 伴生对象
// 如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数()例如：工程方法，你可以把它携程该类内对象声明中的医院
// 更具体地将，如果 在你的类内声明了一个伴生对象，你就可以访问其成员，只是以类名作为限定符。
class Compose{
    companion object{
        const val name = "BPDBSIR"
    }
}