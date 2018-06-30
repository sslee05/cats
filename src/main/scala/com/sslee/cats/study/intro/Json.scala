package com.sslee.cats.study.intro

sealed trait Json
case class JsString(get: String) extends Json
case class JsNumber(get: Double) extends Json
case class JsObject(get: Map[String,Json]) extends Json
case object JsNull extends Json

/**
 * interfaces object 
 * function is toJson with type class JsonWriter
 */
object Json {
  def toJson[A](a: A)(implicit jw: JsonWriter[A]): Json = jw.format(a)
}