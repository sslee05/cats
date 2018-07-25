package com.sslee.cats.study.functor

import scala.util.Random
import scala.concurrent.{Future,Await}
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

object FutureExplorer extends App {
  
  implicit val ec = ExecutionContext.global
  
  val future01 = {
    
    val r = new Random(0L)
    
    //부작용을 가지는 계산에 대한 처리 
    val x = Future(r.nextInt())
    
    for {
      a <- x
      b <- x
    }yield(a,b)
    
  }
  
  val future02 = {
    val r = new Random(0L)
    for {
      //참조 투명을 검증하기 위해 x에 Future을 대입
      a <- Future(r.nextInt()) 
      b <- Future(r.nextInt())
    }yield(a,b)
  }
  
  println(Await.result(future01, 1 seconds))
  println(Await.result(future02, 1 seconds))
  
}