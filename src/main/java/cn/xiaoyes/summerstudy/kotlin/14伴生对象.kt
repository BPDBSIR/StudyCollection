package cn.xiaoyes.summerstudy.kotlin

fun main(){
    var create = ComponentClass.create()

}

// 伴生对象

class ComponentClass{
    companion object Factory{
        fun create(): ComponentClass = ComponentClass()
    }
}