package lectures.part2oop

import exercises.{Cons, EmptyList, MyList}


object Exceptions extends App {

  val x: String = null
//  println(x.length)
//  this ^^ will crash with NPE

  // 1. throwing and catching exceptions

//  val aWeirdValue = throw new NullPointerException

  //throwable classes extend  Throwable class
  //Exception and Error are the major throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    //code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime Exception")
  } finally {
    //code that will get executed NO MATTER WHAT
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("finally")
  }

  // 3. how to define your own exceptions
/*  class MyException extends Exception
  val exception = new MyException

  throw exception*/
  //OOM
  //val array = Array.ofDim(Int.MaxValue )

  //SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if  (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide (x: Int, y: Int) = {
      if (y==0) throw new MathCalculationException
      else x / y
    }

  }





}
