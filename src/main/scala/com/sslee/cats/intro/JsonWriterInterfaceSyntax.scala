package com.sslee.cats.intro

/**
 * type class interfaces 을 제공하는 방법중 interface syntax 방법
 * interface 기능인 toJson를 interface syntax방법으로 제공 
 */
object JsonWriterInterfaceSyntax {
  
  implicit class JsonWriterOpt[A](a: A) {
    def toJson(implicit jsonWriter: JsonWriter[A]): Json = jsonWriter.format(a);
  }
}