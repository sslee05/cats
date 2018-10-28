package com.sslee.cats.functor

import scala.concurrent.{Future,ExecutionContext}

/**
 * trait Functor[F[_]] {
 * 	def map[A,B](ma: F[A])(f: A => B): F[B]
 * }
 */
object FunctorApp extends App {
  
  
  import cats.Functor
  
  implicit val ec = ExecutionContext.global
  implicit def functorFuture(implicit ec: ExecutionContext): Functor[Future] = new Functor[Future] {
    def map[A,B](ma: Future[A])(f: A => B): Future[B] = ma map f 
  }

  //def apply[F[_]](implicit F: Functor[F]): Functor[F]
  //val fctFuture = Functor[Future](functorFuture)
  val futureFct = Functor[Future]
  
  implicit val functorOption: Functor[Option] = new Functor[Option] {
    def map[A,B](ma: Option[A])(f: A => B): Option[B] = ma map f
  }
  
  import cats.syntax.option._
  val optionFct =  Functor[Option].map(1.some)(_ + 2)
  println(optionFct)
  
}