package com.zrf.ex

object ArrayEx {
  def main(args: Array[String]): Unit = {
    testZip()
  }

  //ิชื้
  def testZip(): Unit = {
    var arr = Array(1, 2, 3)
    var arr1 = Array("zh", "xj", "ck")
    var arr2 = arr.zipAll(arr1, 5, "vl")
    arr2.foreach(println)

    var arr3 = arr2.unzip
    arr3._1.foreach(println)
  }
}