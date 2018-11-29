package com.sslee.cats.monad

/*
 Eager : 즉시 평가
 Lazy  : 실행시 평가
 Memozied : 실행시 평가 이후 cached
 */
object EvalMonad extends App {

  import cats.Eval
  val greeting: Eval[String] = Eval.always{ println("Step 01"); "Hellow";}.map{s => println("Step 02"); s"$s world";}
  println("start evaluation")
  println(greeting.value)
  println(greeting.value)

  println("############")

  val ans: Eval[Int] = for {
    a <- Eval.now{ println("Step01"); 10}
    b <- Eval.always{println("Step02"); 5}
  } yield {
    println("Add A and B");
    a + b
  }

  println("start evaluation")
  println(ans.value)
  println(ans.value)

  println("############")

  val saying = Eval.always{ println("Step01"); "The cat"}
    .map{s => println("Step02"); s" $s sat on"}.memoize
    .map{s => println("Step03"); s"$s the mat"}

  println("start evaluation")
  println(saying.value)
  println(saying.value)

}
