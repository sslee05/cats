package com.sslee.cats.study.intro.app

import com.sslee.cats.study.intro.domain.Person

object InterfaceObjectApp extends App {
  
  import com.sslee.cats.study.intro.JsonWriterInstances._
  import com.sslee.cats.study.intro._
  
  val person = Person("sslee", "sslee@gmail.con", 10)
  val jsValue = Json toJson person
  println(jsValue)
  
}