package com.sslee.cats.variant

object CatsContravariantApp extends App {

  //Cats에는 cats.Contravariant cats instance를 제공
  //이는 B가 A의 subtype 인경우 B는 A로 변한할 수 있다.
  // F[A]는 F[B]의 subtype이 되고 F[A]은 F[B]로 변할 수 있다.
  trait MyContravariant[F[_]] {
    def contramap[A, B](ma: F[A])(f: B => A): F[B]
  }

  //Cats에서 cats.Invariant cats instance를 제공
  trait MyInvariant[F[_]] {
    def imap[A, B](ma: F[A])(f: A => B, g: B => A): F[B]
  }

  import cats.Show
  import cats.instances.string._
  import cats.functor.Contravariant
  
  val showString = Show[String]
  val showSymbol = Contravariant[Show].contramap(showString)((sym: Symbol) => s"'${sym.name}")
  println(showSymbol.show('david))

  import java.util.Date

  // import everything for simplicity:
  import cats._
  import cats.implicits._
  
  showString.contramap((sym: Symbol) => s"'${sym.name}")

  def longToDate: Long => Date = new Date(_)
  def dateToLong: Date => Long = _.getTime

  implicit val semigroupDate: Semigroup[Date] =
    Semigroup[Long].imap(longToDate)(dateToLong)

  val today: Date = longToDate(1449088684104l)
  val timeLeft: Date = longToDate(1900918893l)
  
  val test: Monoid[String] = 
    Monoid[Double].imap(_.toString)(_.toDouble)
}
