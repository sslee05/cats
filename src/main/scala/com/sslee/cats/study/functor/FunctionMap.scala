package com.sslee.cats.study.functor

object FunctionMap extends App {
  
  val fn01: Int => Double = (i: Int) => i.toDouble
  val fn02: Double => Double = (d: Double) => d * 2
  val fn03: Double => String = (d: Double) => d.toString
  
  val fn04:Int => String = fn03 compose fn02 compose fn01
  println(fn04(5))
  
  import cats.instances.function._
  import cats.syntax.functor._
  
  val fn05: Int => String = fn01 map fn02 map fn03
  println(fn05(5))
  
  val fn:Int => String = ((i: Int) => i.toDouble) map ( d => d * 2) map (d => d.toString)
  
  
}