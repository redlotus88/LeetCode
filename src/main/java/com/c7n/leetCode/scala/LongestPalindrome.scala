package com.c7n.leetCode.scala

/**
  * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
  * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
  *
  * 注意:
  * 假设字符串的长度不会超过 1010。
  */
object LongestPalindrome {

  def main(args: Array[String]): Unit = {
    val test: String = "abccccdd"

    print(longestPalindrome(test))
  }


  def longestPalindrome(s: String): Int = {
    var maxLength = 0
    var singleExist = 0

    var collector: Map[Char, Int] = Map()
    s.foreach(c => {
      collector += (c -> {
        var tmp = collector.get(c).getOrElse(0)
        tmp + 1
      })
    })

    var total = collector.values.map(value => {
      if (singleExist == 0 && value % 2 == 1) {
        singleExist = 1
      }
      value / 2
    }).reduce((a, b) => a + b)

    maxLength = total * 2 + singleExist
    return maxLength
  }
}
