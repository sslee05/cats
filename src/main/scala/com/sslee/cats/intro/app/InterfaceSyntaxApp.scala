package com.sslee.cats.intro.app

import com.sslee.cats.intro.Person

object InterfaceSyntaxApp extends App {
  
  import com.sslee.cats.intro.JsonWriterInstances._
  import com.sslee.cats.intro.JsonWriterInterfaceSyntax._
  
  val person = Person("sslee","sslee@gmail.com",10)
  
  val jsValue = person.toJson
  println(jsValue)
  
  //JsWriter의 type parameter가 invariant 이기 때문에 
  // o 의 type를 Option으로 명시적으로 선언 해야 한다.
  val o: Option[String] = Some("hellow")
  val optionJsValue = o.toJson
  println(optionJsValue)
}