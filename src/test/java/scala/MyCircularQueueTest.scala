package scala

import com.c7n.leetCode.scala.MyCircularQueue

/**
  * Created by dragon on 2020/3/26.
  */
object MyCircularQueueTest {


  def main(args: Array[String]): Unit = {
    val circularQueue = new MyCircularQueue(3); // 设置长度为 3
    println(circularQueue.enQueue(1)); // 返回 true
    println(circularQueue.enQueue(2)); // 返回 true
    println(circularQueue.enQueue(3)); // 返回 true
    println(circularQueue.enQueue(4)); // 返回 false，队列已满
    println(circularQueue.Rear()); // 返回 3
    println(circularQueue.isFull()); // 返回 true
    println(circularQueue.deQueue()); // 返回 true
    println(circularQueue.enQueue(4)); // 返回 true
    println(circularQueue.Rear()); // 返回 4
  }
}
