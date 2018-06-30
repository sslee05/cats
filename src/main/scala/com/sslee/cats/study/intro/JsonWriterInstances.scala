package com.sslee.cats.study.intro

import com.sslee.cats.study.intro.domain.Person

/**
 * type class instance : 특정 type 에대한 type class의 구현
 * 아래는 type class JsonWriter에 대한 String, Double, Person, Option[A]에 대한 
 * type class instance 이다.
 * 주로 val로 선언하며, 중첩된 일반적 유형이 존재시 def 로 하여 중첩된 일반적 유형을 처리 할 수 있게 
 * 하는 것이 일반적 이다. 
 */
object JsonWriterInstances {
  
  
  implicit val stringJsonWriter = new JsonWriter[String] {
    def format(value: String): Json = JsString(value)
  }
  
  implicit val numberJsonWriter = new JsonWriter[Double] {
    def format(value: Double): Json = JsNumber(value)
  }
  
  implicit val personJsonWriter = new JsonWriter[Person] {
    def format(person: Person): Json = person match {
      case Person(name,email,age) => JsObject(Map("name" -> JsString(name), "email" -> JsString(email), "age" -> JsNumber(age)))
    }
  }
  
  implicit def optionJsonWriter[A](implicit jw: JsonWriter[A]) = new JsonWriter[Option[A]] {
    def format(option: Option[A]) = option match {
      case Some(a) => jw.format(a)
      case None => JsNull
    }
  }
  
}