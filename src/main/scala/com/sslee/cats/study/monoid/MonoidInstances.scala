package com.sslee.cats.study.monoid

import cats._

object MonoidInstances extends App {
  
  implicit val orMonoid = new Monoid[Boolean] {
    def empty = false
    def combine(a: Boolean, b: Boolean): Boolean = a || b
  }
  
  implicit val andMonoid = new Monoid[Boolean] {
    def empty = true
    def combine(a: Boolean, b: Boolean): Boolean = a && b
  }
  
  implicit def setUnionMonoid[A] = new Monoid[Set[A]] {
    def empty = Set.empty[A]
    def combine(ma: Set[A], mb: Set[A]): Set[A] = ma union mb
  }
  
  /*
  implicit val intAddMonoid = new Monoid[Int] {
    def empty = 0
    def combine(a: Int, b: Int): Int = a + b
  }
  */
  
  val intSetMonoid = Monoid[Set[Int]]
  val xs = Set(1,2)
  val ys = Set(2,3)
  println(intSetMonoid.combine(xs,ys))
  
  implicit def symmetriDiffSetMonoid[A] = new Monoid[Set[A]] {
    def empty = Set.empty[A]
    def combine(ma: Set[A], mb: Set[A]): Set[A] = (ma diff mb) union (mb diff ma)
  }
  
}