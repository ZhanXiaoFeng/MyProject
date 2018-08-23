package com.zrf.ex

//伴生对象
object MapEx {
  def main(args: Array[String]): Unit = {
    // testMap
    testTuple
  }

  def testTuple(): Unit = {
    var tu = Tuple3("11", "22", "aa")
    tu.productIterator.foreach(println)

    println("********swap*********")
    var tu2 = Tuple2("aa", "bb")
    println(tu2.swap)
  }

  def testMap(): Unit = {
    var map: Map[Int, String] = Map(1 -> "aa", 2 -> "bb", 3 -> "cc")
    println(map.mkString("\t"))

    //伴生对象的使用
    // Person.testMax()

    println("*******foreach*********")
    map.foreach(println)

    println("*******iterator*********")
    var it = map.iterator
    while (it.hasNext) {
      var temp = it.next()
      println(temp._1 + "\t" + temp._2)
    }

    println("*******for*********")
    for (temp1 <- map) {
      println(temp1._1 + "\t" + temp1._2)
    }

    println("*******max/min*********")
    println(map.max)

    println("*******reduce*********")
    //println(map.reduce(op))
    var counter: Int = 0
    var kv = map.reduce((a1, a2) => { counter += a1._2.length; a2 })
    counter += kv._2.length
    println(counter)
  }
  
}