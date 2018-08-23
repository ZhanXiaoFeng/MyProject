package com.zrf.ex

object DefaultArgs {
  def main(args: Array[String]): Unit = {
    // println(addInt())
    //println(manyMulti(1000))
    println(fac(10))

  }

  def addInt(a: Int = 5, b: Int = 6): Int = {
    a + b
  }

  def manyMulti(i: Int): BigInt = {
    if (i < 2) 1 else manyMulti(i - 1) * i
  }

  def fac(i: Int): Long = {
    var arr = new Array[Int](i)
    if (i <= 1)
      2
    else if (i == 2)
      3
    else
      fac(i - 1) + fac(i - 2)
  }

}