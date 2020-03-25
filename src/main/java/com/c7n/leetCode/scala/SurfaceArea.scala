package com.c7n.leetCode

/**
  * 892. 三维形体的表面积
  * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
  * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
  * 请你返回最终形体的表面积。
  *
  */
object SurfaceArea {

  def main(args: Array[String]): Unit = {
    val test = Array.ofDim[Int](1, 1)
    test(0)(0) = 2

    println(surfaceArea(test))

    val test2 = Array.ofDim[Int](2,2)
    test2(0) = Array(1,2)
    test2(1) = Array(3,4)

    println(surfaceArea(test2))

    val test3 = Array.ofDim[Int](3,3)
    test3(0) = Array(1,1,1)
    test3(1) = Array(1,0,1)
    test3(2) = Array(1,1,1)

    println(surfaceArea((test3)))

    val test4 = Array.ofDim[Int](2,2)
    test4(0) = Array(1,0)
    test4(1) = Array(0,2)
    println(surfaceArea((test4)))
  }

  def surfaceArea(grid: Array[Array[Int]]): Int = {
    var totalAmount = 0
    var totalArea = 0
    if (grid.length == 0) return totalArea

    val x = grid.length

    for (idx <- 0 to x - 1) {
      val y = grid(idx).length
      for (idy <- 0 to y - 1) {
        val up = if (idx - 1 > -1) grid(idx - 1)(idy) else 0
        val down = if (idx + 1 < x) grid(idx + 1)(idy) else 0
        val left = if (idy - 1 > -1) grid(idx)(idy - 1) else 0
        val right = if (idy + 1 < y) grid(idx)(idy + 1) else 0

        val cur = grid(idx)(idy)
        if (cur > 0) {
          totalAmount += cur
          totalArea -= Math.min(up, cur) + Math.min(left, cur) + Math.min(down, cur) + Math.min(right, cur)
          totalArea -= (cur - 1) * 2
        }
      }
    }

    return totalAmount * 6 + totalArea
  }
}
