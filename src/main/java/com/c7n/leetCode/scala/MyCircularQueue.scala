package com.c7n.leetCode.scala

/**
  * Created by dragon on 2020/3/26.
  */
class MyCircularQueue(_k: Int) {

  /** Initialize your data structure here. Set the size of the queue to be k. */
  var head = -1
  var tail = -1
  var queue = Array.ofDim[Int](_k)


  /** Insert an element into the circular queue. Return true if the operation is successful. */
  def enQueue(value: Int): Boolean = {
    if (isFull()) {
      return false
    }

    tail = (tail + 1) % _k
    head = if (head == -1) 0 else head
    queue(tail) = value
    return true
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  def deQueue(): Boolean = {
    if (isEmpty()) {
      return false
    }

    if (head == tail) {
      head = -1
      tail = -1
    } else {
      head = (head + 1) % _k
    }

    return true
  }

  /** Get the front item from the queue. */
  def Front(): Int = {
    if (isEmpty()) {
      return -1
    }

    return queue(head)
  }

  /** Get the last item from the queue. */
  def Rear(): Int = {
    if (isEmpty()) {
      return -1
    }

    return queue(tail)
  }

  /** Checks whether the circular queue is empty or not. */
  def isEmpty(): Boolean = {
    return tail == -1 && head == -1
  }

  /** Checks whether the circular queue is full or not. */
  def isFull(): Boolean = {
    return head == (tail + 1) % _k
  }


  /**
    * Your MyCircularQueue object will be instantiated and called as such:
    * var obj = new MyCircularQueue(k)
    * var param_1 = obj.enQueue(value)
    * var param_2 = obj.deQueue()
    * var param_3 = obj.Front()
    * var param_4 = obj.Rear()
    * var param_5 = obj.isEmpty()
    * var param_6 = obj.isFull()
    */

}
