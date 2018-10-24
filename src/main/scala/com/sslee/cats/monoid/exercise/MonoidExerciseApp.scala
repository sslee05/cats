package com.sslee.cats.monoid.exercise

object MonoidExerciseApp extends App {
  
  //Monoid를 이용하여 List[Int] add 연산자를 구현 하라.
  import cats.Monoid
  import cats.syntax.monoid._
  
  def add[A: Monoid](xs: List[A]): A =
    xs.foldRight(Monoid.empty[A])(_ |+| _)
    
  import cats.instances.int._
  
  println(add(List(1,2,3,4,5)))
  
  //List[Option[Int]] 
  import cats.instances.option._
  println(add(List(Some(1),Some(2),None)))
  
  //case class Order(totalCost: Double, quantity: Double) 의 monoid 
  case class Order(totalCost: Double, quantity: Double)
  
  implicit val orderMonoid = new Monoid[Order] {
    def empty: Order = Order(0,0)
    def combine(o1: Order, o2: Order): Order = 
      Order(o1.totalCost + o2.totalCost, o1.quantity + o2.quantity) 
  }
  
  val rOrder = Order(2,3) |+| Order(3,2)
  println(rOrder)
}