package com.sslee.cats.exercise.contramap

object PrintableSyntax {
  
  implicit class PintableOpt[A](a: A) {
    def format2(implicit pt: Printable[A]): String = pt format a
  }
}