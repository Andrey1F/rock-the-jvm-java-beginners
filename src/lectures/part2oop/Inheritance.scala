package lectures.part2oop

object Inheritance extends App{
  class Animal{
    protected val creatureType = "wild"
    protected def eat = println("omnomnom")
  }

  //single class inheritance

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat

  cat.crunch

  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat: Unit = println("omnomnom")
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

}
