package com.zrf.ex

import scala.collection.mutable.ArrayBuffer

object ForEx {
  def main(args: Array[String]) {
    //for1()
    //testArrayBuffer
    //testFunction
    testCurringFunction()
  }

  /**
   * 函数柯里化
   */
  def testCurringFunction(): Unit = {
    //正常定义
    def multiple1(x: Int, y: Int) = x * y
    println(multiple1(2, 3))
    
    //其中一个函数作为返回值
    def multiple2(x: Int) = (y: Int) => x * y
    println(multiple2(3)(4))

    //柯里化
    def multiple3AfterCurring(x: Int)(y: Int) = x * y
    println(multiple3AfterCurring(4)(5)) //必须传递两个参数，否则编译报错
  }

  //定义方法
  def testFunction(): Unit = {
    //定义函数
    val f2 = (i: Int) => i * 5
    val f3 = (i: Int) => i * 6

    //f1方法传入值(定义Int类型的j,形参f(传入值为Int类型,传出值为Int类型)):方法体传出值为Int类型
    def f1(j: Int, f: Function[Int, Int]): Int = {
      var i = j
      i += 1
      i *= 10
      f(i)
    }
    println(f1(4, f3))
  }

  def for1() {
    var list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18)
    var temp = 0
    val filterList = for {
      temp <- list
      if (temp & 1) == 0
      if (temp % 3) == 0
    } yield temp

    filterList.foreach(println)
    println("----------------")
    println(filterList.toString())
  }

  def testArrayBuffer(): Unit = {
    var arrayBuffer = new ArrayBuffer[Int]
    arrayBuffer = (1 +: 2 +: 3 +: 4 +: arrayBuffer)
    //arrayBuffer.foreach(println)
    println(arrayBuffer.toString())

    //拼凑集合
    println("-----------------")
    var list = List(5, 6, 7, 8)
    arrayBuffer = arrayBuffer ++ list
    //arrayBuffer.foreach(println)
    println(arrayBuffer.toString())

    //删除指定位置a[7]的元素
    println("-----------------")
    arrayBuffer.remove(7)
    println(arrayBuffer.toString())

    //删除5个元素(删除a[1]到a[5])
    println("-----------------")
    arrayBuffer.remove(1, 5)
    println(arrayBuffer.toString())

    //元素更新(把a[1]元素的值替换为2)
    println("-----------------")
    arrayBuffer.update(1, 2)
    println(arrayBuffer.toString())
  }
}