package com.zrf.ex

//偏函数使用
object AnotherFunction {
  def main(args: Array[String]): Unit = {
    println(giveSummer(60000))
    println(giveSummer1(3500, 60000))
    go()
    //_ * 21, 10  ,号前面定义的函数 ,号后面传的是参数
    println(cal(_ * 21, 10))
    println(cal1(_ + _, 2, 3))
  }

  def giveSummer = giveMoney(50, _: Double)

  def giveMoney(adding: Double, salary: Double): Double = {
    adding + salary
  }

  def giveSummer1 = giveMoney1(_: Double, 50, _: Double)

  def giveMoney1(base: Double, adding: Double, salary: Double): Double = {
    base + adding + salary
  }

  def go(): Unit = {
    val list = List(1, 2, 3, 4, 5, 6)
    val list2 = list.filter(_ % 3 != 0).map(_ * 2)
    list2.foreach(println)
  }

  def cal(f: Int => Double, num: Int) = f(num)

  def cal1(f1: (Int, Int) => Double, num1: Int, num2: Int) = f1(num1, num2)

}