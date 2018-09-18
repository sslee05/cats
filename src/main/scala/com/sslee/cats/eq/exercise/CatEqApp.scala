package com.sslee.cats.eq.exercise

object CatEqApp extends App {
  
  import cats.Eq
  import cats.instances.string._
  import cats.instances.int._
  import cats.syntax.eq._
  
  implicit val catEq = Eq.instance[Cat]((cat1,cat2) => 
      cat1.name === cat2.name && cat1.age === cat2.age && cat1.color === cat2.color )
      
  val cat1 = Cat("navi", 1, "white")
  val cat2 = Cat("navi", 1, "black")
  val cat3 = Cat("navi", 1, "white")
  
  println(cat1 =!= cat2)
  println(cat1 === cat3)
  
  import cats.instances.option._
  import cats.syntax.option._
  println(cat1.some =!= none)
}