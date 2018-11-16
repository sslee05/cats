package com.sslee.cats.monad.exercise

object IdMonad extends App {

  import cats.Monad
  import cats.Id

  def pure[A](a: A): Id[A] = a
  def flaMap[A,B](ma: Id[A])(f: A => Id[B]):Id[B] = f(ma)
  def map[A,B](ma: Id[A])(f: A => B):Id[B] = f(ma)

  /* trait Monad[F[_]] extends FlatMap[F] with Applicative[F]
   *FlatMap의 tailRecM method를 구현 해야 함.
  val idMonad = new Monad[Id] {
    def flatMap[A,B](ma: Id[A])(f: A => Id[B]): Id[B] = f(ma)
    def pure[A](ma: Id[A]): Id[A] = ma
    override def map[A,B](ma: Id[A])(f: A => B):Id[B] = flatMap(ma)(f)
  }
  */
}
