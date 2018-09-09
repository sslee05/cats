package com.sslee.cats.study.functor

object FunctorWithCats extends App {
  
  import cats.Functor
  import cats.instances.list._
  
  val xs = List(1,2,3,4,5)
  val ys:List[Int] = Functor[List].map(xs)(n => n * 2)
  println(ys)
  
  import cats.instances.option._
  
  val op01 = Option(123)
  val op02:Option[Int] = Functor[Option].map(op01)(n => n * 2)
  println(op02)
  
  // lift 
  val fn = (i: Int) => i * 2
  val opFn: Option[Int] => Option[Int] = Functor[Option].lift(fn)
  println(opFn(Option(2)))
  
}