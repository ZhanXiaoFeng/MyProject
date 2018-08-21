package com.zrf.ex

import scala.collection.immutable.Set
import scala.util.control.Breaks

object ArithmeticEx {
  def main(args: Array[String]) {
    var num = 0

    for (str <- args) {
      num = num + Integer.parseInt(str)
    }
    println(num)
    //默认值，健壮性考虑
    var end = 1000

    if (args.length > 0) {
      var temp = Integer.parseInt(args(0))

      if (temp > 0) {
        end = temp
      }
    }

    go1(end).foreach(println)
    //testFor
    //testFor1(100)
  }

  def go1(num: Int): Set[Int] = {
    //为什么没有new 可以创建对象？原因是什么？
    var set = Set[Int]()

    val loop = new Breaks;
    //for循环，过滤多个条件的方法？
    loop.breakable {
      //嵌套循环：要终止内部和外部的循环，怎么办？
      for (temp <- 1 until num + 1; if (temp & 1) == 0; if (temp % 3) == 0) {
        if (temp == 720) loop.break
        set = set + temp
      }
    }
    set
  }

  def testFor() {
    var c = 0
    for (i <- 1.to(100)) {
      print(i + "\t")
      c += 1
      if (c == 10) {
        println
        c = 0
      }
    }
    println("*********************")
    for (i <- 1.until(100)) print(i + "\t")
  }

  def testFor1(columns: Int) {
    val sb = new StringBuffer
    sb.append("调用x to y\n")
    var c = 0
    for (i <- 1.to(100)) {
      sb.append(i + "\t")
      c += 1
      if (c == 10) {
        sb.append('\n')
        c = 0
      }
    }
    sb.append("*********************\n")
    for (i <- 1.until(100)) sb.append(i).append('\n')

    print(sb)
  }

}