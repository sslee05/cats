package com.sslee.cats.exercise.contramap

trait Printable[A] { self =>
  def format(a: A): String
  
  def contramap[B](f: B => A): Printable[B] = new Printable[B] {
    def format(b: B): String = self.format(f(b))
  }
}

