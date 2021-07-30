package cn.xiaoyes.summerstudy.kotlin

fun main(){

}

// Kotlin类中的属性既可以使用关键字var声明为可变的，也可以使用关键字val声明为只读的

class Address{
    var name: String = "Hello Andrew"
    var street: String = "Baker"
    var city: String = "China"
    var state: String? = null
    var zip: Int = 132456


    // GETTERS/SETTERS
    val isEmpty: Boolean
        get() = this.zip == 0

    // 如果我们定义了一个自定义的setter，那么每次给属性赋值时都会调用它，一个自定义的setter如下所示：
    var stringRepresentaion: String
        get() = this.toString()
        set(value){
//            setDataFromString(value)// 解析字符串并赋值 给其他属性
        }
    // 按照惯例，setter 参数的名称是 value，但是如果你喜欢你可以选择一个不同的名称。


    // 自 Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它：
    val isEmpty2 get() = this.zip == 0  // 具有类型 Boolean

    // 如果你需要改变一个访问器的可见性或者对其注解，但是不需要改变默认的实现
    // 你可以定义访问器而不定义其实现:
    var setterVisibility: String = "abc"
        private set // 此 setter 是私有的并且有默认实现

    var setterWithAnnotation: Any? = null
//        @Inject set // 用 Inject 注解此 setter
    var counter = 0 // 注意：这个初始器直接为幕后字段赋值
        set(value) {
            if (value >= 0) field = value
        }
    // field 标识符只能用在属性的访问器内。

    // 如果属性至少一个访问器使用默认实现，或者自定义访问器通过 field 引用幕后字段
    // 将会为该属性生成一个幕后字段。
    val isEmpty3: Boolean
        get() = this.zip == 0


}

// 要使用一个属性 只要用名称引用它即可
fun copyAddress(address: Address): Address{
    val result = Address()
    result.name = address.name
    result.street = address.street
    return result
}
