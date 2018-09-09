package com.sslee.cats.exercise.imap

trait Codec[A] { self =>
  def encode(a: A): String
  def decode(s: String): A
  
  def imap[B](en: B => A, de: A => B): Codec[B] = new Codec[B] {
    def encode(b: B): String = self.encode(en(b))
    def decode(s: String): B = de(self.decode(s))
  }
}