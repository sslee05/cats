package com.sslee.cats.functor.exercise

object BranchFunctorApp extends App {
  
  //def apply[F[_]](implicit F: Functor[F]): Functor[F]
  /*
  import cats.Functor
  implicit class FunctorOps[F[_],A](ma: F[A]) {
    def map[B](f: A => B)(implicit F: Functor[F]): F[B] =
      F.map(ma)(f)
  }
  */
  
  import cats.instances.function._
  import cats.syntax.functor._
  val f = (i:Int) => i + 2
  val g = (i:Int) => s"num is $i"
  
  val tt = f.map(g)
  
  sealed trait Tree[+A]
  
  case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[A](value: A) extends Tree[A]
  
  import cats.Functor
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A,B](ma: Tree[A])(f: A => B): Tree[B] = ma match {
      case Branch(l,r) => Branch(map(l)(f),map(r)(f))
      case Leaf(v) => Leaf(f(v))
    }
  }
  
  //smart constructor를 생성한 이유는 Functor[F[_]] 가 invaraint 이기 때문이다.
  def branch[A](left: Tree[A], right:Tree[A]): Tree[A] = Branch(left,right)
  def leaf[A](a: A): Tree[A] = Leaf(a)
  
  val left01 = branch(leaf(1),leaf(2))
  val right01 = branch(leaf(3),leaf(4))
  val br = branch(left01,right01)
  
  val result = br.map(i => s"node value $i")
  println(result)
  
}