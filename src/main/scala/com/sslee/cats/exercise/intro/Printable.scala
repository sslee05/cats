package com.sslee.cats.exercise.intro

trait Printable[A] {
  def format(a: A): String
}

object Printable {
  def format[A](a: A)(implicit pt: Printable[A]): String = pt format a
  def print[A](a: A)(implicit pt: Printable[A]): Unit = println(pt format a)
}