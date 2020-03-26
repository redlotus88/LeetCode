package com.c7n.leetCode.scala

/**
  * 999. 车的可用捕获量
  * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
  * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
  * 返回车能够在一次移动中捕获到的卒的数量。
  */
object RookCaptures {

  def main(args: Array[String]): Unit = {
    println(numRookCaptures(test1()))
    println(numRookCaptures(test2()))
    println(numRookCaptures(test3()))
  }

  def numRookCaptures(board: Array[Array[Char]]): Int = {
    var rook = (0, 0)

    // find rook
    for (x <- 0 to 7) {
      for (y <- 0 to 7) {
        if (board(x)(y) == 'R') {
          rook = (x, y)
        }
      }
    }

    return findPawnNum(rook, board)
  }

  def findPawnNum(rookPos: (Int, Int), board: Array[Array[Char]]): Int = {
    var result = 0

    if (rookPos._1 < 7) {
      (rookPos._1 + 1 to 7).iterator.filter(board(_)(rookPos._2) != '.').take(1).foreach(idx => {
        if (board(idx)(rookPos._2) == 'p') {
          result += 1
        }
      })
    }

    if (rookPos._1 > 0) {
      (0 to rookPos._1 - 1).reverse.iterator.filter(board(_)(rookPos._2) != '.').take(1).foreach(idx => {
        if (board(idx)(rookPos._2) == 'p') {
          result += 1
        }
      })
    }

    if (rookPos._2 < 7) {
      (rookPos._2 + 1 to 7).iterator.filter(board(rookPos._1)(_) != '.').take(1).foreach(idx => {
        if (board(rookPos._1)(idx) == 'p') {
          result += 1
        }
      })
    }

    if (rookPos._2 > 0) {
      (0 to rookPos._2 - 1).reverse.iterator.filter(board(rookPos._1)(_) != '.').take(1).foreach(idx => {
        if (board(rookPos._1)(idx) == 'p') {
          result += 1
        }
      })
    }

    return result
  }

  def test1(): Array[Array[Char]] = {
    val board = Array.ofDim[Char](8, 8)
    board(0) = Array('.','.','.','.','.','.','.','.')
    board(1) = Array('.','.','.','p','.','.','.','.')
    board(2) = Array('.','.','.','R','.','.','.','p')
    board(3) = Array('.','.','.','.','.','.','.','.')
    board(4) = Array('.','.','.','.','.','.','.','.')
    board(5) = Array('.','.','.','p','.','.','.','.')
    board(6) = Array('.','.','.','.','.','.','.','.')
    board(7) = Array('.','.','.','.','.','.','.','.')
    return board
  }

  def test2(): Array[Array[Char]] = {
    val board = Array.ofDim[Char](8, 8)
    board(0) = Array('.','.','.','.','.','.','.','.')
    board(1) = Array('.','p','p','p','p','p','.','.')
    board(2) = Array('.','p','p','B','p','p','.','.')
    board(3) = Array('.','p','B','R','B','p','.','.')
    board(4) = Array('.','p','p','B','p','p','.','.')
    board(5) = Array('.','p','p','p','p','p','.','.')
    board(6) = Array('.','.','.','.','.','.','.','.')
    board(7) = Array('.','.','.','.','.','.','.','.')
    return board
  }

  def test3(): Array[Array[Char]] = {
    val board = Array.ofDim[Char](8, 8)
    board(0) = Array('.','.','.','.','.','.','.','.')
    board(1) = Array('.','.','.','.','p','.','p','.')
    board(2) = Array('.','p','.','.','.','.','.','.')
    board(3) = Array('.','p','B','.','R','.','B','p')
    board(4) = Array('.','p','.','.','.','B','.','.')
    board(5) = Array('.','.','p','.','.','p','.','.')
    board(6) = Array('.','.','.','.','.','.','.','.')
    board(7) = Array('.','.','.','.','.','.','.','.')
    return board
  }

}
