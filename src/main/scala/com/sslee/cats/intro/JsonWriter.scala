package com.sslee.cats.intro

/**
 * type class 역할로 어떠한 행위에 대한 modeling
 * type parameter를 1개를 가지는 trait 구조 
 */
trait JsonWriter[A] {
  def format(a: A): Json
}