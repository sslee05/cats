package com.sslee.cats.exercise.imap

object CodecSyntax {
  
  implicit class CodecOpt[A](a: A) {
    def encode(implicit cd: Codec[A]): String = cd encode a
  }
  
  def decode[A](s: String)(implicit cd: Codec[A]): A = cd decode s 
  
}