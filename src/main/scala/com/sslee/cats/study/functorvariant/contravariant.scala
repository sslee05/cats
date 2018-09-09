package com.sslee.cats.study.functorvariant

object contravariant extends App {
  
  import cats.functor.Contravariant
  import cats.Show
  import cats.Show._
  
  val showString:Show[String] = show[String](s => s"|$s|")
  val showDouble:Show[Double] = Contravariant[Show].contramap[String,Double](showString)(d => d.toString)
  println(showDouble.show(2.5))
  
  val showSymbol: Show[Symbol] = Contravariant[Show].contramap[String, Symbol](showString)(sym => sym.name)
  println(showSymbol.show('hiRoo))
  
}