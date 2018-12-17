package lectures.part2oop


import java.sql.{Date => SqlDate}
import java.util.Date

import playground.{PrinceCharming, Cinderella => Princess}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val writer = new Writer("Daniel", "Rock the JVM", 2018)

  //import package
  //import or use fully qualified name
  val princess = new Princess

  //packages are in hierarchy
  //matching folder structure


  //package object (SCALA specific)
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming

  // 1. use FQ name
  val date = new Date
  val sqlDate = new SqlDate(2018, 5,4)

  //2 . use aliasing

  //default import
  //java.lang
  //scala - Int, Nothing, Function
  //scala.Predef  - println, ???


}
