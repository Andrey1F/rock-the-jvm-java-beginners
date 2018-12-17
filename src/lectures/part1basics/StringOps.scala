package lectures.part1basics

object StringOps extends App {
  val str: String = "Hi, I'm learning Scala"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" "))
  println(str.split(" ").toList)
  println(str.startsWith("Hi"))
  println(str.replace(" ", "_"))
  println(str.toLowerCase)
  println(str.length)



  val aNumberString: String = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)

  //Scala specific String interpolators

  //S-interpolator
  val name = "Dan"
  val age = 12
  val greeting = s"Hi, my name is $name and I'm $age years old"
  val anotherGreeting = s"I'm gonna be ${age + 1} years old soon"
  println(anotherGreeting)

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.3f burgers per minute"

  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")


}
