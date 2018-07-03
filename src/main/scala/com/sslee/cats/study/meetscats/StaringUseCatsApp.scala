package com.sslee.cats.study.meetscats

object StaringUseCatsApp extends App {
  
  val usingCase01: String = {
    import cats._
    import cats.instances.all._
    //import cats.syntax.all._
  
    val intShow = Show.apply[Int]
    intShow show 123
  }
  
  val usingCase02: String = {
    import cats.instances.all._
    import cats.syntax.all._
    
    123.show
  }
  
  val usingCase03: String = {
    import cats._
    import cats.implicits._
    
    val intShow = Show.apply[Int]
    intShow show 123
  }
  
  val usingCase04: String = {
    import cats.implicits._
    
    123.show
  }
  
  println(s"using defined type class and type class intances result is $usingCase01")
  println(s"using type class and interface syntax result is $usingCase02")
  println(s"import using implicits(instances + interface syntax) $usingCase03")
  println(s"using interface syntax import only(implicits) $usingCase04")
  
  
}

