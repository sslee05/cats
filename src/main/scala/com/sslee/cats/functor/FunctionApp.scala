package com.sslee.cats.functor

/**
 * function 의 composition을 통해 
 * 연산의 chain를 선언적으로 표현하고 미래의 실행시에 실행됨을 통해
 * Future와 비슷하다고 할 수 있다.
 */
object FunctionApp extends App {
  
  val fn01: Int => Double = (i: Int) => i.toDouble
  val fn02: Double => Double = (d: Double) => d * 2
  val fn03: Double => String = (d: Double) => d.toString
  
  //함수의 합성으로 연산의 chain 실제 실행 되지 않는다. 
  val fn04: Int => String = fn03 compose fn02 compose fn01
  
  //Cats 의 map 으로 표현 
  import cats.instances.function._
  import cats.syntax.functor._
  
  //val test = fn01.m
  val fn05:Int => String = fn01 map fn02 map fn03
  
  // 함수의 변수 자리에 익명함수로 치환하여 참조투명성을 check 
  val fn06:Int => String = ((d:Double) => d.toString)  compose ((d:Double) => d * 2 ) compose ((i:Int) => i.toDouble)
  val fn07:Int => String = ((i:Int) => i.toDouble) map ((d:Double) => d * 2) map ((d:Double) => d.toString)
  
  //실제 실행
  println(fn04(5))
  println(fn05(5))
  println(fn06(5))
  println(fn07(5))
  
  import cats.instances.list._
  import cats.instances.option._
  import cats.Functor
  
  val xs = List(Some(1), Some(2),None)
  val rx = Functor[List].compose[Option].map(xs)(_ * 2)
  println(rx)
}