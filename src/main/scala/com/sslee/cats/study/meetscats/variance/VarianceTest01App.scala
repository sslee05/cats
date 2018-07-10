package com.sslee.cats.study.meetscats.variance

import com.sslee.cats.study.intro._

object VarianceTest01App extends App {
  
  trait Shape
  case class Circle(radius: Double) extends Shape
  
  //defined type class
  trait JsonWriter[-A] {
    def format(a: A): Json
  }
  
  //instance
  /*
  implicit val circleWriter = new JsonWriter[Circle] {
    def format(circle: Circle): Json = circle match {
      case Circle(radius) => JsString(s"Circle(${radius.toString})")
    }
  }
  */
  
  implicit val shapeWriter = new JsonWriter[Shape] {
    def format(shape: Shape): Json = shape match {
      case Circle(radius) => JsString(s"Circle(${radius.toString})")
    }
  }
  
  implicit class shapeOpts[A](a: A) {
    def toJson(a: A)(implicit jw: JsonWriter[A]): Json = jw.format(a) 
  }
  
  val circle = Circle(2.0)
  println(circle.toJson(circle))
  
  
}