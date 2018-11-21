package com.sslee.cats.monad


import scala.util.Try

object EitherCaseApp extends App {

  val right01 = Right(1)
  val right02 = Right(2)
  val right03 = Right(3)
  val left04 = Left("not Supported")

  val case01 = for {
    x <- right01
    y <- right02
    z <- right03
  } yield(x + y + z)

  println(case01)

  /*
  val case02 = for {
    x <- right01
    y <- left04
    z <- right02
  } yield(x)
  */

  val xs = List(1,2,3,4,5)
  val rs01 = xs.foldLeft[Either[String,Int]](Right(0))((acum, i) => if(i < 3) acum.map(n => n + i) else Left("Not Supported"))
  println(rs01)

  //compile error
  //1.Either가 아닌 Right로 type를 추론 하기 때문에
  //2.Right의 left type parameter type를 Nothing으로 추론하기 때문에
  //xs.foldLeft(Right(0))((acum,i) => if(i < 3) acum.map(n => n + 1) else Left("Not Supported"))

  import cats.syntax.either._
  // asRight[LeftT]  asLeft[RightT]
  val rs02 = xs.foldLeft(0.asRight[String])((acum, i) => if(i < 3) acum.map(n => n + i) else "Not Supprted".asLeft[Int])
  println(rs02)

  //cats.syntax.either
  // final class EitherObjectOps(val either: Either.type) catchOnly가 있다.
  val rs03 = Either.catchOnly[NumberFormatException]("foo".toInt)
  println(rs03)
  //Left(java.lang.NumberFormatException: For input string: "foo")

  //def catchNonFatal[A](f: => A): Either[Throwable, A]
  val rs04 = Either.catchNonFatal(sys.error("Occur error"))
  println(rs04)
  //Left(java.lang.RuntimeException: Occur error)

  //fromTry[A](t: Try[A]): Either[Throwable, A]
  val rs05 = Either.fromTry(Try("foo".toInt))
  println(rs05)
  //Left(java.lang.NumberFormatException: For input string: "foo")

  //def fromOption[A, B](o: Option[B], ifNone: => A): Either[A, B]
  val rs06 = Either.fromOption[String,Int](None, "Oops!")
  println(rs06)
  //Left(Oops!)

  //Transforming Eithers
  //1. orElse, 2. getOrElse
  val rs07 ="Error".asLeft[Int].getOrElse(0)
  println(rs07) //0
  val rs08 = "Error".asLeft[Int].orElse(3.asRight[String])
  println(rs08) //Right(3)

  //ensure Right value check
  val rs09 = -1.asRight[String].ensure("must not be negative value")(i => i >= 0)
  println(rs09)

  //recover, recoverWith
  val rs10 = "Error".asLeft[Int].recover{
    case _: String => -1
  }
  println(rs10)
  //Right(-1)

  val rs11 = "Error".asLeft[Int].recoverWith {
    case _: String => Right(-1)
  }
  println(rs11)
  //Right(-1)

  //leftMap, bimap
  val rs12 = "leftMap".asLeft[Int].leftMap(_.reverse)
  println(rs12)//Left(paMtfel)

  val rs13 = 5.asRight[String].bimap(msg => msg.reverse, i => i * 10)
  val rs14 = "leftMap".asLeft[Int].bimap(ms => ms.reverse, i => i * 10)
  println(rs13)//Right(50)
  println(rs14)//Left(paMtfel)

  //swap
  val rs15 = "foo".asLeft[Int].swap
  println(rs15)//Right(foo)

  //Error Handling
  val rs16 = for {
    x <- 1.asRight[String]
    y <- 0.asRight[String]
    z <- if(y == 0) "must not be divide value zero".asLeft[Int] else (x / y).asRight[String]
  } yield z * 100

  println(rs16)

  // Error handling를 할때 type를 결정해야 할 때가 있다.
  // Either[Throwable, A]
  // 하지만 Throwable은 너무 광범위 하다.

  sealed trait LoginError

  final case class UserNotFound(userName: String) extends LoginError
  final case class PasswordIncorrect(userName: String) extends LoginError
  final object UnexpectError extends LoginError

  case class User(userName: String, password: String)

  type LoingResult = Either[LoginError, User]

  def handleError(error: LoginError): Unit = error match {
    case UserNotFound(name) => println(s"User not found $name")
    case PasswordIncorrect(name) => println(s"Password incorrect: $name")
    case UnexpectError => println(s"Unexpected Error")
  }

  val result01 = User("testUser", "passw0rd").asRight
  val result02 = UserNotFound("testUser").asLeft
  println(result01)
  println(result02)

  result01.fold(handleError, println)
  result02.fold(handleError,println)

}
