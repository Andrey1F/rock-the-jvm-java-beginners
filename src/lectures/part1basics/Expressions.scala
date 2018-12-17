package lectures.part1basics

object Expressions extends App{

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var aVariable = 2

  var i = 0
  while (i<10) {
    println(i)
    i += 1
  }

  //NEVER WRITE THIS AGAIN

  //EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3)

}
