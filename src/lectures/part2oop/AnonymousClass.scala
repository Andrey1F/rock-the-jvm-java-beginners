package lectures.part2oop

object AnonymousClass extends App {

  abstract class Animal {
    def eat :Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("fuuuun")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi = println(s"Hi, my name is Jim, bro")
  }


}
