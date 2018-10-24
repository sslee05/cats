package com.sslee.cats.functor

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.util.Random
import scala.concurrent.Await
import scala.concurrent.duration._

/**
 * Future의 참조투명성에 대한 고찰 
 * Future는 미래연산에 대하여 참조 투명하지 않다.
 * 처리진행 중일 수 도 있으며, 실패할 수 도 있고, 성공할 수 도 있다.
 */
object FutureApp extends App {
  
  implicit val ec = ExecutionContext.global
  
  val future01: Future[(Int,Int)] = {
    val r = new Random(0L)
    
    //부작용을 가지는 계산에 대한 처리 
    val x = Future(r.nextInt())
    
    for {
      i <- x
      n <- x
    } yield(i,n)
  }
  
  val future02: Future[(Int,Int)] = {
    val r = new Random(0L)
    
    // x 를 Future(r.nextInt()) 로 치환하여 참조투명성을 확인 한다.
    for {
      i <- Future(r.nextInt())
      n <- Future(r.nextInt())
    } yield(i,n)
  }
  
  println(Await.result(future01, 1 seconds))
  println(Await.result(future02, 1 seconds))
}