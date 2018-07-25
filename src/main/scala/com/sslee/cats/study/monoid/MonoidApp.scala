package com.sslee.cats.study.monoid

object MonoidApp extends App {
  
  import cats.Monoid
  import cats.instances.string._
  
  val ex01 = Monoid[String].combine("hellow"," world")
  println(ex01)
  
  import cats.instances.int._
  val ex02 = Monoid[Int].combine(1, 2)
  println(ex02)
  
  import cats.syntax.semigroup._
  val ex03 = "hellow" |+| " world"
  println(ex03)
  
  val ex04 = 1 |+| 2
  println(ex04)
  
  import cats.instances.option._
  val o1 = Option(10)
  val o2 = Option(5)
  val ex05 = o1 |+| o2
  println(ex05)
  
  
}