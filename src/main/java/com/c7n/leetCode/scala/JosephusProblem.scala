package com.c7n.leetCode.scala

/**
  * 约瑟夫环的解题过程
  * 62. 圆圈中最后剩下的数字
  *
  * 0,1, .. ,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

  * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

  * 示例 1：

  * 输入: n = 5, m = 3
  * 输出: 3
  * 示例 2：

  * 输入: n = 10, m = 17
  * 输出: 2
  *  

  * 限制：

  * 1 <= n <= 10^5
  1 <= m <= 10^6
  *
  */
object JosephusProblem {

  def main(args: Array[String]): Unit = {
    val test1 = (5, 3)
    println(lastRemaining(test1._1, test1._2))

    val test2 = (10, 17)
    println(lastRemaining(test2._1, test2._2))
  }

  def lastRemaining(n: Int, m: Int): Int = {
    if (n < 1 || m < 1) {
      return -1
    }

    if (n == 1) {
      return 0
    }

    val f = Array.ofDim[Int](n + 1)
    f(0) = 0
    f(1) = 0

    for (i <- 2 to n) {
      f(i) = (f(i - 1) + m) % i
    }

    return f(n)
  }
}
