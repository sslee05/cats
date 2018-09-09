package com.sslee.cats.intro

/**
 * type class instance : 특정 type 에대한 type class의 구현
 * 아래는 type class JsonWriter에 대한 String, Double, Person, Option[A]에 대한 
 * type class instance 이다.
 * 주로 val로 선언하며, 중첩된 일반적 유형이 존재시 def 로 하여 중첩된 일반적 유형을 처리 할 수 있게 
 * 하는 것이 일반적 이다. 
 */
object JsonWriterInstances {
  
  implicit val stringJsonWriter = new JsonWriter[String] {
    def format(s: String) = JsString(s)
  }
  
  implicit val numberJsonWriter = new JsonWriter[Double] {
    def format(n: Double) = JsNumber(n)
  }
  
  implicit val personJsonWriter = new JsonWriter[Person] {
    def format(p: Person): Json = p match {
      case Person(name, email, age) => 
        JsObject(Map("name" -> JsString(name), "email" -> JsString(email), "age" -> JsNumber(age))) 
    }
  }
  
  implicit def optionJsonWriter[A](implicit jsonWriter: JsonWriter[A]) = new JsonWriter[Option[A]] {
    def format(o: Option[A]): Json = o match {
      case Some(a) =>  jsonWriter.format(a)
      case None    =>  JsNull
    }
  }
}