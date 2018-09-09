package com.sslee.cats.study.functor

object FunctorSyntax extends App {
  
  //not map method in Function
  val fn01: Int => Int = (i: Int) => i * 2
  val fn02: Int => Double = (i: Int) => i.toDouble
  val fn03: Double => String = (d: Double) => d + "!"
  
  val fn04: Int => String = fn03 compose fn02 compose fn01
  println(fn04(5))
  
  import cats.instances.function._
  import cats.syntax.functor._
  
  val fn05: Int => String = fn01 map fn02 map fn03
  println(fn05(5))
  
  import cats.Functor
  def doMath[F[_]](ma: F[Int])(implicit F: Functor[F]): F[Int] = {
    ma.map(n => n * 2) //import cats.syntax.functor._  syntax 가 있어야 
  }
  
}