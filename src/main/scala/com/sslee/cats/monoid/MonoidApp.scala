package com.sslee.cats.monoid

object MonoidApp extends App {
  
  import cats.Monoid
  import cats.instances.string._
  
  val m = Monoid[String]
  println(m.combine("a", "b"));
  
  import cats.syntax.monoid._
  println("hellow" |+| " world")
  
}