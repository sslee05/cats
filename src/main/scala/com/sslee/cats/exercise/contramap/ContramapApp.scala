package com.sslee.cats.exercise.contramap

case class Box[A](value: A)

object ContramapApp extends App {
  
  import PrintableInstances._
  import PrintableSyntax._
  
  println("hellow".format2)
  println(true.format2)
  
  val box = Box("hi roo~")
  println(box.format2)
  
  println(Box(true).format2)
  println(Box(12345).format2)
}