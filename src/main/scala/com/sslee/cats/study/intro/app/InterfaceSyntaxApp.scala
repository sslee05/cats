package com.sslee.cats.study.intro.app

import com.sslee.cats.study.intro.domain.Person

object InterfaceSyntaxApp extends App {
  
  import com.sslee.cats.study.intro.JsonWriterInstances._
  import com.sslee.cats.study.intro.InterfaceSyntax._
  
  val person = Person("sslee", "sslee@gmail.com", 10)
  val jsValue = person.toJson
  
  println(jsValue)
}