package com.sslee.cats.exercise.intro

object PrintableSyntax {
  implicit class PrintableOpt[A](a: A) {
    def format(implicit pt: Printable[A]): String = pt format a
    def print(implicit pt: Printable[A]): Unit = println(pt format a)
  }
}