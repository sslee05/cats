package com.sslee.cats.eq

import java.util.Date

/**
 * scala에서 비교연산 == !=는 type이 다르더라도 작동한다. 
 * Cats에서 Eq라는 type class를 제공하며, 이는 type이 다르다면 compile error를 
 * interface method 로는 === 와 =!= 가 있고
 * Eq type class method로 eqv 와 neqv가 있
 * Eq.instance[A](f: (A,A) => Boolean): Eq[A] 를 제공하여 custom type에 대한 
 * Eq instance 생성를 할 수 있다.
 */
object EqApp extends App {
  
  //############### Eq ##########################
  import cats.Eq
  import cats.instances.int._
  
  val intEq = Eq[Int]
  println(intEq.eqv(1234,1234))
  println(intEq.neqv(1234,4321))
  //intEq.eqv(123,"abc") // compile error
  
  
  //############### syntax ##########################
  
  import cats.syntax.eq._
  import cats.instances.string._
  
  val a = "abc"
  val b = "cba"
  
  println(a === b)
  println(a =!= b)
  //a === b // compile error
  
  //############### option ##########################
  import cats.instances.option._
  //ma, mb의 유형을 명시적으로 선언하지 않을 경우 
  //Some =!= None 비교로 compile error
  //Eq 의 type class의 type parameter는 invariant이기 때문.
  val ma:Option[Int] = Some(1)
  val mb:Option[Int] = None
  
  println(ma === mb)
  println(ma =!= mb)
  
  import cats.syntax.option._
  println(1.some =!= none)
  
  //############### Eq instance##########################
  import cats.instances.long._
  implicit val dateEq = Eq.instance[Date]((date1,date2) => date1.getTime === date2.getTime)
  
  val date1 = new Date()
  Thread.sleep(1000l)
  val date2 = new Date()
  println(date1 =!= date2)
  
}