import cats.Monad
import cats.instances.option._
//import cats.instances.list._

val opt1 = Monad[Option].pure(3)
val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))
val opt3 = Monad[Option].map(opt2)(a => a * 100)


val right01 = Right(1)
val right02 = Right(2)
val right03 = Right(3)
val left04 = Left(0)

val test01 = for {
  i <- right01
  j <- right02
  k <- right03
} yield i + j + k

val test02 = for {
  i <- right01
  j <- left04
  k <- right02
} yield i + j + k


val xs = List(1,2,3,4,5)
xs.foldLeft[Either[Int,Int]](Right(0))((acum, i) => {
  if(i > 3) acum.map(n => i + n)
  else Left(-1)
})

import cats.syntax.either._
0.asRight[Int]

import cats.syntax.either._
val tt = 0.asRight[Int]

val rs02 = xs.foldLeft(0.asRight[Int])((acum, i) =>
  if(i < 3) acum.map(n => n + i)
  else -1.asLeft[Int]
)