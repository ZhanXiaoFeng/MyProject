package com.zrf.ex

object TestArithmetic {
  def main(args: Array[String]): Unit = {
    val res = sum(1 to 1000)
    println(res)
  }

  //计算偶数和
  def sum(seq: Seq[Int]): Int = {
    var res: Int = 0
    for (i <- seq) {
      if (((i & Integer.MAX_VALUE) & 1) == 0) {
        res += i
      }
    }
    res
  }

  //判定一个是否是素数
  /*
	1、假设数是n,循环从2到n-1能被整除，循环结束
	2、从2到(n的平方根)
	3、想。。。乘法消除掉，也就是说用+,- 按位运算
	*/
  def testPrimeNumber(): Unit = {

  }
}