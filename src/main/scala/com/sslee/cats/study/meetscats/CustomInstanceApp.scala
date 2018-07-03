package com.sslee.cats.study.meetscats

import java.util.Date

object CustomInstanceApp extends App {
  import cats._
  implicit val notUsedHelperMethod: Show[Date] = {
    //import cats._
    
    new Show[Date] {
      def show(date: Date): String = s"${date.getTime}ms"
    }
  }
  
  //import cats.syntax._
  
  val date = new Date()
  val dateShow = Show.apply[Date]
  println(dateShow.show(date))
  
  
  
}