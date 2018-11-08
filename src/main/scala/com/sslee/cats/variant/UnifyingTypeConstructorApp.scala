package com.sslee.cats.variant

object UnifyingTypeConstructorApp extends App {
  
  /*
   trait Functor[F[_]] 처럼 F[_] type constructor는 
   parameter 인자가 1개 하지만 Function은 아래와 같이 두개 
   trait Function1[-A,+B] 이는 다음과 같이 해결 
   type F[A] = Int => A
   type F[A] = A => Double
   compiler는 Int => A 로 올바로 인식 하며 이를 위해 build.sbt에 
   -Ypartial-unification option을 주어야 한다.
   */
  
  // Left-Right Elimination (left to right 소거법)
  // compiler는 기본적으로 Left 에서 Right로 
  // type F[A] = Int => A
  // fn01 map fn02 == fn01 andThen fn02
  import cats.instances.function._ //for functor
  import cats.syntax.functor._ //for map
  
  val fn01: Int => Double = i => i.toDouble
  val fn02: Double => String = d => d.toString
  
  val fn03: Int => String = fn01 map fn02
  
  // contramap 인경우는 Left-Right Elimination으로 하면 안된다.
  //contrmap not member of Int => String
  //왜냐면 Left => Right Elimination이 기본이기 때문에 
  //fn02 contramap fn01 == fn02 compose fn01
  //fn02.contramap(fn01) //compile error
  
  import cats.syntax.contravariant._
  type <=[B,A] = A => B
  //type F[A] = Double <= A
  val fn04: String <= Double = fn02
  val fn05: String <= Int = fn04 contramap fn01
  
}