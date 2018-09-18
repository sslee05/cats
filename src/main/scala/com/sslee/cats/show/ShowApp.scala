package com.sslee.cats.show

/**
 * 텍스트 표현을 제공하기위한 타입 클래스입니다. 
 * 더 나은 "toString"을위한 것입니다. 
 * 클래스의 작성자가 명시 적으로 toString 메소드를 작성했는지 여부에 관계없이 toString이 모든 Object에 대해 존재하는 반면, 
 * Show 인스턴스는 명시 적으로 제공 한 경우에만 존재합니다.
 */
object ShowApp extends App {
  
  val usingCase01: String = {
    import cats.Show
    import cats.instances.int._
    
    val case01 = Show[Int]
    case01 show 123
  }
  
  val usingCase02: String = {
    import cats.instances.int._
    import cats.syntax.show._
    
    123.show
  }
  
  val usingCase03: String = {
    import cats.Show
    import cats.implicits._
    
    val intShow = Show.apply[Int]
    intShow show 123
  }
  
  val usingCase04: String = {
    import cats.implicits._
    
    123.show
  }
  
  println(s"using defined type class and type class intances result is $usingCase01")
  println(s"using type class intstance and interface syntax result is $usingCase02")
  println(s"import using type class and implicits(instances + interface syntax) $usingCase03")
  println(s"using type class instance and interface syntax import only(implicits) $usingCase04")
  
  
  
}