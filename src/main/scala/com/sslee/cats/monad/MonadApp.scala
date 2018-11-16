package com.sslee.cats.monad

object MonadApp {

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A,B](ma: F[A])(f: A => F[B]): F[B]

    //Monad 는 Funtor이다 따라서 pure와 flatMap으로 map를 제공할 수 있엉야 한다.
    def map[A,B](ma: F[A])(f: A => B): F[B] = flatMap(ma)(a => pure(f(a)))
  }

  //Left 항등법칙
  //pure(a).flatMap(f) == f(a)

  //right 항등법칙
  //ma.flatMap(pure) == ma

  //associativity 결합법칙
  //ma.flatMap(f).flatMap(g) == ma.flatMap(a => f(a).flatMap(g))
}
