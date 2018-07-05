package com.sslee.cats.study.meetscats.eq

object OptionEqApp extends App {

  //import cats.Eq
  import cats.instances.int._
  import cats.instances.option._
  import cats.syntax.eq._
  
  println((Some(1): Option[Int]) === (None: Option[Int]))
  //compile error 
  // Some(1) === None
  
  import cats.syntax.option._
  println(1.some === none[Int])
}