package com.sslee.cats.show.exercise

import com.sslee.cats.eq.exercise.Cat

object CatShowApp extends App {
  
  import cats.Show
  import cats.syntax.show._
  implicit val catShow: Show[Cat] = Show.show(cat => s"name is ${cat.name}, age is ${cat.age}, color is ${cat.color}")
  
  val cat = Cat("navi", 3, "white")
  
  println(cat.show)
  
}