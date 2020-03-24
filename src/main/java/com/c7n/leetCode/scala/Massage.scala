package com.c7n.leetCode.scala

/**
  * 面试题 17.16. 按摩师
  *
  * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
  * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
  */
object Massage {

  var resultMap:Map[Int, Int] = Map()

  def main(args: Array[String]): Unit = {
    println(massage(Array()))
    println(massage(Array(1,2,3,1)))
    println(massage(Array(2,7,9,3,1)))
    println(massage(Array(2,1,4,5,3,1,1,3)))
    println(massage(Array(183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211)))
    println(massage(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)))
  }

  def massage(nums: Array[Int]): Int = {
    val arrayHash = nums.mkString(",").hashCode
    if (arrayHash == 0) {
      return 0
    }

    val last = nums(nums.length - 1)

    if (resultMap.get(arrayHash).getOrElse(0) > 0) {
      return resultMap.get(arrayHash).get
    }

    var result = 0

    if (nums.length == 2) {
      result = if (nums(1) > nums(0)) nums(1) else nums(0)
    } else if (nums.length == 1) {
      result = nums(0)
    } else if (nums.length == 0) {
      result = 0
    } else if (last == 0) {
      result = massage(nums.take(nums.length - 1))
    } else {
      val tmp1 = nums.take(nums.length - 1)
      val tmp2 = nums.take(nums.length - 2)

      val val1 = massage(tmp1)
      val val2 = massage(tmp2)

      if (val1 - val2 > last) {
        result = val1
      } else {
        result = val2 + last
      }
    }
    resultMap += (arrayHash -> result)
    return result
  }
}
