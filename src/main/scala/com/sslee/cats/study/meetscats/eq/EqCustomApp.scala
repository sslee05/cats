package com.sslee.cats.study.meetscats.eq

import java.util.Date

object EqCustomApp extends App {
  
  //Eq 
  import cats.Eq
  import cats.instances.long._
  import cats.syntax.eq._
  
  implicit val dateEq = Eq.instance[Date]((date1,date2) => date1.getTime === date2.getTime)
  
  val date1 = new Date()
  Thread.sleep(1000L)
  val date2 = new Date()
  
  println(date1 =!= date2)
  println(date1 === date1)
}