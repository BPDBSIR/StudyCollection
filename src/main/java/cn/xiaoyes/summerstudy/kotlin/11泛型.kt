package cn.xiaoyes.summerstudy.kotlin

fun main(){
    // 一般来说，要创建这样类的实例，我们需要提供类型的参数
    val box: Box<Int> = Box<Int>(1)
    // 但是如果类型参数可以被推断出来，例如从构造函数的参数或者从其他途径中，允许省略类型参数
    val box2 = Box(1)// 1具有类型Int，所以编译器知道我们输欧的是Box<Int>


    // 形变
    // Java 类型系统中最棘手的部分之一是通配符类型。而Kotlin中则没有
    // 相反，它有两个其他的东西：声明处形变与类型投影

    /*
    * List<String> strs = new ArrayList<String>();
    * List<Object> objs = strs; // 此处编译器错误让我们避免了之后的运行时异常
    * objs.add(1);// 这里我们吧一个证书放入一个字符串列表
    * String s = strs.get(0);// ClassCastException：无法将整数转换为字符串
    * */

    /*
    * 因此，Java 禁止这样的事情以保证运行时的安全。但这样会有一些影响。
    * 例如，考虑 Collection 接口中的 addAll() 方法。该方法的签名应该是什么？直觉上，我们会这样：
    * // Java
        interface Collection<E> …… {
            void addAll(Collection<E> items);
        }
    * */

    // 但随后，我们就无法做到以下简单的事情（这是完全安全）：
    /*
    * // Java
void copyAll(Collection<Object> to, Collection<String> from) {
  to.addAll(from);
  // ！！！对于这种简单声明的 addAll 将不能编译：
  // Collection<String> 不是 Collection<Object> 的子类型
}
    * */

    // 这就是为什么 addAll() 的实际签名是以下这样：
    /*
    * // Java
        interface Collection<E> …… {
            void addAll(Collection<? extends E> items);
        }
    * */

}

// 与Java类似 Kotlin中的类也有类型参数
class Box<T>(t: T){
    var value = t
}



// 声明处型变

interface Source<out T>{
    fun next(): T
}


fun demo(strs: Source<String>){
    val objs: Source<Any> = strs
}

// 一般原则是：当一个类C的类型从桉树T被声明为out时，他就只能出现在C的成员的输出-位置，但回报是C<Base>可以其安全得作为C<Derived>得超类
// 简而言之，他们说类 C 是在参数 T 上是协变的，或者说 T 是一个协变的类型参数。 你可以认为 C 是 T 的生产者，而不是 T 的消费者。
// out修饰符称为型变注解，并且由于它在类型参数声明处提供，所以我们称之为声明处型变。 这与 Java 的使用处型变相反，其类型用途通配符使得类型协变。
//另外除了 out，Kotlin 又补充了一个型变注释：in。它使得一个类型参数逆变：只可以被消费而不可以被生产。逆变类型的一个很好的例子是 Comparable：
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
}
// 消费者 in, 生产者 out


// 类型 投影
//将类型参数 T 声明为 out 非常方便，并且能避免使用处子类型化的麻烦，但是有些类实际上不能限制为只返回 T！ 一个很好的例子是 Array：
/*
class Array<T>(val size: Int){
    fun get(index: Int): T {}
    fun set(index: Int,value: T){}
}*/
//该类在 T 上既不能是协变的也不能是逆变的。这造成了一些不灵活性。考虑下述函数：
fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}
// ...