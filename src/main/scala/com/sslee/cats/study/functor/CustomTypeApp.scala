package com.sslee.cats.study.functor

object CustomTypeApp extends App {
  
  import cats.Functor
  
  implicit val optionFunctor = new Functor[Option] {
    def map[A,B](ma: Option[A])(f: A => B): Option[B] = ma map f
  }
  
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext
  
  implicit def functorFunctor(implicit ec: ExecutionContext) = new Functor[Future] {
    def map[A,B](ma: Future[A])(f: A => B): Future[B] = ma map f  
  }
}