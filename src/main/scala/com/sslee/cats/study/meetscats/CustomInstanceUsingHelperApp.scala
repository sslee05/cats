package com.sslee.cats.study.meetscats

import cats.Show
import java.util.Date

object CustomInstanceUsingHelperApp extends App {
  
  import cats._
  implicit val dateShowInstance: Show[Date] = Show.show(date => s"${date.getTime}ms")
  
  import cats.syntax.all._
  
  val date = new Date()
  println(date.show)
  
}