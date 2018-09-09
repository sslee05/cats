package com.sslee.cats.exercise.imap

object ImapApp extends App{
  
  import CodecInstances._
  import CodecSyntax._
  
  import com.sslee.cats.exercise.contramap.Box
  
  println("aaa".encode)
  println(2.0.encode)
  println(Box(2.0).encode)
  
  println(decode[Double]("2.0"))
  println(decode[Box[String]]("hellow"))
  
}