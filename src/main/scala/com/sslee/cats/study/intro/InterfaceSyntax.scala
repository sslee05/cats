package com.sslee.cats.study.intro

/**
 * type class interfaces 을 제공하는 방법중 interface syntax 방법
 * interface 기능인 toJson를 interface syntax방법으로 제공 
 * 
 */
object InterfaceSyntax {
  implicit class JsonWriterOpt[A](a: A) {
    def toJson(implicit jw: JsonWriter[A]): Json = jw.format(a)
  }
}