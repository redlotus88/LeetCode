package com.c7n.leetCode.scala

/**
  * Created by dragon on 2020/3/20.
  */
object GetLeastNumbers {

  def main(args: Array[String]): Unit = {
    val arr = Array(3,2,1)
    val k = 2

    print(getLeastNumbers(arr, k).mkString(","))
  }

  def getLeastNumbers(arr: Array[Int], k: Int): Array[Int] = {
    return arr.sorted.take(k)
  }
}
