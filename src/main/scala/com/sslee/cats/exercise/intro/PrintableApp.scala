package com.sslee.cats.exercise.intro

object PrintableApp extends App {
 
  import PrintableInstances._
  import PrintableSyntax._
  
  val cat = Cat("navi", 2, "white")
  val formatValue = cat.format
  println(formatValue)
  cat.print
}