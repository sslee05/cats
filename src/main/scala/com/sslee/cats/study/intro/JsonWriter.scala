package com.sslee.cats.study.intro

/**
 * type class 
 * 어떠한 행위의 기능을 modeling한 것
 * A => Json 으로의 행위 기능에 대한 modeling 으로 type parameter A 를 받는 trait로 표현됨 
 */
trait JsonWriter[A] {
  def format(a: A): Json
}