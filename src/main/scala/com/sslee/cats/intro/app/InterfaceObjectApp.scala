package com.sslee.cats.intro.app

import com.sslee.cats.intro.Person

object InterfaceObjectApp extends App {
  
  import com.sslee.cats.intro.Json
  import com.sslee.cats.intro.JsonWriterInstances._
  
  val person = Person("sslee", "sslee@gmail.com",10)
  val jsValue = Json toJson person
  println(jsValue)
}