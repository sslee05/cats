package com.sslee.cats.exercise.meetscats

import cats._
import com.sslee.cats.exercise.intro.Cat

object CatUsingShowApp extends App {
  
  implicit val catShow: Show[Cat] = Show.show(cat => s"Name is ${cat.name},${cat.age} years-old Color is ${cat.color}")
  
  import cats.syntax.all._
  
  val cat = Cat("navi", 3, "white")
  println(cat.show)
}