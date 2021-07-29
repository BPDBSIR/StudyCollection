package cn.xiaoyes.summerstudy.kotlin

import java.awt.Rectangle

/* 基本语法 */

// 程序的入口
fun main(){
    print("HelloWorld")

    // 定义制度局部变量使用关键字val定义 只能为其赋值一次
    val a: Int = 1 // 立即赋值
    val b = 2 // 自动推断出Int类型
    val c: Int // 如果没有 初始值类型不能省略
    c = 3 // 明确赋值

    // 可以重新赋值的变量使用var关键字
    var x = 5 // 自动推断出Int类型
    x += 1

    // 单行注释

    /*
    * 多行块级注释
    * */

    // 字符串模板
    val s1 = "a is $a"

    val s2 = "${s1.replace("is","was")},but now is $a"

    // 条件表达式
    fun maxOf(a: Int,b: Int): Int{
        if (a > b){
            return a
        }else{
            return b
        }
    }

    // 在Kotlin中 if也可以用作条件表达式
    fun maxOf2(a: Int,b: Int) = if (a > b) a else b

    // 空值与null检测，当某个变量的值可以为null的时候必须在声明处的类型后面加上?来表示该引用可以为空
    fun parseInt(str: String): Int?{
        // ...
        return null
    }

    // 使用返回值可空的函数

    fun printProduct(arg1: String,arg2: String){
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if (x != null && y != null){
            print(x * y)
        }else{
            print("arg1 and arg2 is not a number")
        }

        // 类型检测与自动类型转换
        fun getStringLength(obj: Any): Int?{
            if (obj is String){
                return obj.length
            }

            // 在离开检车分支后 “obj” 仍然是 “Any” 类型
            return null
        }

        // 或者

        fun getStringLength2(obj: Any): Int?{
            if (obj !is String) return null
            // 在这宜分治自动转换为String
            return obj.length
        }

        // 甚至
        fun getStringLength3(obj: Any): Int?{
            if (obj is String && obj.length > 0){
                return obj.length
            }
            return null
        }

        // for循环

        val items = listOf("apple","banana","kiwifruit")
        for (item in items) {
            println(item)
        }

        // 或者
        for (index in items.indices) {
            print("item at $index is ${items[index]}")
        }

        // while循环
        var index = 0

        while (index < items.size) {
            print("item at $index is ${items[index]}")
            index++
        }

        // when表达式
        fun describe(obj: Any): String =
                when(obj){
                    1 -> "One"
                    "Hello" -> "Greeting"
                    is Long -> "Long"
                    !is String -> "Not a String"
                    else -> "Unknown"
                }


        // 使用区间(range)
        val x1 = 10
        val y1 = 9
        if (x in 1..y1 + 1){
            print("first in range")
        }

        // 检测某俄国数字是否在指定区间外:
        val list = listOf("a","b","c")

        if (-1 !in 0..list.lastIndex){
            println("-1 is Out of range")
        }
        if (list.size !in list.indices){
            println("list size is out of valid list indices range, too")
        }

        // 区间迭代

        for (i in 1..5) {
            println(i)
        }

        // 或者使用数列迭代 step步长为2
        for (i in 1..10 step 2) {
            print(x)
        }

        for (i in 0 downTo 0 step 3) {
            println()
        }

        // 集合

        // 使用in运算符来判断集合内是否包含某实列
        when{
            "orange" in items -> print("Juicy")
            "apple" in items -> println("apple is fine too")
        }

        // 使用Lambda表达式来过滤(filter)与映射(map集合)
        val fruits = listOf("banana","avocado","apple","kiwifruit")
        fruits
                .filter { it.startsWith("a")}// 过滤开始字符为a的元素
                .sortedBy { it }// 根据元素进行排序
                .map { it.uppercase() }// 元素转换为大写字母
                .forEach { println(it) }// 循环输出

    }
}


// 顶层变量
val PI = 3.14
var x = 0

fun increment(){
    x += 1
}
// 函数
fun sum(a: Int,b: Int): Int{
    return a + b
}

// 一行函数
fun sum2(a: Int,b: Int) = a + b;

// 无返回值的函数
fun printSum(a: Int,b: Int): Unit{
    print("sum of $a and $b is ${a + b}")
}
// Unit可以省略
fun printSum2(a: Int,b: Int){
    print("sum of $a and $ is ${a + b}")
}