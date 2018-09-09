package com.sslee.cats.exercise.functor

object Exercise354 extends App {

  trait Tree[+A]

  case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[+A](value: A) extends Tree[A]

  object Tree {
    def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
      Branch(left, right)

    def leaf[A](value: A): Tree[A] = Leaf(value)
  }

  import cats.Functor

  implicit val treeFunctor = new Functor[Tree] {
    def map[A, B](ma: Tree[A])(f: A => B): Tree[B] = ma match {
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
      case Leaf(value)         => Leaf(f(value))
    }
  }

  val b01 = Tree.branch(Leaf(1), Leaf(2))
  val b02 = Tree.branch(Leaf(3), Leaf(4))
  val b03 = Tree.branch(b01, b02)

  import cats.syntax.functor._
  
  val bTree = b03.map(a => a + "!")
  println(bTree)

}