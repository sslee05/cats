package com.sslee.cats.exercise.monoid

object Exercise254 extends App {
  
  //############## 1 번 ############################
  import cats._
  import cats.instances.int._
  import cats.syntax.monoid._
  
  def addInt(xs: List[Int]): Int = 
    xs.foldLeft(Monoid.empty[Int])(_ |+| _)
    
  val xs = List(1,2,3,4,5)
  println(addInt(xs))
  
  def add[A: Monoid](xs: List[A]): A = 
    xs.foldLeft[A](Monoid.empty[A])(_ |+| _)
  
  import cats.instances.option._
  val xs02 = List(Some(1), Some(2), None, Some(3),Some(4),Some(5))
  println(add(xs02))
  
  
  //############## 2 번 ############################
  import cats.instances.double._
  
  case class Order(totalCost: Double, quantiy: Double)
  
  implicit val orderMonoid = new Monoid[Order] {
    def empty = Order(0,0)
    def combine(o1: Order, o2: Order): Order = (o1,o2) match {
      case (Order(t1,q1), Order(t2,q2)) => Order(t1 |+| t2, q1 |+| q2) 
    }
  }
  
  val order = Order(2.0, 3.0) |+| Order(3.0, 2.0)
  println(order)
  
  import cats.instances.map._
  
  val map01 = Map("a" -> 1, "b" -> 2)
  val map02 = Map("b" -> 1, "c" -> 3)
  val map03 = map01 |+| map02
  println(map03)
  
  import cats.instances.tuple._
  import cats.instances.string._
  val t01 = ("a", 1)
  val t02 = ("b", 2)
  val t03 = t01 |+| t02
  println(t03)
  
}