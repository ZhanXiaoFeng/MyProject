package com.zrf.ex

object ListEx {
  def main(args: Array[String]): Unit = {
    testTab()
    //test()
  }

  def test(): Unit = {
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    val nums = Nil

    println("第一网站是 : " + site.head)
    println("最后一个网站是 : " + site.tail)
    println("查看列表 site 是否为空 : " + site.isEmpty)
    println("查看 nums 是否为空 : " + nums.isEmpty)

    val site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    val site2 = "Facebook" :: ("Taobao" :: Nil)

    // 使用 ::: 运算符  前前后后
    var fruit = site1 ::: site2
    println("site1 ::: site2 : " + fruit)

    // 使用 List.:::() 方法  后前前后
    fruit = site1.:::(site2)
    println("site1.:::(site2) : " + fruit)

    // 使用 concat 方法
    fruit = List.concat(site1, site2)
    println("List.concat(site1, site2) : " + fruit)

    println("************:::**********")
    val site3 = List.fill(2)("aaaaaa")
    val site4 = List.fill(4)("111111")
    val site5 = site3 ::: site4
    site5.foreach(println)

    println("************reverse**********")
    val site6 = site5.reverse
    site6.foreach(println)

    println("************distinct**********")
    site6.distinct.foreach(println)

    println("************dropWhile**********")
    site6.dropWhile { x => x.contains("11") }.foreach(println)
  }

  def testTab(): Unit = {
    // 通过给定的函数创建 4 个元素(0,1,2,3)
    val squares = List.tabulate(4)(n => n * n)
    println("一维 : " + squares)

    // 创建二维列表()
    val mul = List.tabulate(2, 3)(_ * _)
    println("多维 : " + mul)
  }
}