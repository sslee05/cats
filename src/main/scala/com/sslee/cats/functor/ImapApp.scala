package com.sslee.cats.functor

object ImapApp extends App {
  
  trait Codec[A] { self =>
    def encode(a: A): String
    def decode(s: String): A
    
    def imap[B](f: A => B, g: B => A): Codec[B] = new Codec[B] {
      def encode(b: B): String = self.encode(g(b))
      def decode(s: String): B = f(self.decode(s))
    }
  }
  
  def encode[A](a: A)(implicit c: Codec[A]): String = c encode a
  def decode[A](s: String)(implicit c: Codec[A]): A = c decode s
  
  implicit val stringCodec: Codec[String] = new Codec[String] {
    def encode(a: String): String = a
    def decode(s: String): String = s 
  }
  
  // Error 처리가 되지 않음 
  implicit val intCodec: Codec[Int] = 
    stringCodec.imap(_.toInt, _.toString)
    
  //Error 처리가 되지 않음
  implicit val booleanCodec: Codec[Boolean] =
    stringCodec.imap(_.toBoolean, _.toString)
    
  implicit val doubleCodec: Codec[Double] = 
    stringCodec.imap(_.toDouble, _.toString)
    
  case class Box[A](value: A)
  
  def boxCodec_[A](implicit c: Codec[A]): Codec[Box[A]] = new Codec[Box[A]] {
    def encode(ma: Box[A]): String = c encode ma.value
    def decode(s: String): Box[A] = Box(c decode s)
  }
  
  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] = 
    c.imap(a => Box(a), b => b.value)
  
  import cats.Eq
  import cats.instances.double._
  import cats.instances.string._
  import cats.syntax.eq._
  
  implicit def boxEq[A](implicit e: Eq[A]) = Eq.instance[Box[A]]( (ma,mb) => e.eqv(ma.value, mb.value))
  
  println(encode[Double](123.4) === "123.4")
  println(decode[Double]("123.4") === 123.4)
  println(encode[Box[Double]](Box(123.4)) === "123.4")
  println(decode[Box[Double]]("123.4") === Box(123.4))
  
    
}