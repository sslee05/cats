package com.sslee.cats.variant

import com.sslee.cats.intro.{Json,JsString}

object ContravariantApp extends App {
  
  trait Shape
  case class Circle(radius: Double) extends Shape
  
  //defined type class
  trait JsonWriter2[-A] {
    def format(a: A): Json
  }
  
  //defined type class instance
  implicit val shapeJsonWriteInstance = new JsonWriter2[Shape] {
    def format(shape: Shape): Json = shape match {
      case Circle(redius) => JsString(s"Circle($redius)")
    }
  }
  
  //defined syntax
  implicit class JsonWriter2Opt[A](a: A) {
    def toJson(implicit jw: JsonWriter2[A]): Json = jw format a
  }
  
  val circle = Circle(2.0)
  println(circle.toJson)
  
}