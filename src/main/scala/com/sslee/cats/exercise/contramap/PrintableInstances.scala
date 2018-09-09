package com.sslee.cats.exercise.contramap

object PrintableInstances {
  
  implicit val stringPrintable = new Printable[String] {
    def format(value: String): String = s"/$value/"
  }
  
  implicit val booleanPrintable = new Printable[Boolean] {
    def format(value: Boolean): String = if(value) "YES" else "NO"
  }
  
  /*
  implicit def boxPrintable[A](implicit pt: Printable[A]) = new Printable[Box[A]] {
    def format(box: Box[A]): String = pt format box.value
  }
  */
  
  implicit def boxPrintableViaContramap[A](implicit pt: Printable[A]) = 
    pt.contramap[Box[A]](box => box.value)
  
  implicit val intPrintable = new Printable[Int] {
    def format(i: Int): String = s"Value is ${i.toString}"
  }
}