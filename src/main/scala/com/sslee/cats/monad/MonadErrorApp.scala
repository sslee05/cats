package com.sslee.cats.monad

object MonadErrorApp extends App {

  /* MonadError Type class
  trait MonadError[F[_], E] extends Monad[F] {
    def raiseError[A](e: E): F[A]
    def handleError[A](fa: F[A])(f: E => A): F[A]

    def ensure[A](ma: F[A])(e: => E)(f: A => Boolean): F[A]
    def pure[A](a: A): F[A]
    ...
  }
  */

  import cats.MonadError
  import cats.instances.either._

  type ErrorOr[A] = Either[String, A]
  val monadError = MonadError[ErrorOr,String]

  val success: ErrorOr[Int] = monadError.pure(42)
  val failure: ErrorOr[Nothing] = monadError.raiseError("Badness")


  val rs: ErrorOr[ErrorOr[String]] = (monadError handleError failure) {
    case "Badness" => monadError.pure("It Ok")
    case _ => monadError.raiseError("It not Ok")
  }

}
