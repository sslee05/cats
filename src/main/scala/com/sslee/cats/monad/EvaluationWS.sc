//eager    : 즉시 평가
//lazy     : 실행시 평가
//memoized : 실행시 평가 이후 cache

//vals = eager + memoized
val x = {
  println("Computing X")
  math.random()
}
println(x)
println(x)
println(x)

//def = lazy + not memoized
def y = {
  println("Computing Y")
  math.random()
}
println(y)
println(y)
println(y)

//lazy vals = lazy + memoized
lazy val z = {
  println("Computing Z")
  math.random()
}
println(z)
println(z)
println(z)

// cats Now = val
// cats Always = def
// cats Later = lazy
import cats.Eval
val cx = Eval.now(math.random())
val cy = Eval.always(math.random())
val cz = Eval.later(math.random())

println(cx.value)
println(cy.value)
println(cz.value)

println(cx.value)
println(cy.value)
println(cz.value)

import cats.Eval
val greeting = Eval.always{ println("Step 01"); "Hellow";}.map { s => println("Step 02"); s"$s world"
;}