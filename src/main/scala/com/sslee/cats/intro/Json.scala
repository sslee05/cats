package com.sslee.cats.intro

sealed trait Json
case class JsString(get: String) extends Json
case class JsNumber(get: Double) extends Json
case class JsObject(get: Map[String,Json]) extends Json
case object JsNull extends Json


/**
 * type class interfaces 을 제공하는 방법중 interface object 방법
 * interface 기능인 toJson를 interface object방법으로 제공 
 */
object Json {
  def toJson[A](a: A)(implicit jsonWriter: JsonWriter[A]): Json = 
    jsonWriter.format(a)
}