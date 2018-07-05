package com.sslee.cats.exercise.meetscats.eq

import com.sslee.cats.exercise.intro.Cat

object EqApp extends App {
  
  import cats.Eq
  import cats.instances.string._
  import cats.instances.int._
  import cats.syntax.eq._
  
  implicit val catsEq = Eq.instance[Cat] {
    case (Cat(n1,a1,c1), Cat(n2,a2,c2)) => n1 === n2 && a1 === a2 && c1 === c2  
  }
  
  val cat1 = Cat("navi", 1, "white")
  val cat2 = Cat("navi",1, "black")
  val cat3 = Cat("navi", 1, "white")
  
  println(cat1 =!= cat2)
  println(cat1 === cat1)
  println(cat1 === cat3)
  
  import cats.instances.option._
  import cats.syntax.option._
  println(cat1.some =!= cat2.some)
  println(cat1.some === Option(cat3))
}