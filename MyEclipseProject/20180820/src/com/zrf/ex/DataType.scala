package com.zrf.ex

object DataType {
  def main(args: Array[String]): Unit = {
    testMultipleList()
    test2()
    test3()
    test4()
  }

  def testMultipleList(): Unit = {
    var ary = """
          aaa
          bbb
          ccc
          ddd 
          """
    println(ary)
  }

  def test2(): Unit = {
    var v1: Any = 777
    v1 = "aaaa"
    println(v1)
  }

  def test3(): Unit = {
    val a, b = 300
    val c = (a, b + "", 666)
    println(c._1 + "\t" + c._2 + "\t" + c._3)
  }

  def test4(): Unit = {
    //Array[T]("","")相当于调用了Array类中的apply(T*)
    val arrName: Array[String] = Array("aa", "bb")
    arrName.foreach(println)
  }
}