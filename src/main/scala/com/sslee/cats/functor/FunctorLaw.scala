package com.sslee.cats.functor

object FunctorLaw extends App {
  
  val xs = List(1,2,3,4,5)
  
  //1. identity law : ma map idFunction = ma
  def identityFn[A]: A => A = a => a
  
  import cats.Functor
  import cats.instances.list._
  
  //object Functor
  //def apply[F[_]](implicit instance: Functor[F]): Functor[F]
  val functor = Functor[List]
  
  import cats.syntax.eq._
  import cats.instances.int._
  
  println(functor.map(xs)(identityFn) === xs)
  
  //2. Composition law: 
  // ma map f map g == ma map ( f compose g)
  
  //Composition Law
  val fn01 = (i: Int) => i * 2
  val fn02 = (i: Int) => s"[$i]"
  
  import cats.instances.string._
  import cats.instances.list._
  
  import cats.syntax.functor._
  //List 의 경우 map method가 있어 List의 map method가 적용된다.
  //따라서 다음과 같이 꽁수를 적용 하면 List의 map method적용이 아닌 cats.Functor map method가 적용된다.
  def ConvertForth[F[_]](src: F[Int])(implicit F: Functor[F]): F[Int] = 
    src.map(i => i) // cats.syntax.functor._ 가 있어야 된다.
  
  //functor.map(functor.map(xs)(fn01))(fn02) === ConvertForth(xs).map(fn02 compose fn01)
  println((xs map fn01 map fn02) === ConvertForth(xs).map(fn02 compose fn01))
  
  /* cats.syntax.functor._ 에서 아마도 
  implicit class MyFunctorOps[F[_],A](ma: F[A]) {
    def map[B](f: A => B)(implicit functor: Functor[F]): F[B] =
      functor.map(ma)(f)
  }
  */
  
}