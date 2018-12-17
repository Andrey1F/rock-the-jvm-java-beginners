package lectures.part1basics

object Functions extends App{

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def repeatedFunction(a: String, n: Int) : String = {
    if (n==1) a
    else a + repeatedFunction(a, n-1)
  }

  println(repeatedFunction("hello", 3))

  //WHEN YOU NEED LOOPS, USE RECURSION

  def greeting(name: String, age: Int) : String = {
    s"Hi, my age is $age and my name is $name"
  }

  def factorial(n: Int): Int = {
    if (n==1) n
    else n * factorial(n-1)
  }

  def fiboFunction(n: Int): Int = n match {
    case 1 => 1
    case 2 => 1
    case _ => fiboFunction(n-1) + fiboFunction(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def check(n: Int, m: Int): Boolean = {
      if (m==1) true
      else (n%m != 0) && check(n, m-1)
    }
     check(n, n-1)
  }

  println(greeting("Andrey", 35))
  println(factorial(5))
  println(fiboFunction(8))
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))

}
