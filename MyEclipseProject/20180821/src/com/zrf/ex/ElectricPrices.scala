package com.zrf.ex

object ElectricPrices {
  def main(args: Array[String]): Unit = {
    println(go(12))
    println(goCase(5))
  }

  def go(hour: Int): Double = {
    def s1(): Double = 0.5
    def s2(): Double = 0.4
    def s3(): Double = 0.2
    if (hour > 6 && hour < 23) {
      s1()
    } else if (hour == 23 || (hour >= 0 && hour < 4)) {
      s2()
    } else {
      s3()
    }
  }

  //caseÆ«º¯Êý£¬ÀàËÆJavaµÄswicth
  def goCase(hour: Int): Double = {
    def s1(): Double = 0.5
    def s2(): Double = 0.4
    def s3(): Double = 0.2
    val hour1 = hour > 6 && hour < 24
    val hour2 = hour == 24 || (hour >= 0 && hour < 4)
    val hour3 = hour >= 4 && hour <= 6
    hour match {
      case hour1 => s1()
      case hour2 => s2()
      case hour3 => s3()
    }

  }

}