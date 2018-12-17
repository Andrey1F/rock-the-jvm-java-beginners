package lectures.part1basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int) : Int= {
    if (n<=0) 1
    else {
      println("Computing factorial of " + n + "I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }


  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def facHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x<=1) accumulator
      else facHelper(x-1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression
    }
    facHelper(n, 1)
  }


  //WHEN YOU NEED LOOPS USE _TAIL_ RECURSION

  def concat(string: String, n: Int): String = {
    def concatHelper(string: String, n: Int, accumulator: String): String = {
      if (n<=1) accumulator
      else concatHelper(string, n-1, accumulator + string)
    }
    concatHelper(string, n, string)
  }

  println(concat("Hello", 3))

  def isPrime(n: Int): Boolean = {
    def check(n: Int, m: Int): Boolean = {
      if (m==1) true
      else (n%m != 0) && check(n, m-1)
    }
    check(n, n-1)
  }

  def fibo(n: Int): BigInt = {
    def fiboHelper(m: Int, accumulator1: BigInt, accumulator2: BigInt): BigInt ={
      if (m==n) accumulator1+accumulator2
      else fiboHelper(m+1, accumulator2, accumulator1+accumulator2)
    }
    if (n<=2) 1
    else fiboHelper(3, 1,1)

  }

  println(fibo(8))

}
