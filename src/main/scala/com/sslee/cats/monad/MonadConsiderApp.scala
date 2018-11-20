package com.sslee.cats.monad

object MonadConsiderApp extends App {

  //Cats에서 제공하는 asRight, asLeft를 이용하면 Either type에 대한
  //연산시 type에 대한 문제를 해결할 수 있다.

  //Either 는 2.12 version 이후로 map, flatMap을 가지고 있어 for-comprehension
  //을 할 수 있다.
  val right01 = Right(1)
  val right02 = Right(2)
  val right03 = Right(3)
  val left04 = Left(0)

  val r01: Either[Nothing, Int] = for {
    x <- right01
    y <- right02
    z <- right03
  } yield x + y + z // Right(6)

  /*
  val r02 = for {
    x <- right01
    y <- left04
    z <- right02
  } yield x + y + z
  */

  val xs = List(1,2,3,4,5)
  val rs = xs.foldLeft[Either[Int,Int]](Right(0))((acum, i) =>
    if(i < 3) acum.map(n => i + n)
    else Left(-1)
  )

  println(rs)
  /*
  val rs02 = xs.foldLeft(Right(0))((acum , i) =>
    if(i > 3) acum.map(n => n + i)
    else Left(-1)
  )
  */

  import cats.syntax.either._
  val tt = 0.asRight[Int]

  val rs02 = xs.foldLeft(0.asRight[Int])((acum, i) =>
    if(i < 3) acum.map(n => n + i)
    else -1.asLeft[Int]
  )
  println(rs02)

}
