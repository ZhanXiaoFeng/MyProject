package com.zrf.ex
import java.util.{ ArrayList => Li }
import java.util.HashMap

object ListDemo {
  def main(aa: Array[String]): Unit = {
    //go2
    //testMap()
    testMap2()
  }

  def go(): Unit = {
    val list = new Li[String]()
    list.add("aa")
    list.add("bb")
    list.add("cc")

    def hehe(str: String): Unit = System.out.println(str)

    /*
		  System.out::println
		  (str)->System.out.prinlnt(str);
		*/
    //list.forEach(hehe)
  }

  def go2(): Unit = {
    val list = List(1, 2, 3, 4, 5);

    for (i <- list) {
      println(i)
    }
  }

  def testMap(): Unit = {
    val map = new HashMap[Integer, String]()
    map.put(1, "aa")
    map.put(2, "bb")
    map.put(3, "cc")
    map.put(4, "dd")
    map.put(4, "ee")

    def visit(key: Integer, value1: String): Unit = {
      print(key + "\t")
      println(value1)
    }
    //map.forEach(visit)
  }

  def testMap2(): Unit = {
    var map = Map[Int, String](1 -> "aa", 2 -> "bb", 3 -> "cc")
    for (m <- map) {
      println(m._1)
    }
    map = map + (4 -> "dd")
    map.foreach(println)
  }

}