package com.sslee.cats.monoid

import cats.Monoid

object MonoidInstanceApp extends App {
  
  //Boolean 에 대한 연산 or
  implicit val booleanOr = new Monoid[Boolean] {
    def empty: Boolean = false
    def combine(a: Boolean, b: Boolean): Boolean = a || b
  }
  
  import cats.syntax.monoid._
  
  val f = (a: Int) => a > 10
  val g = (a: Int) => a > 20
  
  println(f(11) |+| g(12))
  
  /*
   * Boolean 에 대한 연산 and
  implicit val booleanAnd = new Monoid[Boolean] {
    def empty: Boolean = true
    def combine(a: Boolean, b: Boolean): Boolean = a && b
  }
  */
  
  //Set 에 대한 union 연산 
  implicit def setUnion[A] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty[A]
    def combine(ma: Set[A], mb: Set[A]): Set[A] = ma union mb
  }
  
  val ma = Set(1,2,3,4,5)
  val mb = Set(6,7,8,9,10)
  println(ma |+| mb)
  
  /* 
   * Set 에 대한 diff 연산 
  implicit def ymmetriDiffSetMonoid[A] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty[A]
    def combine(ma: Set[A], mb: Set[A]): Set[A] = (ma diff mb) union (mb diff ma)
  }
  */
  
}