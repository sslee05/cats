package com.sslee.cats.functor

object ContramapApp extends App {
  
  // F[A].contramap(f: B => A): F[B]
  
  trait Printable[A] { self =>
    def format(a: A): String
    def contrmap[B](f: B => A): Printable[B] = new Printable[B] {
      def format(b: B): String = self.format(f(b))
    }
  }
  
  implicit val stringPrintable:Printable[String] = new Printable[String] {
    def format(a: String): String = s"/$a/"
  }
  
  implicit val booleaPrintable:Printable[Boolean] = new Printable[Boolean] {
    def format(a: Boolean): String = if(a) "YES" else "NO"
  }
  
  case class Box[A](value: A)
  
  implicit def boxPrintable[A](implicit printable: Printable[A]) = new Printable[Box[A]] {
    def format(ma: Box[A]): String = ma match {
      case Box(a) => printable.format(a)
    }
  }
  
  implicit def boxPrintableViaContramap[A](implicit printable: Printable[A]): Printable[Box[A]] = 
    printable.contrmap[Box[A]](_.value)
  
  stringPrintable.format("abc")
  booleaPrintable.format(true)
  boxPrintable(stringPrintable).format(Box("abc"))
}