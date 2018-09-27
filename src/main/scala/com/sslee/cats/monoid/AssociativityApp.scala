package com.sslee.cats.monoid

import cats.Monoid

object AssociativityApp extends App {
  
  def associativeLaw[A](a: A, b: A, c: A)(implicit monoid: Monoid[A]): Boolean = 
    monoid.combine(a, monoid.combine(b, c)) == monoid.combine(monoid.combine(a, b), c)
  
  def identityLaw[A](a: A)(implicit monoid: Monoid[A]): Boolean = 
    monoid.combine(a, monoid.empty) == a
}