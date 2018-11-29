package com.sslee.cats.monad

/*
 Eager : 즉시 평가
 Lazy  : 실행시 평가
 Memozied : 실행시 평가 이후 cached
 */
object EvalMonad extends App {

  //vals = eager + memozied
  val x = {
    println("Computing x")
    math.random()
  }

  println(x)
  println(x)
  println(x)

  //def = lazy + not memozied
  def y = {
    println("Computing y")
    math.random()
  }

  println(y)
  println(y)
  println(y)

}
