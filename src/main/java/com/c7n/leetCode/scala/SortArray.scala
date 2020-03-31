package com.c7n.leetCode.scala

/**
  * Created by dragon on 2020/3/31.
  */
object SortArray {

  def main(args: Array[String]): Unit = {
    val test1 = Array(5,2,3,1)
    val test2 = Array(5,1,1,2,0,0)

    println(sortArray(test1).mkString(","))
    println(sortArray(test2).mkString(","))
  }

  def sortArray(nums: Array[Int]): Array[Int] = {
    return sortArray(nums, 0, nums.length - 1)
  }

  def sortArray(nums: Array[Int], start: Int, end: Int): Array[Int] = {
    val pVal = nums(start)

    // 快速排序的实现
    var i = start + 1
    var j = end

    if (j < i) {
      return nums
    }

    while (j >= i) {
      var innerFlag = true
      if (nums(j) < pVal) {
        while (i <= j && innerFlag) {
          if (j > i && nums(i) > pVal) {
            swapVal(nums, i, j)
            innerFlag = false
          }
          i += 1
        }
      } else {
        j -= 1
      }

      if (!innerFlag) {
        j -= 1
      }

    }

    if (j > start) {
      swapVal(nums, start, j)
      sortArray(nums, start, j - 1)
    }

    if (end - j - 1 > 0) {
      sortArray(nums, j + 1, end)
    }
    return nums
  }

  def swapVal(nums: Array[Int], x: Int, y: Int): Unit = {
    val tmp = nums(x)
    nums(x) = nums(y)
    nums(y) = tmp
  }
}
