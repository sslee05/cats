package com.sslee.cats.study.meetscats.eq

object ExerciseApp extends App {
  
  import cats.Eq
  import cats.implicits._
  //import cats.Eq
  //import cats.instances.int._
  
  val eqInt = Eq[Int]
  println(eqInt.eqv(123, 123))
  println(eqInt.eqv(123,234))
  //eqInt.eqv(123,"123") compile error
  
  
  //using syntax === , =!=
  //import cats.syntax.eq._
  
  println(123 === 123)
  println(123 =!= 234)
  
}