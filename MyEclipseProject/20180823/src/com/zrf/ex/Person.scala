package com.zrf.ex

import scala.Equals
import scala.collection.mutable._
import scala.math.Ordering
/*
	编译可以直接编译
	运行时，需要把scala安装目录下的lib目录中的所有jar放置到类路径中，也就是标准扩展目录下
	jdk安装目录/jre/lib/ext
*/

class Person(val name: String, var age: Int) extends Ordered[Person] {
  var height: Double = 170

  //scala中可以在构造函数中进行输出
  //println("gougou")

  //辅助构造器(辅助构造器使用之前必先调用主构造器)
  def this() {
    //调用主构造器
    this("wanger", 17)
    height = 180
  }

  def this(name: String, age: Int, height: Double) {
    this(name, age)
    this.height = height
  }

  //重写方法
  override def toString(): String = {
    name + "\t" + age + "\t" + height
  }

  override def equals(pp: Any): Boolean = {
    //类型转换
    if (pp.isInstanceOf[Person]) {
      var p: Person = pp.asInstanceOf[Person]
      return name.equals(p.name) && age == p.age && height == p.height
    }
    false
  }

  /*
	abstract def compare(x: T, y: T): Int 
	*/

  override def compare(y: Person): Int = {
    var res: Int = this.name.compare(y.name)
    if (res == 0) {
      res = this.age - y.age

      if (res == 0) {
        (this.height - y.height).compare(0)
      } else {
        return res
      }
    } else {
      res
    }
  }

}

object Person { //伴生对象
  def main(args: Array[String]): Unit = {
    //go()
    testMax()
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

  def testMax() {
    val set: Set[Person] = new TreeSet[Person]()
    var p: Person = new Person("zhangsan", 21, 167)
    set += p
    p = new Person("wangwu", 17, 163)
    set += p

    p = new Person("liusan", 19, 165)
    set += p

    set.foreach(println)
    println("*******最大值*************")
    println(set.max)
    println("*******最大值*************")

    set.foreach(println)
  }

}