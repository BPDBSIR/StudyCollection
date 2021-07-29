package cn.xiaoyes.summerstudy.kotlin

import java.awt.Rectangle
import java.io.File
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

fun main(){

    // 函数的默认参数
    fun foo(a: Int = 0,b: String = ""){
        // ...
    }

    // 过滤list
    val  positives = listOf(123,4,32,423).filter { x -> x > 0 }

    // 或者可以更短
    val positives2 = listOf(123,4,32,423).filter { it > 0 }

    // 检测元素是否存在与集合中
//    if ("john@example.com" in exampleList){}

    // 字符串内插
    val name = "BPDBSIR"
    print("Name $name")

    // 类型判断
    /*when(x){
        is Foo
        is Bar
        else
    }*/

    // 遍历map/pair型list
    /*for ((k,v) in map){
        println("$k -> $v")
    }*/

    // 使用区间

    for (i in 1.. 100){}// 闭区间 包含100
    for (i in 1 until 100) { } // 半开区间：不包含100
    for (i in 2..10 step 2) { }
    for (x in 10 downTo 1) { }
    if (x in 1..10) { }


    // 自读List
    val list = listOf("a","b","c")

    // 自读Map
    val map = mapOf("a" to 1,"b" to 2,"c" to 3)

    // 访问map
    println(map["key"])

//    map["key"] = "123"

    // 延迟属性

    /*val p: String by lazy {
        // 计算该字符串
    }*/

    // 扩展函数
    fun String.spaceToCamelCase(){

    }
    "Convert this to camelcase".spaceToCamelCase()


    // if  not null 缩写
    val files = File("Test").listFiles()
    println(files?.size)

    // if not null and else缩写
    val files2 = File("Test").listFiles()
    println(files2.size ?: "empty")

    // if null执行下一个语句
    val values = mapOf("email" to 123)
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")

    // 在可能会空的集合中取第一元素

    val emails = listOf("123","456")
    val mainEmail = emails.firstOrNull() ?: ""

    // if not null 执行代码
    values?.let {
        // 代码会指定到此处 假如data不为null
    }


    // 返回when表达式
    fun transform(color: String): Int{
        return when(color){
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    // try/catch表达式
    fun test(){
        val result = try {
            // ...
        }catch (e: ArithmeticException){
            throw IllegalStateException(e)
        }
    }

    // if表达式
    fun foo(param: Int){
        val result = if (param == 1){
            "one"
        }else if (param == 2){
            "two"
        }else{
            "three"
        }
    }

    // 返回值类型为Unit的方式的Builder风格用法
    fun arrayOfMinusOnes(size: Int): IntArray{
        return  IntArray(size).apply { fill(-1) }
    }

    // 单表达式函数
    fun theAnswer() = 43

    // 等价于
    fun theAnswer2(): Int {
        return 43
    }

    // 单表达式函数语言其他原用法一起使用能简化代码 例如和when表达式一起使用
    fun transform2(color: String): Int = when(color){
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }


    val turtle = Turtle()
    with(turtle){// 画一个100像素的正方形
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    // Java7的try with resources
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader -> println(reader.readText()) }

    // 使用可控布尔
    /*val b: Boolean?

    if (b = true){

    }else{

    }*/

    // TODO()代码标记为不完整
    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

}

// 同一个对象实例调用对各方法(with)
class  Turtle{
    fun penDown(){}
    fun penUp(){}
    fun turn(degrees: Double){}
    fun forward(pixels: Double){}
}


// 创建单例
object Rosource{
    val name = "Name"
}

