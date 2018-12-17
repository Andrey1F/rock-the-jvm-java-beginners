package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  //println(person.greet("Sam"))
  //person.greet("Damyen")
  //person.greet

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  val reissue = novel.copy(1999)

  //println(reissue.authorAge)

  val counter = new Counter

  counter.increment.print
  counter.increment(10).print




}

class Person(name: String, val age: Int) {
  val x = 2
  println(1+3)

  def greet(name: String): Unit = println(s"${this.name} says: Hello, $name")

  //overloading
  def greet(): Unit = println(s"Hello, $name")

  //multiple constructors
  def this(name: String) = this(name, 0)

  //class parameters are NOT FIELDS
}

class Writer(firstName: String, lastName: String, val birthYear: Int) {
  def fullname():String = firstName + " " + lastName
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge = releaseYear - author.birthYear

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newReleaseYear: Int) = new Novel (name, newReleaseYear, author)
}

class Counter(count: Int = 0) {
  def currentCount = count
  def increment = {
    println("incrementing")
    new Counter(count + 1)
  }
  def decrement = new Counter(count - 1)
  def increment(amount: Int) : Counter = {
    if (amount <= 0) this
    else increment.increment(amount - 1)
  }
  def decrement(amount: Int) = new Counter(count - amount)

  def print = println(count)
}
