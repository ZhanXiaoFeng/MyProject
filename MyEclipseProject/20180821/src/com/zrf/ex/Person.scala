package com.zrf.ex

class Person(val name: String, var age: Int) {
  var height: Double = 170
  println("gougou")

  //辅助构造器(辅助构造器使用之前必先调用主构造器)
  def this() {
    //调用主构造器
    this("wanger", 17)
    height = 180
  }

  //重写方法
  override def toString(): String = {
    name + "\t" + age + "\t" + height
  }

}

object Person { //伴生对象
  def main(args: Array[String]): Unit = {
    go()
  }

  def go(): Unit = {
    var p = new Person("zhangsan", 18);
    println(p)

    //修改值
    p.age = 20
    p.height = 175
    println(p.name + "\t" + p.age + "\t" + p.height)

    println(new Person("lisi", 21))

    //调用辅助构造器
    var p1 = new Person
    println(p1)
  }
}