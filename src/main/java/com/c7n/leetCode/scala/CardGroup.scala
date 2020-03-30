package com.c7n.leetCode.scala

/**
  * 914. 卡牌分组
  *
  * 给定一副牌，每张牌上都写着一个整数。

    此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

    每组都有 X 张牌。
    组内所有的牌上都写着相同的整数。

    仅当你可选的 X >= 2 时返回 true。

  提示：

    1 <= deck.length <= 10000
    0 <= deck[i] < 10000

  */
object CardGroup {

  def main(args: Array[String]): Unit = {
    val test1 = Array(1,2,3,4,4,3,2,1)
    val test2 = Array(1,1,1,2,2,2,3,3)
    val test3 = Array(1)
    val test4 = Array(1,1)
    val test5 = Array(1,1,2,2,2,2)

    println(hasGroupsSizeX(test1))
    println(hasGroupsSizeX(test2))
    println(hasGroupsSizeX(test3))
    println(hasGroupsSizeX(test4))
    println(hasGroupsSizeX(test5))
  }

  def hasGroupsSizeX(deck: Array[Int]): Boolean = {
    // map val -> size
    val map = deck.groupBy[Int]((x: Int) => {x}).mapValues(_.size)

    // One solution not the best.
//    var result = false
//    (2 to map.values.min).iterator.foreach(min => {
//      if (map.valuesIterator.withFilter((value: Int) => value % min != 0).length == 0) {
//        result = true
//      }
//    })
//    return result

    return map.valuesIterator.reduceLeft(gcd(_, _)) > 1
  }

  def gcd(x: Int, y: Int): Int = {
    return if (x == 0) y else gcd(y % x, x)
  }
}
