package com.sslee.cats.monad

object MonadCatsApp extends App {

  //##### cats Instance
  //Monad[F[_]] extends FlatMap[F] with Applicative[F]
  // FlatMap으로 부터 flatMap method
  // Applicative으로 부터 pure, map method
  import cats.Monad
  import cats.instances.list._
  import cats.instances.option._ //for Monad

  val opt1 = Monad[Option].pure(3)
  val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))
  val opt3 = Monad[Option].map(opt2)(a => a * 100)
  

  val list1 = Monad[List].pure(3)
  val list2 = Monad[List].flatMap(List(1,2,3))(a => List(a, a * 10))
  val list3 = Monad[List].map(list2)(a => a + 123)

  //주의 Future인경우 implicit 가 필요한데 ExecutionContext 이것이 scope에 없으면
  //cats.instances.future를 해도 implicit Monad[Future]가 없다고 한다.
  import scala.concurrent.Future
  import cats.instances.future._
  import scala.concurrent.ExecutionContext.Implicits.global

  val futureMonad: Monad[Future] = Monad[Future]
  val future: Future[Int] = Monad[Future].pure(1)

  //3개의 cats.syntax에서 얻는다.
  //cats.syntax.flatMap //flatMap
  //cats.syntax.functor //map
  //cats.syntax.applicative //pure

  //1나의 import으로 가능
  //cats.implicits

  //##### cats Syntax
  import cats.syntax.applicative._
  val op4: Option[Int] = 1.pure[Option]
  val rs: List[Int] = 1.pure[List]

  //flatMap이나 map같은 경우는 pure 와 같이 쉽게 할 수 가 없다.
  //왜냐면 type에 맞는 연산이 정의된 implicit가 없기 때문이다.
  import cats.syntax.flatMap._ //for flatMap
  import cats.syntax.functor._ //for map
  def sum[F[_]: Monad](ma: F[Int], mb: F[Int]): F[Int] =
    ma.flatMap(a => mb.map(b => a * b))

  val r = sum(Monad[Option].pure(2), Option(5))
  println(r)

  val rs2:List[Int] = sum(List(1,2,3), Monad[List].pure(5))
  println(rs2)

  //now work sum(1,2)
  // type Id[A] = A
  // cats에서 Id 제공
  import cats.Id
  import cats.instances.int._
  val rs3:Int = sum(3: Id[Int], 5: Id[Int])
  println(rs3)

  val ex01:Id[Int] = 1
  val ex02:Id[String] = "abcd"
  val rs4:Int = Monad[Id].pure(2).flatMap(i => i * 5)
  val rs5:Id[Int] = Monad[Id].pure(2).flatMap(i => i * 5)

  import cats.syntax.eq._
  println(rs4 === rs5)

}
